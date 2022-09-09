package com.waiyanhtet.student.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import com.waiyanhtet.student.annotation.Phone;

import lombok.Data;

@Data
@Entity
@Table(name = "student")
@Validated
public class Student {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "First name must not be empty")
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank(message = "Last name must not be empty")
	@Column(name = "last_name")
	private String lastName;
	
	@NotBlank(message = "Email address must not be empty")
	@Email(message = "Please enter email address")
	@Column(name = "email", unique = true)
	private String email;
	
	@NotBlank(message = "Phone number must not be empty")
	@Phone(message = "Phone number must be at least 9 number")
	@Column(name = "phone")
	private String phone;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate registration;
		
}
