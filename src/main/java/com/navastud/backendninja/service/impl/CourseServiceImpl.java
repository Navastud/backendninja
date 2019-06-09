package com.navastud.backendninja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.navastud.backendninja.entity.Course;
import com.navastud.backendninja.repository.CourseJpaRepository;
import com.navastud.backendninja.service.CourseService;


@Service("couserServiceImpl")
public class CourseServiceImpl implements CourseService {

	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;

	@Override
	public List<Course> listAllCourse() {

		return courseJpaRepository.findAll();
	}

	@Override
	public Course addCourse(Course course) {

		return courseJpaRepository.save(course);
	}

	@Override
	public int removeCourse(int id) {

		courseJpaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Course updateCourse(Course course) {

		return courseJpaRepository.save(course);
	}

}
