package com.wajahat.learn.springboot.quickstarter.topic.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses() {
		List<Course> topics = new ArrayList<>();
		courseRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Course getCourse(String id) {
		return courseRepository.findOne(id);
	}
	
	public void addCourse(Course topic) {
		courseRepository.save(topic);
	}
	
	public void updateCourse(Course topic) {
		courseRepository.save(topic);
	}
	
	public void deleteCourse(String id) {
		courseRepository.delete(id);
	}
}
