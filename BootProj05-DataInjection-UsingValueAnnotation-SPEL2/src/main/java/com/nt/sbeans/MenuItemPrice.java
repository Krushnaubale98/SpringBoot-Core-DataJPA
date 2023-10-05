package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("menup")
@Data
public class MenuItemPrice {

	@Value("${menu.dosarate}")
	private float dosaPrice;

	@Value("${menu.idlyrate}")
	private float idlyPrice;

	@Value("${menu.poharate}")
	private float pohaPrice;

	@Value("${menu.vprate}")
	private float vadaPavPrice;
}
