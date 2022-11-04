package com.coach;

import com.service.Coach;
import com.service.FortuneService;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
	
	
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	 public void setEmailAddress(String emailAddress) {
		 System.out.println("Inside email setter method setEmailAddress" );
			this.emailAddress = emailAddress;
		}

		public void setTeam(String team) {
			 System.out.println("Inside team setter method setTeam" );
				
			this.team = team;
		}


	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "Practice fast bowling for 15mins a day";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune() +" for "+ this.emailAddress+ " team is "+this.team;
	}

}
