package com.abc.myapp.dao;

import java.util.List;
import java.util.Map;

import com.abc.myapp.StudentVO;

public interface IStudentRepository {
	
	List<StudentVO> getStudentList();
	StudentVO getStdInfo(int studentId);
	void updateStudent(StudentVO std);
	void insertStudent(StudentVO std);
	void deleteStudent(int studentId, String emailId);
	List<Map<String, Object>> getAllStudentId();
	
}
