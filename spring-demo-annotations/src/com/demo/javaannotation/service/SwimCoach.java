package com.demo.javaannotation.service;

import org.springframework.beans.factory.annotation.Value;

import com.demo.service.Coach;
import com.demo.service.FortuneService;

public class SwimCoach implements Coach {

	FortuneService fortuneService;
	@Value("${foo.email}") //field leve inject value ll be inject in email field
	private String email;
	@Value("${foo.team}")
	private String team;

	public SwimCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkOut() {
		return "Swim 1000m as warm up";
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	

}
