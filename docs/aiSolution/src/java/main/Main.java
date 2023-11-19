package mancala;

public class Main {
    public static void main(String[] args) {
        // Create players
        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");

        // Create a board
        Board board = new Board();
        board.initializeBoard(); // Initialize the board with stones

        // Connect players to their stores
        Store store1 = new Store();
        Store store2 = new Store();
        store1.setOwner(player1);
        store2.setOwner(player2);
        player1.setStore(store1);
        player2.setStore(store2);

        // Register players to the board
        board.registerPlayers(player1, player2);

        // Create the game
        MancalaGame game = new MancalaGame();
        game.setBoard(board);
        game.setPlayers(player1, player2);

        // Start the game
        game.startNewGame();

        // Perform some actions (placeholders)
        // Example: Get the current player
        Player currentPlayer = game.getCurrentPlayer();
        System.out.println("Current Player: " + currentPlayer.getName());

        // Example: Move stones from a pit
        int pitNumber = 3; // Assuming a valid pit number
        int stonesRemaining = game.move(pitNumber);
        System.out.println("Stones remaining after move: " + stonesRemaining);

        // Example: Check if the game is over
        boolean isOver = game.isGameOver();
        if (isOver) {
            Player winner = game.getWinner();
            System.out.println("Game Over! Winner: " + winner.getName());
        } else {
            System.out.println("Game is still in progress.");
        }

        // Print the board state
        System.out.println("Board State:\n" + board.toString());
    }
}
