package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.Player;
import com.nt.repo.IMedalRepo;
import com.nt.repo.IPlayerRepo;
import com.nt.repo.ISportRepo;

@Service("playerService")
public class PlayerMgmtServiceImpl implements IPlayerMgmtService {

	@Autowired
	private IPlayerRepo playerRepo;

	@Autowired
	private ISportRepo sportRepo;

	@Autowired
	private IMedalRepo medalRepo;

	@Override
	public String registerPlayerwithSportsAndMedals(Player player) {

		return "Player with sports and medals info is saved with id :: " + playerRepo.save(player).getPid();
	}

	@Override
	public List<Player> fetchAllPlayersInfo() {

		return playerRepo.findAll();
	}

}
