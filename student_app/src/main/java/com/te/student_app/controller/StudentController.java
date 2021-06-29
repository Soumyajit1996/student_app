package com.te.student_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.student_app.bean.Student;
import com.te.student_app.bean.StudentResponse;
import com.te.student_app.service.IStudentService;

@RestController
public class StudentController {

	@Autowired
	private IStudentService student_service;

	@GetMapping(path = "/searchStudent", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public StudentResponse searchStudent(int userid) {
		StudentResponse response = new StudentResponse();
		Student bean = student_service.searchStudent(userid);
		if (bean != null) {
			response.setStatusCode(100);
			response.setMsg("success");
			response.setDescription("Student data found for userid:" + userid);
			response.setBean(bean);

		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Student data not found for userid:" + userid);
		}
		return response;

	}

	@PostMapping(path = "/insertStudent", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public StudentResponse insertStudent(@RequestBody Student studentBean) {
		StudentResponse response = new StudentResponse();
		if (student_service.insertStudent(studentBean)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Added Successfully");
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Something Went Wrong");
		}
		return response;
	}//

	@DeleteMapping(path = "/deleteStudent/{student_id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public StudentResponse deleteStudent(@PathVariable(name = "student_id") int userid) {
		StudentResponse employeeResponse = new StudentResponse();
		if (student_service.removeStudent(userid)) {
			employeeResponse.setStatusCode(200);
			employeeResponse.setMsg("success");
			employeeResponse.setDescription(" Student Deleted for id : " + userid);
		} else {
			employeeResponse.setStatusCode(400);
			employeeResponse.setMsg("failure");
			employeeResponse.setDescription("something went wrong");
		}

		return employeeResponse;
	}//

	@PutMapping(path = "/update", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public StudentResponse updateStudent(@RequestBody Student studentBean) {
		StudentResponse response = new StudentResponse();
		if (student_service.updateStudentEmail(studentBean)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Updated Successfully");
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Something Went Wrong");
		}
		return response;
	}
}
