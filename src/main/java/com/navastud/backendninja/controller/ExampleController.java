package com.navastud.backendninja.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.navastud.backendninja.component.ExampleComponent;
import com.navastud.backendninja.model.Person;
import com.navastud.backendninja.service.ExampleService;

@Controller
@RequestMapping("/example")
public class ExampleController {

	public static final Log LOGGER = LogFactory.getLog(ExampleController.class);

	public static final String EXAMPLE_VIEW = "example";

	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;

	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;

	// Primera forma
	@GetMapping("/exampleString")
	public String exampleString(Model model) {
		LOGGER.info("METHOD: 'exampleString' -- PARAMS: '" + model + "'");
		exampleComponent.sayHello();
		model.addAttribute("people", exampleService.getListPeople());
		LOGGER.info("TEMPLATE: '" + EXAMPLE_VIEW + "' -- DATA: '" + model + "'");
		return EXAMPLE_VIEW;
	}

	// Segunda forma
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {
		LOGGER.info("METHOD: 'exampleMAV' -- PARAMAS: ''");
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("people", exampleService.getListPeople());
		LOGGER.info("TEMPLATE: '" + EXAMPLE_VIEW + "' -- DATA: '" + mav + "'");
		return mav;
	}

}
