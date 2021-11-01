package com.abc.myapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.myapp.StudentVO;
import com.abc.myapp.dao.IStudentRepository;

@Service
public class StudentService implements IStudentService {
	
	@Autowired
	IStudentRepository studentRepository;

	@Override
	public List<StudentVO> getStudentList() {
		return studentRepository.getStudentList();
	}

	@Override
	public void updateStudent(StudentVO std) {
		studentRepository.updateStudent(std);

	}

	@Override
	public void insertStudent(StudentVO std) {
		studentRepository.insertStudent(std);

	}

	@Override
	public void deleteStudent(int studentId, String emailId) {
		studentRepository.deleteStudent(studentId, emailId);

	}

	@Override
	public List<Map<String, Object>> getAllStudentId() {
		return studentRepository.getAllStudentId();
	}

	@Override
	public StudentVO getStdInfo(int studentId) {
		return studentRepository.getStdInfo(studentId);
	}

}
