package com.te.student_app.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.te.student_app.bean.Student;

@Repository
public class ImplStudentDao implements IStudentDao {

	@Autowired
	private EntityManagerFactory factory;

	@Override
	public boolean insertStudent(Student bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isAdded = false;
		try {
			transaction.begin();
			double marks=bean.getMarks();
			if(marks>=9.1&&marks<=10.00) {
				bean.setGrade("A+");
			}
			else if(marks>=8.1&&marks<=9.00) {
				bean.setGrade("A");
			}
			else if(marks>=7.1&&marks<=8.00){
				bean.setGrade("B");
			}
			else if(marks>=6.1&&marks<=7.00) {
				bean.setGrade("C");
			}
			else if(marks>=5.1&&marks<=6.0) {
				bean.setGrade("D");
			}
			else if(marks>=4.1&&marks<=5.0) {
				bean.setGrade("E");
			}
			else if(marks<=4.0) {
				bean.setGrade("Fail");
			}
			manager.persist(bean);

			if (bean != null) {
				transaction.commit();
				isAdded = true;
			}
		} catch (Exception e) {
			isAdded = false;
			e.printStackTrace();
		}
		return isAdded;
	}

	@Override
	public Student searchStudent(int userid) {
		EntityManager manager = factory.createEntityManager();
		try {
			Student student = manager.find(Student.class, userid);
			if (student != null) {
				return student;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (manager != null) {
				manager.close();
			}
		}
		return null;
	}// end of searchStudent

	@Override
	public boolean removeStudent(int userid) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			Student student = manager.find(Student.class, userid);
			if (student != null) {
				manager.remove(student);
				transaction.commit();
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {

			if (manager != null) {
				manager.close();
			}
		}

	}// end of removeStudent

	@Override
	public boolean updateStudentEmail(Student bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isUpdated = false;
		try {
			transaction.begin();
			Student student = manager.find(Student.class, bean.getUserid());
			if (bean.getEmail() != null && bean.getEmail() != "") {
				student.setEmail(bean.getEmail());
			}
			transaction.commit();
			isUpdated = true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			isUpdated = false;
		}
		return isUpdated;
	}
}
