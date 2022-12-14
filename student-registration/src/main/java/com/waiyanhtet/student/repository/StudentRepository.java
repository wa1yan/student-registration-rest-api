package com.waiyanhtet.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.waiyanhtet.student.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	//@Query("select * from student where email = ?1 ")
	Student findStudentByEmail(String email);
}
