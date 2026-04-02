import java.util.LinkedHashSet;
import java.util.Set;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC5 - Preserve Insertion Order of Bogies ");
        System.out.println("==========================================\n");

        Set<String> orderedUniqueFormation = new LinkedHashSet<>();

        orderedUniqueFormation.add("Engine");
        orderedUniqueFormation.add("Sleeper");
        orderedUniqueFormation.add("Cargo");
        orderedUniqueFormation.add("Guard");

        orderedUniqueFormation.add("Sleeper");
        orderedUniqueFormation.add("Engine");

        System.out.println("Final Train Formation:");
        System.out.println(orderedUniqueFormation + "\n");

        System.out.println("Note:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.\n");

        System.out.println("UC5 formation setup completed...");
    }
}