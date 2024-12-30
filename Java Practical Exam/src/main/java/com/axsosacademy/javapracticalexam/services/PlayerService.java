package com.axsosacademy.javapracticalexam.services;

import com.axsosacademy.javapracticalexam.models.Player;
import com.axsosacademy.javapracticalexam.models.Team;
import com.axsosacademy.javapracticalexam.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final TeamService teamService;
    public PlayerService(PlayerRepository playerRepository, TeamService teamService) {
        this.playerRepository = playerRepository;
        this.teamService = teamService;
    }

    // Get All Players
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    // add new Player
    public void addPlayer(Player player) {
        playerRepository.save(player);
    }

    // Add Player to a Team
    public void addPlayerToTeam(String playerName, Long teamId) {
        Team team = teamService.getTeamById(teamId);
        Player newPlayer = new Player(playerName, team);
        playerRepository.save(newPlayer);
    }

    // Delete all players for a team by ID
    public void deleteAllPlayers(Long teamId) {
        playerRepository.deleteAllByTeamId(teamId);
    }

}
