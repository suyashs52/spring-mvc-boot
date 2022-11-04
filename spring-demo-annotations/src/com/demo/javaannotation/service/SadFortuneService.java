package com.demo.javaannotation.service;

import com.demo.service.FortuneService;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is not a sad day";
	}

}
