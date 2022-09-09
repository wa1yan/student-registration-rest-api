package com.waiyanhtet.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.waiyanhtet.event.StudentRegistrationCompleteEvent;
import com.waiyanhtet.student.service.StudentRegistrationEmailService;

@Component
public class RegistrationListener 
	implements ApplicationListener<StudentRegistrationCompleteEvent>{

	@Autowired
	private StudentRegistrationEmailService emailService;
	
	@Override
	public void onApplicationEvent(StudentRegistrationCompleteEvent event) {
		this.sendRegistrationCompleteEmail(event);
	}

	private void sendRegistrationCompleteEmail(StudentRegistrationCompleteEvent event) {		
        emailService.sendEmail(event.getStudent(),event.getLocale());  
	}
}
