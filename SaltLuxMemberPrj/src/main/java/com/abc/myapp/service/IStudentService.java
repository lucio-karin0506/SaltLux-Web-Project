package com.abc.myapp.service;

import java.util.List;
import java.util.Map;

import com.abc.myapp.StudentVO;

public interface IStudentService {
	
	List<StudentVO> getStudentList();
	StudentVO getStdInfo(int studentId);
	void updateStudent(StudentVO std);
	void insertStudent(StudentVO std);
	void deleteStudent(int studentId, String emailId);
	List<Map<String, Object>> getAllStudentId();
	

}
