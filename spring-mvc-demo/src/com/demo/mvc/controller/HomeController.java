package com.demo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // extend Component so picked up by component scanning by spring
public class HomeController {
	// if server didn't work
	// check classpath, check project facet it contain same version as your project
	// has, add <absolute-ordering /> when there is duplicate spring name error exist
	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}
	//Right-click your project and select Export > WAR File\
	//Deploy your new WAR file by copying it to <tomcat-install-directory>\webapps
}
