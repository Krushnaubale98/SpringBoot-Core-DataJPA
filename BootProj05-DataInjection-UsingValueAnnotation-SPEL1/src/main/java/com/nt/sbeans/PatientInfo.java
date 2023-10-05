package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("pInfo")
@Data
public class PatientInfo {

	@Value("10001")
	private Integer pid;

	@Value("${pi.name}")
	private String pname;

	@Value("${pi.mobileNo}")
	private Long mobileNo;

	@Value("${pi.addrs}")
	private String pAddrs;

	@Value("#{dcc.xrayPrice+dcc.ctscanPrice+dcc.ecgPrice}") // SPEL based Injection
	private Double billAmount;

	@Value("#{dcc.ecgPrice<0}")
	private Boolean ecgFree;

	@Value("${os.name}")
	private String osName; // To hold system property value (fixed)

	@Value("${path}")
	private String pathData; // To hold env...variable value(fixed)

}
