public class U1 extends Rocket {
    public U1() {
        super(18, 10);
    }

    @Override
    public boolean land() {
        double landProbability = 0.05 * (super.getWeight() / super.getMaxItemWeight());
        return Math.random() > landProbability;
    }

    @Override
    public boolean launch() {
        double launchProbability = 0.01 * (super.getWeight() / super.getMaxItemWeight());
        return Math.random() > launchProbability;
    }
}
