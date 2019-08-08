package com.telran.tests.model;

public class Team {
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String teamName;
    private String description;

    public Team(String teamName, String description) {
        this.teamName = teamName;
        this.description = description;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getDescription() {
        return description;
    }
}
