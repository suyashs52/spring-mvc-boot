package com.coach;

import com.service.Coach;
import com.service.FortuneService;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;

	public TrackCoach(com.service.FortuneService fortuneService) {

		this.fortuneService = fortuneService;
	}

	public TrackCoach() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Just do it " + fortuneService.getFortune();
	}
	
	
	//add an init method : it called before bean initiated
	
	public void doSomeStartupStuff() {
		System.out.println("TrackCoach: inside method doSomeStartupStuff");
	}
	
	
	//destroy method: called when bean actually destroy
	public void doCleanUpStuff() {
		System.out.println("TrackCoach: inside method doCleanUpStuff");
	}

}
