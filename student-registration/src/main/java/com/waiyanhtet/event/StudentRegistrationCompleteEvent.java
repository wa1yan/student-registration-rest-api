package com.waiyanhtet.event;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import com.waiyanhtet.student.model.Student;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StudentRegistrationCompleteEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	
	private String appUrl;
	private Locale locale;
	private Student student;
	
	public StudentRegistrationCompleteEvent(
			Student student, Locale locale, String appUrl) {
		super(student);
		
		this.student = student;
		this.locale = locale;
		this.appUrl = appUrl;

	}

}
