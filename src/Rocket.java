public class Rocket implements SpaceShip {
    private double money;
    private double maxItemWeight;
    private double weight;
    private int itemsWeight = 0;

    public Rocket(int maxItemWeight, int weight, double money) {
        this.maxItemWeight = maxItemWeight;
        this.weight = weight;
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public double getWeight() {
        return weight;
    }

    public double getMaxItemWeight() {
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
