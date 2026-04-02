import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrainConsistManagementAppTest {

    @Test
    void testReduce_TotalSeatCalculation() {
        List<TrainConsistManagementApp.Coach> inventory = Arrays.asList(
                new TrainConsistManagementApp.Coach("Sleeper", 72),
                new TrainConsistManagementApp.Coach("AC Chair", 56)
        );
        int total = TrainConsistManagementApp.calculateTotalSeats(inventory);
        assertEquals(128, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<TrainConsistManagementApp.Coach> inventory = Arrays.asList(
                new TrainConsistManagementApp.Coach("A", 10),
                new TrainConsistManagementApp.Coach("B", 20),
                new TrainConsistManagementApp.Coach("C", 30)
        );
        assertEquals(60, TrainConsistManagementApp.calculateTotalSeats(inventory));
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<TrainConsistManagementApp.Coach> inventory = Arrays.asList(
                new TrainConsistManagementApp.Coach("Sleeper", 72)
        );
        assertEquals(72, TrainConsistManagementApp.calculateTotalSeats(inventory));
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<TrainConsistManagementApp.Coach> inventory = new ArrayList<>();
        assertEquals(0, TrainConsistManagementApp.calculateTotalSeats(inventory));
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<TrainConsistManagementApp.Coach> inventory = Arrays.asList(
                new TrainConsistManagementApp.Coach("Test", 50)
        );
        // Indirectly verifies map() by checking if the specific value is captured
        assertEquals(50, TrainConsistManagementApp.calculateTotalSeats(inventory));
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<TrainConsistManagementApp.Coach> inventory = Arrays.asList(
                new TrainConsistManagementApp.Coach("A", 1),
                new TrainConsistManagementApp.Coach("B", 1),
                new TrainConsistManagementApp.Coach("C", 1)
        );
        assertEquals(3, TrainConsistManagementApp.calculateTotalSeats(inventory));
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Coach> inventory = new ArrayList<>();
        inventory.add(new TrainConsistManagementApp.Coach("Sleeper", 72));

        TrainConsistManagementApp.calculateTotalSeats(inventory);

        assertEquals(1, inventory.size(), "Aggregation should not modify the original list.");
    }
}