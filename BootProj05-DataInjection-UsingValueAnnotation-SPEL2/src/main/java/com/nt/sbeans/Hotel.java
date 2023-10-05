package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("hotel")
public class Hotel {

	@Value("1234")
	private Integer hotelId;

	@Value("${hotel.name}")
	private String hotelName;

	@Value("${hotel.addrs}")
	private String hotelAddrs;

	@Value("${hotel.contactno}")
	private String mobileNo;

	@Value("${customer.name}")
	private String custName;

	@Value("#{menup.idlyPrice+menup.dosaPrice}") // SPEL for arithmetic operation
	private float billAmount;

	@Value("${os.name}") /// os.name is fixed system property key
	private String osName;

	@Value("${user.name}") // user.name is fixed system property
	private String windowsUser;

	@Value("${path}") // path is fixed environment variable name
	private String pathData;

}
