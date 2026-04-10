import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TrainConsistManagementAppTest {

    @Test
    void testSort_BasicSorting() {
        // Verifies that the Bubble Sort algorithm correctly sorts a typical unsorted array
        int[] capacities = {72, 56, 24, 70, 60};
        TrainConsistManagementApp.bubbleSort(capacities);
        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, capacities);
    }

    @Test
    void testSort_AlreadySortedArray() {
        // Verifies that an already sorted array remains unchanged after sorting
        int[] capacities = {24, 56, 60, 70, 72};
        TrainConsistManagementApp.bubbleSort(capacities);
        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, capacities);
    }

    @Test
    void testSort_DuplicateValues() {
        // Verifies that duplicate capacities are handled correctly during sorting
        int[] capacities = {72, 56, 56, 24};
        TrainConsistManagementApp.bubbleSort(capacities);
        assertArrayEquals(new int[]{24, 56, 56, 72}, capacities);
    }

    @Test
    void testSort_SingleElementArray() {
        // Verifies that sorting a single element array does not modify the array
        int[] capacities = {50};
        TrainConsistManagementApp.bubbleSort(capacities);
        assertArrayEquals(new int[]{50}, capacities);
    }

    @Test
    void testSort_AllEqualValues() {
        // Verifies that arrays containing identical values remain unchanged
        int[] capacities = {40, 40, 40};
        TrainConsistManagementApp.bubbleSort(capacities);
        assertArrayEquals(new int[]{40, 40, 40}, capacities);
    }
}