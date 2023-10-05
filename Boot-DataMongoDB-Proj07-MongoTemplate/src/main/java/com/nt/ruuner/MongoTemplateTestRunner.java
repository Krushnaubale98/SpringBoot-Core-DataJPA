package com.nt.ruuner;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.StockDetails;
import com.nt.service.IStockMgmtService;

@Component
public class MongoTemplateTestRunner implements CommandLineRunner {

	@Autowired
	private IStockMgmtService service;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("--------save document operation------------");
		StockDetails details = new StockDetails(new Random().nextInt(1000), "ICICI", 9999999, "BSE");
		// String result = service.registerStockDetails(details);
		// System.out.println(result);

		System.out.println("=======insertAll(-) to save multiple documents=======");
		StockDetails details1 = new StockDetails(new Random().nextInt(1000), "SBI", 888888, "BFD");
		StockDetails details2 = new StockDetails(new Random().nextInt(1000), "Bajaj", 7777777, "BSE");
		StockDetails details3 = new StockDetails(new Random().nextInt(1000), "RBI", 66666666, "BSE");

		// String msg = service.registerStockDetailsByBatch(List.of(details1, details2,
		// details3));
		// System.out.println(msg);

		System.out.println("======find(-,-) selecting the documents=======");
		service.fetchStockDetailsByExchange("BSE").forEach(System.out::println);
		System.out.println("===================================================");
		service.fetchStockDetailsByPriceRange(10000, 100000).forEach(System.out::println);

		System.out.println("===================findById(-,-) method===========");
		System.out.println("624 stockId stock details are:: " + service.fetchStockDetailsByStockId(624));

		System.out.println("===========updateMulti(-,-,-) method===========");
		System.out.println(service.modifyExchangeByStockPriceRange(10000, 100000, "NYKSE"));

		System.out.println("===============upsert(-,-,-)method==============");
		System.out.println(service.registerOrUpdateStockByStockName("SBH", 3450, "CHPE"));

		System.out.println("=====findAndRemove(-,-) method=============");
		System.out.println(service.fetchAndRemoveByStockName("SBH"));
	}

}
