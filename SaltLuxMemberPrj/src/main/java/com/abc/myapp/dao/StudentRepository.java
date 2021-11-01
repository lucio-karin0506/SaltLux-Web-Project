package com.abc.myapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.abc.myapp.StudentVO;

@Repository
public class StudentRepository implements IStudentRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private class StudentMapper implements RowMapper<StudentVO> {

		@Override
		public StudentVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			StudentVO std = new StudentVO();
			std.setStudentName(rs.getString("student_name"));
			std.setStudentId(rs.getInt("student_id"));
			std.setEmailId(rs.getString("email_id"));
			std.setPassword(rs.getString("password"));
			return std;
		}
		
	}
	@Override
	public List<StudentVO> getStudentList() {
		String sql = "select * from students";
		return jdbcTemplate.query(sql, new StudentMapper());
	}

	@Override
	public void updateStudent(StudentVO std) {
		String sql = "update students "
				+ "set student_name=?, student_id=?, email_id=?, "
				+ "password =?, achievement=?";
		jdbcTemplate.update(sql, std.getStudentName(),
								 std.getStudentId(),
								 std.getEmailId(),
								 std.getPassword());
	}

	@Override
	public void insertStudent(StudentVO std) {
		String sql = "insert into students "
				+ "(student_name, student_id, email_id, "
				+ "password, achievement)"
				+ "values( ?,?,?,?,?)";
		jdbcTemplate.update(sql, std.getStudentName(),
								 std.getStudentId(),
								 std.getEmailId(),
								 std.getPassword());
	}

	@Override
	public void deleteStudent(int studentId, String emailId) {
		String sql = "delete from students where student_id=? and email_id=?";
		jdbcTemplate.update(sql, studentId, emailId);	
	}

	@Override
	public List<Map<String, Object>> getAllStudentId() {
		String sql = "select student_id as studentId, "
				+ " student_name as studentName "
				+ " from students";
	return jdbcTemplate.queryForList(sql);
	}

	@Override
	public StudentVO getStdInfo(int studentId) {
		String sql = "select student_name, student_id, email_id, "
				+ "password "
				+ "from students where student_id=?";		
		return jdbcTemplate.queryForObject(sql, new StudentMapper(), studentId);
	}
} //end class