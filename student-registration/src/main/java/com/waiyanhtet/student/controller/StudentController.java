package com.waiyanhtet.student.controller;

import static com.waiyanhtet.student.constant.PaginationConstant.DEFAULT_PAGE_NUMBER;
import static com.waiyanhtet.student.constant.PaginationConstant.DEFAULT_PAGE_SIZE;
import static com.waiyanhtet.student.constant.PaginationConstant.DEFAULT_SORT_BY;
import static com.waiyanhtet.student.constant.PaginationConstant.DEFAULT_SORT_DIRECTION;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.waiyanhtet.exception.RecordNotFoundException;
import com.waiyanhtet.student.annotation.StudentControllerAnno;
import com.waiyanhtet.student.model.Student;
import com.waiyanhtet.student.model.StudentResponse;
import com.waiyanhtet.student.service.StudentService;

import io.swagger.annotations.ApiOperation;

@StudentControllerAnno
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping()
	@ApiOperation("Fetch all students")
	public StudentResponse findAllStudent(
			@RequestParam(value = "pageNo", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
		return service.findAll(pageNo, pageSize, sortBy, sortDir);
	}

	@GetMapping("/{id}")
	@ApiOperation("Fetch particular student by using id")
	public Student findStudentById(@PathVariable int id) {
		return service.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Student " + id + " doesn't exist in database"));
	}

	@PostMapping()
	@ApiOperation("Register a new student")
	public String createStudent(@RequestBody Student student) {
		service.createStudent(student);
		return "Student registration successfully";
	}

	@PutMapping("/{id}")
	@ApiOperation("Update a particular student by using id")
	public String updateStudent(@PathVariable int id, @RequestBody Student updateStudent) {
		var student = service.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Student " + id + " doesn't exist in database"));
		if (student != null) {
			student.setFirstName(updateStudent.getFirstName());
			student.setLastName(updateStudent.getLastName());
			student.setEmail(updateStudent.getEmail());
			student.setPhone(updateStudent.getPhone());
		}
		service.updateStudent(student);
		return "Student information updated successfully";
	}

	@DeleteMapping("/{id}")
	@ApiOperation("Delete a particular student by using id")
	public String deleteStudent(@PathVariable int id) {
		service.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Student " + id + " doesn't exist in database"));
		service.deleteStudent(id);
		return "Successfully Deleted for " + id;
	}

}
