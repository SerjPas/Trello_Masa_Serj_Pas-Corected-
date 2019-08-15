package com.telran.mobiletests.model;

public class Board {
    private String boardName;

    @Override
    public String toString() {
        return "Board" +
                "boardName='" + boardName + '\'';
    }

    public Board setBoardName(String boardName) {
        this.boardName = boardName;
        return this;
    }

    public String getBoardName() {
        return boardName;
    }
}
