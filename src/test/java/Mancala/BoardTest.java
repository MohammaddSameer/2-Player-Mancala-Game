package mancala;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;;


public class BoardTest {
    private Board board;
    private Player player1;
    private Player player2;

    @BeforeEach
    public void setUp() {
        board = new Board();
        board.initializeBoard();
        player1 = new Player("Player1");
        player2 = new Player("Player2");
        board.registerPlayers(player1, player2);

    }
    private int getPitValue(int pit){
        return board.getPits().get(pit-1).getStoneCount();
    }

    private int getStoreValue(int store){
        return board.getStores().get(store-1).getTotalStones();
    }

    @Test
    public void testSetUpPitsAndGetPits() {

        for (Pit pit : board.getPits()) {
            assertEquals(4, pit.getStoneCount());
        }
    }



        @Test
    public void testMoveStonesValidMove() throws InvalidMoveException,PitNotFoundException {
        // Assuming you have a valid move (e.g., startPit = 1)
        int startPit = 3;

        // Perform the move
        int stonesAddedToStore = board.moveStones(startPit, player1);
        assertEquals(5,getPitValue(4));

        assertEquals(1,player1.getStoreCount());

    }

    @Test
    public void testMoveStonesInvalidMove() {
        // Assuming you have an invalid move (e.g., startPit = 0, which is out of bounds)

        // The method should throw an InvalidMoveException for an invalid move
        assertThrows(InvalidMoveException.class, () -> board.moveStones(14, player1));
    }

    @Test
    public void testMoveStonesCaptureStones() throws InvalidMoveException,Exception{
        // Manually set up the board for capturing opponent's stones
        // For example, arrange the pits and stones to simulate capturing
        // Player1's last stone lands in an empty pit on their side, capturing opponent's stones

        // Set up the board state


      

        // Perform the move that captures opponent's stones
 

        // Assertions
        // You can assert the expected captured stones and other game conditions
        // For example, assert that player1's store has increased by the expected amount


    }





        @Test
    void testResetBoard() {
        // Manually remove stones from a pit
        Pit pit = board.getPits().get(0);
        pit.removeStones();
        assertEquals(0, pit.getStoneCount());

        // Reset the board
        board.resetBoard();

        // Verify that the pit has been reset to 4 stones
        assertEquals(4, pit.getStoneCount());
    }


    @Test
    void isSideEmpty() throws PitNotFoundException{
        board.initializeBoard();
        assertFalse(board.isSideEmpty(1));
        assertFalse(board.isSideEmpty(7));
        for (int i = 0; i < 6; i++) {
            board.getPits().get(i).removeStones();
        }

        assertTrue(board.isSideEmpty(1));
        assertFalse(board.isSideEmpty(7));
        assertThrows(PitNotFoundException.class, () -> board.isSideEmpty(0));
        assertThrows(PitNotFoundException.class, () -> board.isSideEmpty(13));
        
    }



}
