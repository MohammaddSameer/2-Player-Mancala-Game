package mancala;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pit> pits;
    private ArrayList<Store> stores;
    private Player playerOne;
    private Player playerTwo;

    public Board() {
        pits = new ArrayList<>();
        stores = new ArrayList<>();
    }

    public void setUpPits() {
        for (int i = 0; i < 12; i++) {
            pits.add(new Pit()); 
        }
    }

    public void setUpStores() {
        stores.add(new Store());
        stores.add(new Store());
    }

    public ArrayList<Pit> getPits() {
        return pits;
    }

    public ArrayList<Store> getStores() {
        return stores;
    }

    public int getNumStones(int pitNum) throws PitNotFoundException {
        if (pitNum >= 0 && pitNum < pits.size()) {
            return pits.get(pitNum-1).getStoneCount();
        } else {
            throw new PitNotFoundException();
        }
    }

    public void initializeBoard() {
        this.setUpPits();
        this.setUpStores();
        
        resetBoard();
    }
    
    
    

    public void resetBoard() {
        for (Pit pit : pits) {
            pit.removeStones();
            pit.addStone();
            pit.addStone();
            pit.addStone();
            pit.addStone();
        }
        for (Store store : stores) {
            store.emptyStore();
        }
    }

    public void registerPlayers(Player one, Player two) {
        playerOne = one;
        playerTwo = two;
        stores.get(0).setOwner(playerOne);
        one.setStore(getStores().get(0));
        stores.get(1).setOwner(playerTwo);
        two.setStore(getStores().get(1));
    }


    public int moveStones(int startPit, Player player) throws InvalidMoveException {

        if(getPits().get(startPit - 1).getStoneCount() == 0){

            throw new InvalidMoveException();

        }

        int stonesMoved = 0;
        int capStones = 0;
        int startStoreCount = player.getStoreCount();

        try{
            stonesMoved = this.distributeStones(startPit);
        } catch (PitNotFoundException e){
            throw new InvalidMoveException();
        }

        int storeDiff = player.getStoreCount() - startStoreCount;
        int end = ((startPit - 1) + stonesMoved - storeDiff) % 12;

        boolean endedOnSameSide = false;

        if((startPit >= 1 && startPit <= 6 && end + 1 >= 1 && end + 1 <= 6)
           || (startPit >= 7 && startPit <= 12 && end + 1 >= 7 && end + 1 <= 12)){

            endedOnSameSide = true;

           }
        
           if(this.getPits().get(end).getStoneCount() == 1 && endedOnSameSide){
            try{
                capStones = this.captureStones(end + 1);
                player.getStore().addStones(capStones);
            } catch (PitNotFoundException e){
                throw new InvalidMoveException();
            }
           }

        return capStones + storeDiff;
    }
    

    public int distributeStones(int startingPoint) throws PitNotFoundException {
        if (startingPoint <= 0 || startingPoint > 12) {
            throw new PitNotFoundException();
        }
    
        startingPoint--; // Adjust for 0-based index
    
        int stones = getPits().get(startingPoint).removeStones(); // Remove stones from the starting pit
        int totalStonesPlaced = stones; // Track the total stones placed
        boolean isLastPitStore = false;
        int playerStore = 0;

        for(int i = startingPoint + 1; i <= stones + startingPoint; i++){

            if(i % 6 == 0 && !isLastPitStore){
                int index = (i - 1) % 12;
                if(startingPoint / 6 == index / 6){
                    getStores().get(index / 6).addStones(1);
                    stones--;
                }
                i--;
                isLastPitStore = true;
            } else {
                getPits().get(i % 12).addStone();
                isLastPitStore = false;
            }
        }

    
        return totalStonesPlaced;
    }
    
    
    public int captureStones(int stoppingPoint) throws PitNotFoundException {
        if (stoppingPoint <= 0 || stoppingPoint > 12) {
            throw new PitNotFoundException();
        }
    
        int capturingPitIndex = 11 - stoppingPoint; 
    
        if (getPits().get(capturingPitIndex).getStoneCount() == 0) {
            return 0;
        }
    
        int capturedStones = 0;
    
        capturedStones += getPits().get(capturingPitIndex).removeStones();
    
        capturedStones += getPits().get(stoppingPoint - 1).removeStones();
    
        return capturedStones;
    }
    

    public boolean isSideEmpty(int pitNum) throws PitNotFoundException {
        if (pitNum < 1 || pitNum > 12) {
            throw new PitNotFoundException();
        }
    
        int startIndex;
        int endIndex;
    
        if (pitNum <= 6) {
            startIndex = 0;
            endIndex = 5;
        } else {
            startIndex = 7;
            endIndex = 12;
        }
    
        for (int i = startIndex; i <= endIndex; i++) {
            if (pits.get(i).getStoneCount() > 0) {
                return false;
            }
        }
    
        return true;
    }
    

    public String toString() {


        String ui = "";
        ui += ("         12   11   10    9    8   7\n");
        ui += ("   |---|----|----|----|----|----|----|----|\n");

        ui +="      ";
        for(int i = 11; i >= 6; i--){

            ui += " |  " + (getPits().get(i).getStoneCount());

        }
        ui += " |";
        ui += ("\nP2   " + getStores().get(0).getTotalStones() +  " |-----------------------------|  "
                + getStores().get(1).getTotalStones()+"    P1\n");

        ui += "      ";
        for(int i = 0; i < 6; i++){
            ui += " |  " + (getPits().get(i).getStoneCount());
        }
        ui += " |";

        ui += ("\n   |---|----|----|----|----|----|----|----|\n");
        ui += ("         1    2    3    4    5    6\n");


        return ui;
    }
}


