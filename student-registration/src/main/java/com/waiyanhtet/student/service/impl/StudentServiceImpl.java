package com.waiyanhtet.student.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.waiyanhtet.exception.StudentAlreadyExistException;
import com.waiyanhtet.student.model.Student;
import com.waiyanhtet.student.model.StudentResponse;
import com.waiyanhtet.student.repository.StudentRepository;
import com.waiyanhtet.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repo;

	@Override
	public StudentResponse findAll(int pageNo, int pageSize, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Student> data = repo.findAll(pageable);
		List<Student> list = data.getContent();

		StudentResponse studentResponse = new StudentResponse();
		studentResponse.setData(list);
		studentResponse.setPageNo(data.getNumber());
		studentResponse.setPageSize(data.getSize());
		studentResponse.setTotalElements(data.getTotalElements());
		studentResponse.setTotalPages(data.getTotalPages());
		studentResponse.setLast(data.isLast());

		return studentResponse;
	}

	@Override
	public Optional<Student> findById(int id) {
		return repo.findById(id);
	}

	@Override
	public Student createStudent(Student student) {
		Student registeredStudent = repo.findStudentByEmail(student.getEmail());
		if(registeredStudent != null) {
			throw new StudentAlreadyExistException("Email already exist in database.");
		}
		return repo.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		return repo.save(student);
	}

	@Override
	public void deleteStudent(int id) {
		repo.deleteById(id);
	}

	@Override
	public Long getCount() {
		return repo.count();
	}

}
