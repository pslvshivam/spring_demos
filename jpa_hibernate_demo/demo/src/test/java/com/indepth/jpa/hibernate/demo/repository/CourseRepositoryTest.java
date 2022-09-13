package com.indepth.jpa.hibernate.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.indepth.jpa.hibernate.demo.DemoApplication;
import com.indepth.jpa.hibernate.demo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	
	@Test
	void findById_basic() {
		Course course = repository.findById(1001);
		assertEquals("Physics",course.getName());
		
		logger.info("Test is running");
	}
	
	@Test
	@DirtiesContext //Do not change the data while testing
	void deleteById_basic() {
		repository.deleteById(1002);
		assertNull(repository.findById(1002));
	}
	

}
