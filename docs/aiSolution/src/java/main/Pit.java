package mancala;

public class Pit {
    private int stoneCount;

    public Pit() {
        stoneCount = 0;
    }

    public int getStones() {
        return stoneCount;
    }

    public void addStone(int stones) {
        stoneCount++;
    }

    public int removeStones() {
        int stonesRemoved = stoneCount;
        stoneCount = 0;
        return stonesRemoved;
    }

    @Override
    public String toString() {
        return "Pit with " + stoneCount + " stones.";
    }
}
