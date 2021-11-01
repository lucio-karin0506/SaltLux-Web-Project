package com.abc.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abc.myapp.StudentVO;
import com.abc.myapp.service.IStudentService;

@Controller
public class StudentController { 
	@Autowired
	IStudentService studentService;
	
	@RequestMapping("/admin/list")
	public void getAllStds(Model model) {
		List<StudentVO> studentList = studentService.getStudentList();
		model.addAttribute("studentList", studentList);
	}
	
	@RequestMapping("/admin/{studentId}")
	public String getStuInfo(@PathVariable int studentId, Model model) {
		StudentVO std = studentService.getStdInfo(studentId);	
		return "admin/view";
	}
	
	@RequestMapping(value="admin/insert", method=RequestMethod.GET)
	public String insertStudent(Model model) {
		model.addAttribute("stdList", studentService.getAllStudentId());
		return "admin/insert";
	}
	
	@RequestMapping(value="admin/insert", method=RequestMethod.POST)
	public String insertStudent(StudentVO std) {
		studentService.insertStudent(std);
		return "redirect:/admin/list";		
		}
	
	@RequestMapping(value="/admin/update", method=RequestMethod.GET)
	public String updateStudent(int studentId, Model model) {
		model.addAttribute("student", studentService.getStdInfo(studentId));
		model.addAttribute("stdList", studentService.getAllStudentId());
		return "admin/update";
	}
	
	@RequestMapping(value="/admin/update", method=RequestMethod.POST)
	public String updateStudent(StudentVO std) {
		studentService.updateStudent(std);
		return "redirect:/admin/" + std.getStudentId();
	}
	
	@RequestMapping(value="/admin/delete", method=RequestMethod.GET)
	public String deleteStudent(int studentId, Model model) {
		model.addAttribute("student", studentService.getStdInfo(studentId));
		return "admin/delete";	
	}
	
	@RequestMapping(value="/admin/delete", method=RequestMethod.POST)
	public String deleteStudent(int studentId, String emailId) {
		studentService.deleteStudent(studentId, emailId);
		return "redirect:/admin";
	}
	
			
}



