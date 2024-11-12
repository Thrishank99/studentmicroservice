package com.org.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.java.entity.Student;
import com.org.java.service.StudentService;


@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/save")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		Student students=studentService.saveStudentDetails(student);
		return new ResponseEntity<>(students,HttpStatus.CREATED);	
	}
	@RequestMapping("/findAll")
	public ResponseEntity<Student> findAllStudent(){
		List<Student> studentsList=studentService.findAllStudentDetails();
		return new ResponseEntity(studentsList,HttpStatus.OK);
		
	}
	@GetMapping("/findStudentToCollegeDetails")
	public ResponseEntity<Student> findStudentToCollegeDetails(){
		Object[] studentsList=studentService.getStudentToCollegeDetails();
		return new ResponseEntity(studentsList,HttpStatus.OK);//http://localhost:8989/student/findStudentToCollegeDetails
		
	}
	@PostMapping("/saveStudentToCollege")
	public ResponseEntity<Student> saveStudentToCollege(@RequestBody Student student){
		Student students=studentService.saveStudentToCollegeDetails(student);
		return new ResponseEntity<>(students,HttpStatus.CREATED);	
	}
	
	
	

}
