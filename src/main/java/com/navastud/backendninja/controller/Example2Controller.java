package com.navastud.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example2")
public class Example2Controller {

	private static final Log LOGGER = LogFactory.getLog(Example2Controller.class);

	private static final String EXAMPLE_VIEW = "example2";

	// localhost:8080/example2/request1?nm=JON
	@GetMapping("/request1")
	public ModelAndView request1(@RequestParam(name = "nm", required = false, defaultValue = "NULL") String name) {
		LOGGER.info("METHOD: 'request1' -- PARAMS: '" + name + "' ");
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("nm_in_model", name);
		LOGGER.info("TEMPLATE: '" + EXAMPLE_VIEW + "' -- DATA: '" + mav + "'");

		return mav;
	}

	// localhost:8080/example2/request2/JON
	@GetMapping("/request2/{nm}")
	public ModelAndView request2(@PathVariable("nm") String name) {
		LOGGER.info("METHOD: 'request2' -- PARAMS: '" + name + "' ");
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("nm_in_model", name);
		LOGGER.info("TEMPLATE: '" + EXAMPLE_VIEW + "' -- DATA: '" + mav + "'");
		return mav;
	}

}
