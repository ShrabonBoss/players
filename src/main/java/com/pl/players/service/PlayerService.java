package com.pl.players.service;

import com.pl.players.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService {

    public Player addPlayer(Player player);

    public List<Player> getAllPlayers();

    public List<Player> getPlayersByTeam(String teamName);

    public List<Player> getPlayersByName(String name);

    public List<Player> getPlayersByPosition(String position);

    public List<Player> getPlayersByNation(String nation);

    public List<Player> getPlayersByTeamAndPosition(String teamName, String position);

    public Player updatePlayer(Player player);

    public void deletePlayer(String name);
}
