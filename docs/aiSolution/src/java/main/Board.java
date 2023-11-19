package mancala;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pit> pits;
    private ArrayList<Store> stores;

    public Board() {
        pits = new ArrayList<>();
        stores = new ArrayList<>();
        setUpPits();
        setUpStores();
    }

    public void setUpPits() {
        for (int i = 0; i < 12; i++) {
            pits.add(new Pit());
        }
    }

    public ArrayList<Pit> getPits() {
        return pits;
    }

    public ArrayList<Store> getStores() {
        return stores;
    }

    public void setUpStores() {
        for (int i = 0; i < 2; i++) {
            stores.add(new Store());
        }
    }

    public void initializeBoard() {
        for (Pit pit : pits) {
            pit.addStone(4); // Initialize each pit with 4 stones
        }
    }

    public void resetBoard() {
        for (Pit pit : pits) {
            pit.removeStones(); // Clear stones from pits
        }
        for (Store store : stores) {
            store.clearStones(); // Clear stones from stores
        }
        initializeBoard(); // Reset the board by redistributing stones
    }

    public void registerPlayers(Player one, Player two) {
        stores.get(0).setOwner(one); // Connect player one to their store
        stores.get(1).setOwner(two); // Connect player two to their store
        one.setStore(stores.get(0)); // Connect store to player one
        two.setStore(stores.get(1)); // Connect store to player two
    }

    public int moveStones(int startPit, Player player) {
        int stonesToDistribute = pits.get(startPit).removeStones();
        int currentIndex = startPit + 1;

        while (stonesToDistribute > 0) {
            if (currentIndex == 6 && player.equals(player.getStore().getOwner())) {
                stores.get(0).addStones(1);
                stonesToDistribute--;
            } else if (currentIndex == 13 && player.equals(player.getStore().getOwner())) {
                currentIndex = 0; // Loop around to opponent's side
            } else if (currentIndex == 13) {
                currentIndex = 0; // Loop back to own side after opponent's store
            } else {
                pits.get(currentIndex).addStone(1);
                stonesToDistribute--;
            }
            currentIndex++;
        }
        return currentIndex;
    }

    public boolean isSideEmpty(int pitNum) {
        if (pitNum < 0 || pitNum >= pits.size()) {
            return false; // Return false for invalid pit numbers
        }

        if (pitNum < 6) { // Check if pits 1-6 are empty
            for (int i = 0; i < 6; i++) {
                if (pits.get(i).getStones() != 0) {
                    return false;
                }
            }
        } else { // Check if pits 7-12 are empty
            for (int i = 7; i < 13; i++) {
                if (pits.get(i).getStones() != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder boardState = new StringBuilder();
        for (Pit pit : pits) {
            boardState.append("Pit ").append(pits.indexOf(pit) + 1).append(": ").append(pit.getStones()).append(" stones\n");
        }
        for (Store store : stores) {
            boardState.append("Store of ").append(store.getOwner().getName()).append(": ").append(store.getStones()).append(" stones\n");
        }
        return boardState.toString();
    }
}
