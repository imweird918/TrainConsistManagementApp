import java.util.HashMap;
import java.util.Map;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC6 - Map Bogie to Capacity (HashMap) ");
        System.out.println("==========================================\n");

        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        bogieCapacityMap.put("First Class", 24);
        bogieCapacityMap.put("Cargo", 120);
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 56);

        System.out.println("Bogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nUC6 bogie-capacity mapping completed...");
    }
}