package com.org.java.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.org.java.entity.Student;
import com.org.java.repository.StudnetRepository;
import com.org.java.service.StudentService;

@Component
public class StudentServiceImpl implements StudentService {
	
	/*
	 * @Value("${microservice.student-service.endpoints.endpoint.uri:}") private
	 * String ENDPOINT_URL;
	 */
	
	@Autowired
	private StudnetRepository studnetRepository;
		
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Student saveStudentDetails(Student student) {
		// TODO Auto-generated method stub
		return studnetRepository.save(student);
	}

	@Override
	public List<Student> findAllStudentDetails() {
		// TODO Auto-generated method stub
		List<Student> list=studnetRepository.findAll();
		return list;
	}

	@Override
	public Object[] getStudentToCollegeDetails() {
		// TODO Auto-generated method stub
		//Object[] list=restTemplate.getForObject(ENDPOINT_URL, Object[].class);
		Object[] list=restTemplate.getForObject("http://localhost:2024/college/findAll", Object[].class);
		return list;
	}

	@Override
	public Student saveStudentToCollegeDetails(Student student) {
		// TODO Auto-generated method stub
		return restTemplate.postForObject("http://COLLEGE-MICROSERVICE/college/save", student, Student.class);
	}

}
