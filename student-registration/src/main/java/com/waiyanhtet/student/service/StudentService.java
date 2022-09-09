package com.waiyanhtet.student.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.waiyanhtet.student.model.Student;
import com.waiyanhtet.student.model.StudentResponse;

@Service
public interface StudentService {

	StudentResponse findAll(int pageNo, int pageSize, String sortBy, String sortDir);
	
	Optional<Student> findById(int id);
	
	Student createStudent(Student student);
	
	Student updateStudent(Student student);
	
	void deleteStudent(int id);
	
	Long getCount();
}
