import java.util.ArrayList;

public class Main {
    public static void main(String [] args) {
        Simulation simulation = new Simulation();

        ArrayList<Item> phase_1_items = simulation.loadItems(Simulation.PHASE_1_FILE_NAME);
        ArrayList<Item> phase_2_items = simulation.loadItems(Simulation.PHASE_2_FILE_NAME);

        ArrayList<Item> all_items = new ArrayList<>();
        all_items.addAll(phase_1_items);
        all_items.addAll(phase_2_items);

        ArrayList<Rocket> u1s = simulation.loadU1(all_items);
        ArrayList<Rocket> u2s = simulation.loadU2(all_items);

        double totalMoneyU1 = simulation.runSimulation(u1s);
        double totalMoneyU2 = simulation.runSimulation(u2s);

        System.out.println("u1 cost: " + totalMoneyU1);
        System.out.println("u2 cost: " + totalMoneyU2);
    }
}
