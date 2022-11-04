package com.demo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class FortuneService13 {

	public String getFortune(boolean b) {
		if (b) {
			throw new RuntimeException("Mazor Accident! Highway is closed!!");
		}
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Expect Heavy rain this morning";
	}

}
