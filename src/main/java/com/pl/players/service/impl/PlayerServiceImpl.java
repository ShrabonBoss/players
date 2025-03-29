package com.pl.players.service.impl;

import com.pl.players.model.Player;
import com.pl.players.repository.PlayerRepository;
import com.pl.players.service.PlayerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player addPlayer(Player player) {
        playerRepository.save(player);
        return player;
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public List<Player> getPlayersByTeam(String teamName) {
        return playerRepository.findAll().stream()
                .filter(player -> teamName.equals(player.getTeam()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByName(String name) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByPosition(String position) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getPosition().toLowerCase().contains(position.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByNation(String nation) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getNation().toLowerCase().contains(nation.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByTeamAndPosition(String teamName, String position) {
        return playerRepository.findAll().stream()
                .filter(player -> teamName.equals(player.getTeam()) && position.equals(player.getPosition()))
                .collect(Collectors.toList());
    }

    public Player updatePlayer(Player player) {

        Optional<Player> existsingPlayer = playerRepository.findByName(player.getName());

        if(existsingPlayer.isPresent()) {
            Player updatedPlayer = existsingPlayer.get();
            updatedPlayer.setName(player.getName());
            updatedPlayer.setNation(player.getNation());
            updatedPlayer.setPosition(player.getPosition());;
            updatedPlayer.setTeam(player.getTeam());
            playerRepository.save(updatedPlayer);
            return updatedPlayer;
        }
        return null;
    }

    @Transactional
    public void deletePlayer(String name) {
        playerRepository.deleteByName(name);
    }
}
