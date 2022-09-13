package com.indepth.jpa.hibernate.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.indepth.jpa.hibernate.demo.entity.Course;
import com.indepth.jpa.hibernate.demo.repository.CourseRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Course course = repository.findById(1001);
		logger.info("Course 1001 -> {}", course);
		
//		repository.deleteById(1002);
		
		repository.save(new Course("Civil"));
		
		
	}

}
