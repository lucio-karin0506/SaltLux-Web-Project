package com.abc.myapp;

public class StudentVO {

	private String studentName;
	private int studentId;
	private String emailId;
	private String password;
	
	// setter, getter
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	// to String
	@Override
	public String toString() {
		return "StudentVO [studentName=" + studentName + ", studentId=" + studentId + ", emailId=" + emailId
				+ ", password=" + password + "]";
	}
}
	
	
	
		
	