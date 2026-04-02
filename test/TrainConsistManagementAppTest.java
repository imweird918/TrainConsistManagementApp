import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class TrainConsistManagementAppTest {

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<TrainConsistManagementApp.Coach> inventory = Arrays.asList(
                new TrainConsistManagementApp.Coach("Express", 70)
        );
        List<TrainConsistManagementApp.Coach> result = TrainConsistManagementApp.filterHighCapacity(inventory, 60);
        assertEquals(1, result.size());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<TrainConsistManagementApp.Coach> inventory = Arrays.asList(
                new TrainConsistManagementApp.Coach("Standard", 60)
        );
        // Should be empty because condition is > 60
        List<TrainConsistManagementApp.Coach> result = TrainConsistManagementApp.filterHighCapacity(inventory, 60);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<TrainConsistManagementApp.Coach> inventory = Arrays.asList(
                new TrainConsistManagementApp.Coach("Mini", 30)
        );
        List<TrainConsistManagementApp.Coach> result = TrainConsistManagementApp.filterHighCapacity(inventory, 60);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<TrainConsistManagementApp.Coach> inventory = Arrays.asList(
                new TrainConsistManagementApp.Coach("A", 70),
                new TrainConsistManagementApp.Coach("B", 80),
                new TrainConsistManagementApp.Coach("C", 20)
        );
        List<TrainConsistManagementApp.Coach> result = TrainConsistManagementApp.filterHighCapacity(inventory, 60);
        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<TrainConsistManagementApp.Coach> inventory = Arrays.asList(
                new TrainConsistManagementApp.Coach("A", 10),
                new TrainConsistManagementApp.Coach("B", 20)
        );
        List<TrainConsistManagementApp.Coach> result = TrainConsistManagementApp.filterHighCapacity(inventory, 60);
        assertEquals(0, result.size());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<TrainConsistManagementApp.Coach> inventory = Arrays.asList(
                new TrainConsistManagementApp.Coach("A", 100),
                new TrainConsistManagementApp.Coach("B", 200)
        );
        List<TrainConsistManagementApp.Coach> result = TrainConsistManagementApp.filterHighCapacity(inventory, 60);
        assertEquals(2, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<TrainConsistManagementApp.Coach> inventory = new ArrayList<>();
        List<TrainConsistManagementApp.Coach> result = TrainConsistManagementApp.filterHighCapacity(inventory, 60);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Coach> inventory = new ArrayList<>();
        inventory.add(new TrainConsistManagementApp.Coach("A", 100));

        TrainConsistManagementApp.filterHighCapacity(inventory, 60);

        // Streams should not mutate the source list
        assertEquals(1, inventory.size(), "The original list should remain unmodified.");
    }
}