package com.waiyanhtet.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.waiyanhtet.student.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SchedularJob {

	@Autowired
	private StudentService studentService;

	@Scheduled(cron = "${student.count.log.cron}")
	public void cronJobSch() {

		log.info("Registered student:: " + studentService.getCount());
	}
}
