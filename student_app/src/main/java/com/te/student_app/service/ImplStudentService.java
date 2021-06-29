package com.te.student_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.student_app.bean.Student;
import com.te.student_app.dao.IStudentDao;

@Service
public class ImplStudentService implements IStudentService{

	@Autowired
	private IStudentDao studentDao;
	
	@Override
	public boolean insertStudent(Student bean) {
		return studentDao.insertStudent(bean);
	}

	@Override
	public Student searchStudent(int userid) {
		return studentDao.searchStudent(userid);
	}

	@Override
	public boolean removeStudent(int userid) {
		return studentDao.removeStudent(userid);
	}

	@Override
	public boolean updateStudentEmail(Student bean) {
		return studentDao.updateStudentEmail(bean);
	}
}
