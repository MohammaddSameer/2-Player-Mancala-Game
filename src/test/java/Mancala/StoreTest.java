package mancala;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {

    @Test
    public void testGetTotalStonesInitiallyZero() {
        Store store = new Store();
        assertEquals(0, store.getTotalStones());
    }

    @Test
    public void testAddStones() {
        Store store = new Store();
        store.addStones(10);
        assertEquals(10, store.getTotalStones());
    }

    @Test
    public void testEmptyStore() {
        Store store = new Store();
        store.addStones(5);
        int removedStones = store.emptyStore();
        assertEquals(5, removedStones);
        assertEquals(0, store.getTotalStones());
    }

}
