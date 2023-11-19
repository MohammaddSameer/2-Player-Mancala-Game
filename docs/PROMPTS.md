# Prompt

**Make a mancala game in java OOP. make a store class, player class, board class, pit class, and mancalaGame class**

# Solution

import java.util.ArrayList;
import java.util.List;

class Pit {
    private int stones;

    public Pit() {
        stones = 4; // Initialize each pit with 4 stones
    }

    public int getStones() {
        return stones;
    }

    public void setStones(int stones) {
        this.stones = stones;
    }

    public void addStones(int stonesToAdd) {
        stones += stonesToAdd;
    }

    public int removeStones() {
        int removedStones = stones;
        stones = 0;
        return removedStones;
    }
}

class Store {
    private int stones;

    public Store() {
        stones = 0;
    }

    public int getStones() {
        return stones;
    }

    public void addStones(int stonesToAdd) {
        stones += stonesToAdd;
    }
}

class Player {
    private String name;
    private Store store;
    private List<Pit> pits;

    public Player(String name) {
        this.name = name;
        store = new Store();
        pits = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            pits.add(new Pit());
        }
    }

    public String getName() {
        return name;
    }

    public Store getStore() {
        return store;
    }

    public List<Pit> getPits() {
        return pits;
    }

    public boolean hasStonesInPits() {
        for (Pit pit : pits) {
            if (pit.getStones() > 0) {
                return true;
            }
        }
        return false;
    }
}

class MancalaGame {
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public MancalaGame(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
        currentPlayer = player1;
    }

    public void play(int pitIndex) {
        if (!isGameFinished() && pitIndex >= 0 && pitIndex < 6) {
            int stonesToMove = currentPlayer.getPits().get(pitIndex).removeStones();
            int currentPitIndex = pitIndex;

            while (stonesToMove > 0) {
                currentPitIndex = (currentPitIndex + 1) % 6;
                if (!(currentPlayer == player1 && currentPitIndex == 5) &&
                    !(currentPlayer == player2 && currentPitIndex == 0)) {
                    currentPlayer.getPits().get(currentPitIndex).addStones(1);
                    stonesToMove--;
                }
            }

            // Check for capturing stones
            if (currentPlayer.getPits().get(currentPitIndex).getStones() == 1 &&
                currentPitIndex >= 0 && currentPitIndex < 6) {
                int oppositePitIndex = 5 - currentPitIndex;
                if (currentPlayer == player1 && currentPitIndex < 6 &&
                    player1.getPits().get(currentPitIndex).getStones() == 1 &&
                    player2.getPits().get(oppositePitIndex).getStones() > 0) {
                    int capturedStones = player1.getPits().get(currentPitIndex).removeStones() +
                                         player2.getPits().get(oppositePitIndex).removeStones();
                    player1.getStore().addStones(capturedStones);
                } else if (currentPlayer == player2 && currentPitIndex >= 0 &&
                           player2.getPits().get(currentPitIndex).getStones() == 1 &&
                           player1.getPits().get(oppositePitIndex).getStones() > 0) {
                    int capturedStones = player2.getPits().get(currentPitIndex).removeStones() +
                                         player1.getPits().get(oppositePitIndex).removeStones();
                    player2.getStore().addStones(capturedStones);
                }
            }

            // Switch players
            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }
    }

    public boolean isGameFinished() {
        return !player1.hasStonesInPits() || !player2.hasStonesInPits();
    }

    public void printBoard() {
        System.out.println("Player 2's Store: " + player2.getStore().getStones());
        for (int i = 5; i >= 0; i--) {
            System.out.print(player2.getPits().get(i).getStones() + " ");
        }
        System.out.println();
        System.out.print("  ");
        for (int i = 0; i < 6; i++) {
            System.out.print(" ");
        }
        System.out.println();
        for (int i = 0; i < 6; i++) {
            System.out.print(player1.getPits().get(i).getStones() + " ");
        }
        System.out.println();
        System.out.println("Player 1's Store: " + player1.getStore().getStones());
    }
}

public class Main {
    public static void main(String[] args) {
        MancalaGame game = new MancalaGame("Player 1", "Player 2");
        game.printBoard();

        while (!game.isGameFinished()) {
            // Simulate a move by Player 1 choosing a pit (0 to 5)
            game.play(2);
            game.printBoard();
        }
    }
}
