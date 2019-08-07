package com.telran.tests.model;

public class Team {
    private final String teamname;
    private final String description;

    public Team(String teamname, String description) {
        this.teamname = teamname;
        this.description = description;
    }

    public String getTeamname() {
        return teamname;
    }

    public String getDescription() {
        return description;
    }
}
