package mancala;

public class Player {

    private String newName;
    private Store newStore;

    public Player(){

        this.newName = "Player";
        this.newStore = new Store(); 
        this.newStore.setOwner(this); 
        
    }
    
    public void setName(String name){

        newName = name;

    }

    public void setStore(Store store){

        newStore = store;

    }

    public String getName(){

        return newName;
    }

    public Store getStore(){

        return newStore;

    }
    
    public int getStoreCount(){

        return newStore.getTotalStones();
    }

    public Player(String name) {

        this.newName = name;
        this.newStore = new Store(); 
        this.newStore.setOwner(this); 

    }

    public String toString(){

        return "Player: " + newName + ", Store Count: " + getStoreCount();
    }

    
}
