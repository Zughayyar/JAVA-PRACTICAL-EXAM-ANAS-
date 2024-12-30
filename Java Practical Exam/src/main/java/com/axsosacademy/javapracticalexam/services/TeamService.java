package com.axsosacademy.javapracticalexam.services;

import com.axsosacademy.javapracticalexam.models.Player;
import com.axsosacademy.javapracticalexam.models.Team;
import com.axsosacademy.javapracticalexam.repositories.TeamRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    // Get All teams
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    // Add new Team
    public void addTeam(Team team) {
        teamRepository.save(team);
    }

    // Get Team by Id
    public Team getTeamById(Long id) {
        return teamRepository.findById(id).orElse(null);
    }

    // Delete Team
    public void deleteTeamById(Long id) {
        Team team = teamRepository.findById(id).orElse(null);
        if (team != null) {
            for (Player player : team.getPlayers()) {
                player.setTeam(null);
            }
            teamRepository.save(team);
        }
        teamRepository.deleteById(id);
    }
}
