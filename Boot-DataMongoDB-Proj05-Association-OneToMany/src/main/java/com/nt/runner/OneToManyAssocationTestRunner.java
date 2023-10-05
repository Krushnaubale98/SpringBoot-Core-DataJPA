package com.nt.runner;

import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.nt.document.Medal;
import com.nt.document.Player;
import com.nt.document.Sport;
import com.nt.service.IPlayerMgmtService;

@Component
public class OneToManyAssocationTestRunner implements CommandLineRunner {

	@Autowired
	private IPlayerMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		try {
			// child class 1
			Sport sport1 = new Sport(new Random().nextInt(1000), "badmintton",
					new String[] { "racket", "scock", "net" });
			Sport sport2 = new Sport(new Random().nextInt(1000), "badmintton",
					new String[] { "racket", "t.ball", "net" });

			// child class 2
			Medal medal1 = new Medal("olympic-gold", "gold", "tokyo-olympic", "tokyo");
			Medal medal2 = new Medal("cwg-silver", "silver", "cwg-japan", "tokyo");

			// parent class
			Player player = new Player(new Random().nextInt(1000), "sindhu", "pune", Set.of(sport1, sport2),
					Map.of("medal1", medal1, "medal2", medal2));

			// invoke the method
			System.out.println(service.registerPlayerwithSportsAndMedals(player));
		} catch (Exception e) {
			e.printStackTrace();

		}

		System.out.println("-----------------FindAll() operation----------------");
		try {
			service.fetchAllPlayersInfo().forEach(per -> {
				System.out.println("parent:: " + per);

				// access child1 class object
				Set<Sport> sports = per.getSports();
				sports.forEach(sport -> {
					System.out.println("Sport:: " + sport);
				});

				// access child2 class object

				Map<String, Medal> models = per.getMedals();
				models.forEach((type, medal) -> {
					System.out.println("child2:: " + type + " ... " + medal);
				});

			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
