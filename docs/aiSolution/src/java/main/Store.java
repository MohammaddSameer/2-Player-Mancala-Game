package mancala;

public class Store {
    private int totalStones;
    private Player owner;

    public Store() {
        totalStones = 0;
        owner = null;
    }

    public void setOwner(Player player) {
        owner = player;
    }

    public Player getOwner() {
        return owner;
    }

    public void addStones(int amount) {
        totalStones += amount;
    }

    public int getStones() {
        return totalStones;
    }

    public int clearStones() {
        int stonesInStore = totalStones;
        totalStones = 0;
        return stonesInStore;
    }

    @Override
    public String toString() {
        return "Store owned by " + owner.getName() + " with " + totalStones + " stones.";
    }
}
