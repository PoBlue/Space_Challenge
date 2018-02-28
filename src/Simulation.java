import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    public final static String PHASE_1_FILE_NAME = "phase-1.txt";
    public final static String PHASE_2_FILE_NAME = "phase-2.txt";

    public ArrayList<Item> loadItems(String fileName) {
        ArrayList<Item> items = new ArrayList<>();

        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                //get a line
                String currentLine = scanner.nextLine();
                String itemName = getNameFromLine(currentLine);
                int weight = getWeightFromLine(currentLine);

                System.out.println(itemName);
                System.out.println(weight);

                items.add(new Item(itemName, weight));
            }

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }

        return items;
    }

    private String getNameFromLine(String line) {
        return line.substring(0, line.indexOf('='));
    }

    private int getWeightFromLine(String line) {
        String weight = line.substring(line.indexOf('=') + 1);
        return Integer.valueOf(weight) / 1000;
    }

    public ArrayList<U1> loadU1() {
        ArrayList<Item> phase_1_items = loadItems(PHASE_1_FILE_NAME);
        ArrayList<Item> phase_2_items = loadItems(PHASE_2_FILE_NAME);
        ArrayList<U1> u1s = new ArrayList<>();

        ArrayList<Item> all_items = new ArrayList<>();
        all_items.addAll(phase_1_items);
        all_items.addAll(phase_2_items);

        U1 currentRocket = new U1();
        int i = 0;
        while (i < all_items.size()) {
            Item item = all_items.get(i);

            if (currentRocket.canCarry(item)) {
                currentRocket.carry(item);
                i++;
            } else {
                u1s.add(currentRocket);
                currentRocket = new U1();
            }
        }

        return u1s;
    }

    public ArrayList<U2> loadU2() {
        ArrayList<Item> phase_1_items = loadItems(PHASE_1_FILE_NAME);
        ArrayList<Item> phase_2_items = loadItems(PHASE_2_FILE_NAME);
        ArrayList<U2> u2s = new ArrayList<>();

        ArrayList<Item> all_items = new ArrayList<>();
        all_items.addAll(phase_1_items);
        all_items.addAll(phase_2_items);

        U2 currentRocket = new U2();
        int i = 0;
        while (i < all_items.size()) {
            Item item = all_items.get(i);

            if (currentRocket.canCarry(item)) {
                currentRocket.carry(item);
                i++;
            } else {
                u2s.add(currentRocket);
                currentRocket = new U2();
            }
        }

        return u2s;
    }

    public void runSimulation() {
        
    }

}
