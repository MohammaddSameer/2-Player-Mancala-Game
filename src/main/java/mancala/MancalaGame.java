package mancala;

import java.util.ArrayList;

public class MancalaGame {
    private Board board;
    private ArrayList<Player> players;
    private Player currentPlayer;
    private Player winner;

    public MancalaGame() {
        board = new Board();
        players = new ArrayList<>();
        currentPlayer = null;
        winner = null;
    }

    public void setPlayers(Player onePlayer, Player twoPlayer) {
        players.clear();
        players.add(onePlayer);
        players.add(twoPlayer);
        currentPlayer = onePlayer;
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

    public int getNumStones(int pitNum) throws PitNotFoundException {
        if (pitNum < 1 || pitNum > 12){
            throw new PitNotFoundException();
        }

        return board.getNumStones(pitNum);
    }




    
    public int move(int startPit) throws InvalidMoveException {
        // Check if the game is already over
        if (isGameOver()) {
            throw new InvalidMoveException();
        }

        // Check if the provided startPit is within the valid range
        if (startPit < 1 || startPit > 12) {
            throw new InvalidMoveException();
        }

        // Determine the current player's index
        int playerIndex = getPlayers().indexOf(this.getCurrentPlayer());
        // Identify the index of the other player (opponent)
        int otherPlayerIndex = (playerIndex == 0) ? 1 : 0;

        // Check if the current player is trying to make a move from the opponent's side
        if ((playerIndex == 0 && startPit > 6) || (playerIndex == 1 && startPit <= 6)) {
            throw new InvalidMoveException();
        }

        // Call the moveStones method from the game board to perform the move
        int stonesMoved = this.getBoard().moveStones(startPit, this.getCurrentPlayer());

        // Check for a win condition (one player's side is empty)
        try{
        if (this.getBoard().isSideEmpty(1) || this.getBoard().isSideEmpty(7)) {
            // The game is over
            winner = players.get(0).getStoreCount() > players.get(1).getStoreCount() ? players.get(0) : players.get(1);
        } else {
            // Switch to the next player's turn
            currentPlayer = players.get(otherPlayerIndex);
        }
    }catch (PitNotFoundException e){
        System.out.println("Error");
        }
        return stonesMoved;
    }


    public int getStoreCount(Player player) throws NoSuchPlayerException {
        if (!players.contains(player)) {
            throw new NoSuchPlayerException();
        }
        return player.getStoreCount();
    }

    public Player getWinner() throws GameNotOverException {

        if (!isGameOver()){
            throw new GameNotOverException();
        }

        try {
            final int storeCountP1 = getStoreCount(players.get(0));
            final int storeCountP2 = getStoreCount(players.get(1));

            if(storeCountP1 > storeCountP2){

                return players.get(0);

            } else if(storeCountP2 > storeCountP1){

                return players.get(1);
            } else {
                return null;
            }
            }catch (NoSuchPlayerException e) {
                return null;
            }


    }


    public boolean isGameOver() {
        return winner != null;
    }

    public void startNewGame() {
        board.resetBoard();

        if(getPlayers().size() != 0){
            winner = null;
            currentPlayer = players.get(0);
        }

        isGameOver();
    }

    @Override
    public String toString() {
        return "Mancala Game\n" 
        + "Current Player: " + (currentPlayer != null ? currentPlayer.getName() : "None") + "\n" 
        + "Winner: " + (winner != null ? winner.getName() : "None") + "\n" 
        + board.toString();
    }
}
