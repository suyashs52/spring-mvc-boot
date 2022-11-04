package com.coach;

import com.service.Coach;
import com.service.FortuneService;

public class BaseBallCoach implements Coach {

	private FortuneService fortuneService;

	public BaseBallCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	public String getDailyWorkOut() {
		return "Spend 30mins on Base ball practice";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
}
