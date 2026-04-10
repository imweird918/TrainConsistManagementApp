/**
 * ==========================================================
 * MAIN CLASS - TrainConsistManagementApp
 * ==========================================================
 * * Use Case 16: Sort Passenger Bogies by Capacity
 * * Description:
 * This class demonstrates manual sorting of passenger
 * bogie capacities using the Bubble Sort algorithm
 * instead of built-in sorting utilities.
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println(" UC16 - Manual Sorting using Bubble Sort ");
        System.out.println("==========================================================\n");

        // Create array of passenger bogie capacities
        int[] capacities = {72, 56, 24, 70, 60};

        // Display original order
        System.out.println("Original Capacities:");
        displayArray(capacities);

        // ---- BUBBLE SORT LOGIC ----
        bubbleSort(capacities);

        // Display sorted result
        System.out.println("\nSorted Capacities (Ascending):");
        displayArray(capacities);

        System.out.println("\nUC16 sorting completed...");
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // Outer loop controls number of passes
        for (int i = 0; i < n - 1; i++) {
            // Inner loop compares adjacent values
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap values when required
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void displayArray(int[] arr) {
        for (int c : arr) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}