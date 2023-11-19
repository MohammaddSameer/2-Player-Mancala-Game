package mancala;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PitTest {

    @Test
    public void testGetStoneCountInitiallyZero() {
        Pit pit = new Pit();
        assertEquals(0, pit.getStoneCount());
    }

    @Test
    public void testAddStone() {
        Pit pit = new Pit();
        pit.addStone();
        assertEquals(1, pit.getStoneCount());
    }

    @Test
    public void testRemoveStones() {
        Pit pit = new Pit();
        pit.addStone();
        int removedStones = pit.removeStones();
        assertEquals(1, removedStones);
        assertEquals(0, pit.getStoneCount());
    }

}
