package com.nt.sbeans;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sf")
public class SeasonFinder {

	// bean property
	@Autowired
	private LocalDate ldt;

	// business method
	public String findSeson() {
		//get the current month
		int month=ldt.getMonthValue();
		//show the season name
		if(month>=3 && month<=6)
			return "Summer Season";
		else if(month>=7 && month<=10)
			return "Rainy Season";
		else
			return "Winter Season";		
	}
}
