package mancala;

public class Player {
    private String name;
    private Store store;

    public Player() {
        name = "";
        store = null;
    }

    public Player(String name) {
        this.name = name;
        store = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public int getStoreCount() {
        if (store != null) {
            return store.getStones();
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Player: " + name + ", Store count: " + getStoreCount();
    }
}
