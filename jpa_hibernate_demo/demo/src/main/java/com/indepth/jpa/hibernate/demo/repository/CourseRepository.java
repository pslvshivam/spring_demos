package com.indepth.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.indepth.jpa.hibernate.demo.entity.Course;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	EntityManager entityManager;
	
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
		
	}
	//public Course save(Course course)
	//public void deleteById(Long id)
	
	public void deleteById(long id) {
		Course course = findById(id);
		entityManager.remove(course);
	}
	
	
	public void save(Course course) {
		if(findById(course.getId()) == null) {
			entityManager.persist(course);
		} else {
			entityManager.merge(course);
		}
	}
	
}
