package com.te.student_app.dao;

import com.te.student_app.bean.Student;

public interface IStudentDao {
	public boolean insertStudent(Student bean);
	public Student searchStudent(int userid);
	public boolean removeStudent(int userid);
	public boolean updateStudentEmail(Student bean);
}
