package mancala;

import java.util.ArrayList;

public class MancalaGame {
    private Board board;
    private ArrayList<Player> players;
    private Player currentPlayer;

    public MancalaGame() {
        players = new ArrayList<>();
        board = null;
        currentPlayer = null;
    }

    public void setPlayers(Player onePlayer, Player twoPlayer) {
        players.add(onePlayer);
        players.add(twoPlayer);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player player) {
        currentPlayer = player;
    }

    public void setBoard(Board theBoard) {
        board = theBoard;
    }

    public Board getBoard() {
        return board;
    }

    public int getNumStones(int pitNum) {
        if (board == null || pitNum < 0 || pitNum >= board.getPits().size()) {
            return -1; // Placeholder for invalid pit number
        }
        return board.getPits().get(pitNum).getStones();
    }

    public int move(int startPit) {
        if (board == null || startPit < 0 || startPit >= board.getPits().size()) {
            return -1; // Placeholder for invalid move
        }
        // Logic to perform a move in the game
        return 0; // Placeholder return value
    }

    public int getStoreCount(Player player) {
        if (!players.contains(player)) {
            return -1; // Placeholder for player not found
        }
        return player.getStore().getStones();
    }

    public Player getWinner() {
        // Logic to determine the winner of the game
        return null; // Placeholder return value
    }

    public boolean isGameOver() {
        // Logic to check if the game is over
        return false; // Placeholder return value
    }

    public void startNewGame() {
        // Logic to reset the board and start a new game
    }

    @Override
    public String toString() {
        // Logic to generate a string representation of the game and board
        return "Mancala Game: " + board.toString(); // Placeholder return value
    }
}
