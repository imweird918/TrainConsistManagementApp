import java.util.Map;
import java.util.TreeMap;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC7 - Sort Bogies by ID (TreeMap) ");
        System.out.println("==========================================\n");

        Map<String, String> sortedBogieRegistry = new TreeMap<>();

        sortedBogieRegistry.put("BG104", "Sleeper");
        sortedBogieRegistry.put("BG101", "Engine");
        sortedBogieRegistry.put("BG103", "AC Chair");
        sortedBogieRegistry.put("BG102", "Cargo");

        System.out.println("Sorted Bogie Registry (By ID):");
        for (Map.Entry<String, String> entry : sortedBogieRegistry.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("\nUC7 sorting validation completed...");
    }
}