import java.util.HashSet;
import java.util.Set;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC3 - Track Unique Bogie IDs ");
        System.out.println("==========================================\n");

        Set<String> uniqueBogieIdentifiers = new HashSet<>();

        uniqueBogieIdentifiers.add("BG101");
        uniqueBogieIdentifiers.add("BG102");
        uniqueBogieIdentifiers.add("BG103");
        uniqueBogieIdentifiers.add("BG104");

        uniqueBogieIdentifiers.add("BG101");
        uniqueBogieIdentifiers.add("BG102");

        System.out.println("Bogie IDs After Insertion:");
        System.out.println(uniqueBogieIdentifiers + "\n");

        System.out.println("Note:");
        System.out.println("Duplicates are automatically ignored by HashSet.\n");

        System.out.println("UC3 uniqueness validation completed...");
    }
}