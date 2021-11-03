package com.abc.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.abc.myapp.model.StudentVO;
import com.abc.myapp.service.IStudentService;

@Controller
@RequestMapping("/admin/*")

public class AdminController {

	@Autowired
	IStudentService studentService;

	// 학생정보조회 리스트 페이지 studentList.jsp로 이동
//	@RequestMapping(value = "admin/admin/studentList", method = RequestMethod.GET)
//	public String getStudentListPage() {
//		return "admin/studentList";
//	}
	@RequestMapping("/admin/studentList")
	public void getAllStds(Model model) {
	   List<StudentVO> studentList = studentService.getStudentList();
	   model.addAttribute("studentList", studentList);
	}

	// 학생정보입력 페이지 studentInsert.jsp로 이동
	@RequestMapping(value = "/studentInsert", method = RequestMethod.GET)
	public String getStudentInsertPage() {
		return "admin/studentInsert";
	}

	// 학생정보입력 후 학생정보조회 리스트 페이지 studentList.jsp로 이동
	@RequestMapping(value = "/studentInsert", method = RequestMethod.POST)
	public String getAfterInsertPage(@RequestParam int studentId, @RequestParam String studentName,
			@RequestParam String emailId, @RequestParam String password, @RequestParam MultipartFile file) {

		try {
			if (file != null && !file.isEmpty()) {
				StudentVO student = new StudentVO();
				student.setStudentId(studentId);
				student.setStudentName(studentName);
				student.setEmailId(emailId);
				student.setPassword(password);
				student.setStudentImage(file.getBytes());
				studentService.insertStudent(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/studentList";
	}
	
	//학생 정보 입력 후 student_id 클릭 시 학생 상세 정보 페이지 studentView.jsp로 이동
	@RequestMapping(value="/admin/{studentId}", method=RequestMethod.GET)
	   public String getStdInfo(@PathVariable int studentId, Model model) {
		System.out.println(studentId);
	      StudentVO std = studentService.getStdInfo(studentId);   
	      model.addAttribute("student", std);
	      return "admin/studentView";
	   }
	
//	@RequestMapping(value="/admin/studentView", method=RequestMethod.POST)
//	   public String viewStudent(StudentVO std) {
//	      studentService.viewStudent(std);
//	      return "redirect:/admin/" + std.getStudentId();
//	   }
	
	
	@RequestMapping(value="/admin/studentUpdate", method=RequestMethod.GET)
	   public String updateStudent(int studentId, Model model) {
	      model.addAttribute("student", studentService.getStdInfo(studentId));
	      model.addAttribute("studentList", studentService.getAllStudentId());
	      return "admin/studentUpdate";
	   }
	   
	
	   @RequestMapping(value="/admin/studentUpdate", method=RequestMethod.POST)
	   public String updateStudent(StudentVO std) {
	      studentService.updateStudent(std);
	      return "redirect:/admin/" + std.getStudentId();
	   }
	   
	   
	   @RequestMapping(value="/admin/studentDelete", method=RequestMethod.GET)
	   public String deleteStudent(int studentId, Model model) {
	      model.addAttribute("student", studentService.getStdInfo(studentId));
	      return "admin/studentDelete";   
	   }
	   
	   
	   @RequestMapping(value="/admin/studentDelete", method=RequestMethod.POST)
	   public String deleteStudent(int studentId, String emailId) {
	      studentService.deleteStudent(studentId, emailId);
	      return "redirect:/admin";
	   }
}
