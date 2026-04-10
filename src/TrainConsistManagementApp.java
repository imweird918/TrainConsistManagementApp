import java.util.Arrays;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println(" UC19 - Bogie Search using Binary Search ");
        System.out.println("==========================================================\n");

        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        String searchTarget = "BG205";

        System.out.println("Original IDs: " + Arrays.toString(bogieIds));

        // Binary search requires sorted input
        boolean found = binarySearchBogie(bogieIds, searchTarget);

        System.out.println("Searching for: " + searchTarget);
        System.out.println("Result: " + (found ? "Bogie found in system." : "Bogie not found."));

        System.out.println("\nUC19 search operation completed...");
    }

    public static boolean binarySearchBogie(String[] ids, String target) {
        if (ids == null || ids.length == 0 || target == null) {
            return false;
        }

        // Requirement: Ensure array is sorted for Binary Search
        Arrays.sort(ids);

        int low = 0;
        int high = ids.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = target.compareTo(ids[mid]);

            if (comparison == 0) {
                return true;
            } else if (comparison > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}