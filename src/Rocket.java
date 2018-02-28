public class Rocket implements SpaceShip {
    private int maxItemWeight;
    private int weight;
    private int itemsWeight = 0;

    public Rocket(int maxItemWeight, int weight) {
        this.maxItemWeight = maxItemWeight;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getMaxItemWeight() {
        return maxItemWeight;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return ( this.weight + this.itemsWeight + item.getWeight() ) <= maxItemWeight;
    }

    @Override
    public void carry(Item item) {
        this.itemsWeight += item.getWeight();
    }
}
