package com.telran.tests.model;

public class Team {
    private final String teamName;
    private final String description;

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
