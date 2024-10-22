package com.example;

import java.util.ArrayList;

public class LeaderBoard {
    private ArrayList<ClientHandler> leaderBoard;

    private static boolean isFinished = false;

    public LeaderBoard() {
        leaderBoard = new ArrayList<>();
    }

    public boolean addClient(ClientHandler client) {
        return leaderBoard.add(client);
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean isFinished) {
        LeaderBoard.isFinished = isFinished;
    }

    public void printLeaderBoard() {
        System.out.println("Classifica finale: ");

        for (int i = 0; i < leaderBoard.size(); i++) {
            System.out.println((i + 1) + ") " + leaderBoard.get(i).getId());
        }
    }
}
