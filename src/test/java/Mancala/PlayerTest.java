package mancala;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    public void testGetName() {
        Player player = new Player("John");
        assertEquals("John", player.getName());
    }

    @Test
    public void testSetStoreAndGetStore() {
        Player player = new Player();
        Store store = new Store();
        player.setStore(store);
        assertEquals(store, player.getStore());
    }

    @Test
    public void testGetStoreCount() {
        Player player = new Player();
        Store store = new Store();
        store.addStones(5);
        player.setStore(store);
        assertEquals(5, player.getStoreCount());
    }

}
