package ui;
import mancala.MancalaGame;
import mancala.GameNotOverException;
import mancala.InvalidMoveException;
import mancala.Player;


import java.util.Scanner;

public class TextUI {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create two players and the Mancala game
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        MancalaGame game = new MancalaGame();
        game.setPlayers(player1, player2);

        // Initialize the game board
        game.getBoard().initializeBoard();

        System.out.println("Mancala Game");

        while (!game.isGameOver()) {
            // Display the current state of the game
            System.out.println(game);   

            // Get the current player's move
            int currentPlayerIndex = game.getPlayers().indexOf(game.getCurrentPlayer());
            System.out.println(game.getCurrentPlayer().getName() + "'s turn.");
            System.out.print("Enter the pit number to move from (1-6 for Player 1, 7-12 for Player 2): ");

            try {
                int startPit = scanner.nextInt();
                int stonesRemaining = game.move(startPit);

                System.out.println("Stones remaining: " + stonesRemaining);
            } catch (InvalidMoveException e) {
                System.out.println("Invalid move: " + e.getMessage());
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid pit number.");
                scanner.nextLine(); // Clear the input buffer
            }
        }

        // Game over, display the winner
        System.out.println("Game Over!");
        try{
            Player winner = game.getWinner();
            System.out.println("The winner is: " + winner.getName());
            System.out.println("Final board state:");
            System.out.println(game);
        }catch(GameNotOverException e){
            System.out.println("Error");

        }
    }
}