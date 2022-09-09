package com.waiyanhtet.student.service.impl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.waiyanhtet.student.model.Student;
import com.waiyanhtet.student.service.StudentRegistrationEmailService;

@Component
public class StudentRegistrationEmailServiceImpl implements StudentRegistrationEmailService {

	@Autowired
    private MessageSource messages;
	
	@Autowired
    private JavaMailSender mailSender;
	
	@Override
	public void sendEmail(Student student, Locale locale) {
		String recipientAddress = student.getEmail();
        String subject = messages.getMessage("email.subject", null, locale);
        String message = messages.getMessage("email.body", null, locale);
        
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message);
        try {
        	 mailSender.send(email);
        } catch(MailException exception) {
        	System.out.println("Internet error.");
        } 
       
		
	}
}
