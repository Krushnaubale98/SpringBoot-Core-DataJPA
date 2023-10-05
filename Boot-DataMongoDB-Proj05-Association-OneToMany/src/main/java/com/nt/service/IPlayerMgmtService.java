package com.nt.service;

import java.util.List;

import com.nt.document.Player;

public interface IPlayerMgmtService {

	public String registerPlayerwithSportsAndMedals(Player player);

	public List<Player> fetchAllPlayersInfo();
}
