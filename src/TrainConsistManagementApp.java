import java.util.Arrays;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println(" UC20 - State Validation and Search ");
        System.out.println("==========================================================\n");

        String[] bogieIds = {"BG101", "BG205", "BG309"};
        String searchTarget = "BG205";

        try {
            boolean found = validateAndSearch(bogieIds, searchTarget);
            System.out.println("Bogie IDs: " + Arrays.toString(bogieIds));
            System.out.println("Searching for: " + searchTarget);
            System.out.println("Result: " + (found ? "Found" : "Not Found"));
        } catch (IllegalStateException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }

        System.out.println("\nUC20 operation completed...");
    }

    public static boolean validateAndSearch(String[] ids, String target) {
        // Validation Rule: Data must exist
        if (ids == null || ids.length == 0) {
            throw new IllegalStateException("Bogie data is empty! Search cannot be performed.");
        }

        // Search logic
        for (String id : ids) {
            if (id != null && id.equals(target)) {
                return true;
            }
        }
        return false;
    }
}