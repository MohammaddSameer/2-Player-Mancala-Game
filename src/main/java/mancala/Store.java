package mancala;

public class Store {

    private int totalNumStones;
    private Player storeOwner;

    public Store(){

        totalNumStones = 0;

    }

    public void setOwner(Player player){

        storeOwner = player;

    }

    public Player getOwner(){

        return storeOwner;
    }

    public void addStones(int amount){
        
        totalNumStones += amount;

    }

    public int getTotalStones(){

        return totalNumStones;
    }

    public int emptyStore(){

        int currentNumStones = totalNumStones;
        totalNumStones = 0;

        return currentNumStones;
    }

    public String toString(){

        return "Store of " + storeOwner.getName() + ": " + getTotalStones() + " stones";
    }
    
}
