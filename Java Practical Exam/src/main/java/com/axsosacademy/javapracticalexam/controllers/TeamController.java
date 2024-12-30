package com.axsosacademy.javapracticalexam.controllers;

import com.axsosacademy.javapracticalexam.models.Player;
import com.axsosacademy.javapracticalexam.models.Team;
import com.axsosacademy.javapracticalexam.models.User;
import com.axsosacademy.javapracticalexam.services.PlayerService;
import com.axsosacademy.javapracticalexam.services.TeamService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TeamController {
    private final TeamService teamService;
    private final PlayerService playerService;
    public TeamController(TeamService teamService, PlayerService playerService) {
        this.teamService = teamService;
        this.playerService = playerService;
    }

    // DashBoard GET REQUEST
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        if (session.getAttribute("loggedUser") != null) {
            List<Team> allTeams = teamService.getAllTeams();
            model.addAttribute("teams", allTeams);
            return "dashboard";
        }
        else {
            return "redirect:/";
        }
    }

    // Mew Team Page GET REQUEST
    @GetMapping("/teams/new")
    public String newTeamPage(HttpSession session, @ModelAttribute("team") Team team, Model model) {
        if (session.getAttribute("loggedUser") != null) {
            model.addAttribute("player", new Player());
            return "newTeam";
        }
        else {
            return "redirect:/";
        }

    }

    // Add Method POST REQUEST
    @PostMapping("/teams/addTeam")
    public String addNewTeam(
            @Valid @ModelAttribute("team") Team team,
            BindingResult bindingResult,
            HttpSession session
    ) {
        if (bindingResult.hasErrors()) {
            return "newTeam";
        }
        else {
            User loggedUser = (User) session.getAttribute("loggedUser");
            teamService.addTeam(team);
            Player newPlayer = new Player();
            newPlayer.setPlayerName(loggedUser.getUserName());
            newPlayer.setTeam(team);
            playerService.addPlayer(newPlayer);
            return "redirect:/dashboard";
        }
    }

    // Show team Page GET REQUEST
    @GetMapping("/teams/{teamId}")
    public String teamDetail(
            HttpSession session,
            @PathVariable Long teamId,
            Model model
    ) {
        if (session.getAttribute("loggedUser") != null) {
            Team team = teamService.getTeamById(teamId);
            model.addAttribute("team", team);
            return "showTeam";
        }
        else {
            return "redirect:/";
        }

    }

    // Delete Team
    @PostMapping("/teams/deleteTeam")
    public String deleteTeam(
            @ModelAttribute("team") Team team, HttpSession session
    ) {
        if (session.getAttribute("loggedUser") != null) {
            teamService.deleteTeamById(team.getId());
        }
        return "redirect:/dashboard";
    }

    @GetMapping("teams/{teamId}/edit")
    public String editTeam(
            @ModelAttribute("team") Team editedTeam,
            HttpSession session,
            Model model,
            @PathVariable Long teamId
    ){
        if (session.getAttribute("loggedUser") != null) {
            Team team = teamService.getTeamById(teamId);
            model.addAttribute("team", team);
            return "editTeam";
        }
        else {
            return "redirect:/";
        }
    }

    @PostMapping("team/editTeam")
    public String editTeam(
            @Valid @ModelAttribute("team") Team team,
            BindingResult bindingResult,
            HttpSession session
    ) {
        if (session.getAttribute("loggedUser") != null) {
            if (bindingResult.hasErrors()) {
                return "editTeam";
            }
            else {
                teamService.addTeam(team);
                return "redirect:/dashboard";
            }
        }
        else {
            return "redirect:/";
        }
    }

    @PostMapping("/addPlayer")
    public String addPlayer(
            @RequestParam("playerName") String playerName,
            @RequestParam("teamId") Long teamId,
            HttpSession session) {
        if (session.getAttribute("loggedUser") != null) {
            playerService.addPlayerToTeam(playerName, teamId);
            return "redirect:/teams/" + teamId;
        }
        else {
            return "redirect:/";
        }
    }


}
