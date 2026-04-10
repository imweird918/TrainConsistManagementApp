import java.util.Arrays;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println(" UC17 - Alphabetical Sorting using Arrays.sort() ");
        System.out.println("==========================================================\n");

        String[] bogieTypes = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Original Bogie Types:");
        displayArray(bogieTypes);

        sortBogieTypes(bogieTypes);

        System.out.println("\nSorted Bogie Types (Alphabetical):");
        displayArray(bogieTypes);

        System.out.println("\nUC17 sorting completed...");
    }

    public static void sortBogieTypes(String[] types) {
        if (types != null) {
            Arrays.sort(types);
        }
    }

    private static void displayArray(String[] arr) {
        for (String type : arr) {
            System.out.print("[" + type + "] ");
        }
        System.out.println();
    }
}