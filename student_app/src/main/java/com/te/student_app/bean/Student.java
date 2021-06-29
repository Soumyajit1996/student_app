package com.te.student_app.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@Entity
@Table(name = "student_table")
@JsonRootName("student-info")
@JsonPropertyOrder({"userid","name"})
@XmlRootElement(name = "student-info")
public class Student implements Serializable {
	@Id
	private int userid;
	
	private String email;
	
	private double marks;
	
	private String name;
	
	private String grade;
}
