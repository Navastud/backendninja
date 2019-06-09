package com.navastud.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.navastud.backendninja.entity.Course;
import com.navastud.backendninja.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

	private static final String COURSES_VIEW = "courses";
	private static final Log LOG = LogFactory.getLog(CourseController.class);

	@Autowired
	@Qualifier("couserServiceImpl")
	private CourseService courseService;

	@GetMapping("/listcourses")
	public ModelAndView listAllCourses() {
		LOG.info("Call: listAllCourses()");
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		mav.addObject("course", new Course());
		mav.addObject("courses", courseService.listAllCourses());
		return mav;
	}

	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("course") Course course) {
		LOG.info("Call: addCourse() -- Param: " + course.toString());
		courseService.addCourse(course);
		return "redirect:/courses/listcourses";
	}

	@PostMapping("/deletecourse")
	public String deleteCourse(int id) {
		LOG.info("Call: deleteCourse() -- Param: " + id);
		courseService.removeCourse(id);
		return "redirect:/courses/listcourses";
	}

	@PostMapping("/updatecourse")
	public String updateCourse(@ModelAttribute("course") Course course) {
		LOG.info("Call: updateCourse() -- Param: " + course.toString());
		courseService.updateCourse(course);
		return "redirect:/courses/listcourses";
	}
}
