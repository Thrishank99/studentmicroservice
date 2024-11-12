package com.org.java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.org.java.entity.Student;



@Service
public interface StudentService {

	Student saveStudentDetails(Student student);

	List<Student> findAllStudentDetails();

	Object[] getStudentToCollegeDetails();

	Student saveStudentToCollegeDetails(Student student);
	
	

}
