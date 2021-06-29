package com.te.student_app.service;

import com.te.student_app.bean.Student;

public interface IStudentService {
	public boolean insertStudent(Student bean);
	public Student searchStudent(int userid);
	public boolean removeStudent(int userid);
	public boolean updateStudentEmail(Student bean);
}
