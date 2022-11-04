package com.demo.service;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] data = { "Beware of wolf in ship's clothing", "Diligence is the mother of good luck",
			"The journey is the reward" };

	private Random random = new Random();

	@Override
	public String getFortune() {
		int i = random.nextInt(data.length);
		return "RandomFortuneService: " + data[i];
	}

}
