package com.waiyanhtet.student.model;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
	
	private List<Student> data;
	private int pageNo;
	private int pageSize;
	private long totalElements;
	private int totalPages;
	private boolean last;
	
	public StudentResponse(Page<Student> data) {
		this.data = data.getContent();
		this.pageNo = data.getNumber();
		this.pageSize = data.getSize();
		this.totalElements = data.getTotalElements();
		this.totalPages = data.getTotalPages();
		this.last = data.isLast();
	}
	
	
	
}
