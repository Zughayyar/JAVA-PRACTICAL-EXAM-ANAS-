package com.axsosacademy.javapracticalexam.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Team Name is required!")
    @Size(min = 3, max = 30, message = "Team Name must be between 3 and 30 characters")
    private String teamName;

    @NotNull(message = "Skill Level is required!")
    @Min(value = 1, message = "Skill Level must be at least 1")
    @Max(value = 5, message = "Skill Level must not exceed 5")
    private Integer skillLevel;

    @NotEmpty(message = "Team Name is required!")
    @Size(min = 3, max = 30, message = "Game Day must be between 3 and 30 characters")
    private String gameDay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "team")
    private List<Player> players = new ArrayList<>();

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    // Constructors
    public Team() {
    }

    public Team(String teamName, Integer skillLevel, String gameDay) {
        this.teamName = teamName;
        this.skillLevel = skillLevel;
        this.gameDay = gameDay;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public Integer getSkillLevel() {
        return skillLevel;
    }

    public String getGameDay() {
        return gameDay;
    }

    public User getUser() {
        return user;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setSkillLevel(Integer skillLevel) {
        this.skillLevel = skillLevel;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setGameDay(String gameDay) {
        this.gameDay = gameDay;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
