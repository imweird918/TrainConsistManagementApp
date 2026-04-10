public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println(" UC18 - Bogie Search using Linear Search ");
        System.out.println("==========================================================\n");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchTarget = "BG309";

        System.out.print("Bogie ID Inventory: ");
        for (String id : bogieIds) System.out.print(id + " ");
        System.out.println("\nSearching for: " + searchTarget);

        boolean found = findBogieById(bogieIds, searchTarget);

        if (found) {
            System.out.println("Result: Bogie " + searchTarget + " was found in the system.");
        } else {
            System.out.println("Result: Bogie " + searchTarget + " NOT found.");
        }

        System.out.println("\nUC18 search operation completed...");
    }

    public static boolean findBogieById(String[] ids, String target) {
        if (ids == null || target == null) return false;

        for (String id : ids) {
            if (id.equals(target)) {
                return true;
            }
        }
        return false;
    }
}