package com.pl.players.controller;

import com.pl.players.model.Player;
import com.pl.players.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getPlayers();
    }

    @GetMapping
    public List<Player> getPlayers(
            @RequestParam(required = false) String teamName,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String nation) {

                if (teamName != null && position != null) {
                    return playerService.getPlayersByTeamAndPosition(teamName, position);
                }else if (teamName != null) {
                    return playerService.getPlayersByTeam(teamName);
                }else if (name != null) {
                    return playerService.getPlayersByName(name);
                }else if (position != null) {
                    return playerService.getPlayersByPosition(position);
                }else if (nation != null) {
                    return playerService.getPlayersByNation(nation);
                }else {
                    return playerService.getPlayers();
                }
    }

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player addedPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(addedPlayer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
        Player updatedPlayer = playerService.updatePlayer(player);
        if (updatedPlayer != null) {
            return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deletePlayer(@PathVariable String name) {
        playerService.deletePlayer(name);
        return new ResponseEntity<>("Player deleted successfully", HttpStatus.OK);
    }
}
