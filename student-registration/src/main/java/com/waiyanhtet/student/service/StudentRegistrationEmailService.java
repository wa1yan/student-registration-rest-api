package com.waiyanhtet.student.service;

import java.util.Locale;

import org.springframework.stereotype.Service;

import com.waiyanhtet.student.model.Student;

@Service
public interface StudentRegistrationEmailService {

	void sendEmail(Student student, Locale locale);
	
}
