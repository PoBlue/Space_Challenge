public class U2 extends Rocket {
    public U2() {
        super(29,18, 1.2);
    }

    @Override
    public boolean land() {
        double landProbability = 0.04 * (super.getWeight() / super.getMaxItemWeight());
        return Math.random() > landProbability;
    }

    @Override
    public boolean launch() {
        double launchProbability = 0.08 * (super.getWeight() / super.getMaxItemWeight());
        return Math.random() > launchProbability;
    }
}
