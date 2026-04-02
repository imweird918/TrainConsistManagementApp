import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class TrainConsistManagementAppTest {

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<TrainConsistManagementApp.Coach> inventory = Arrays.asList(
                new TrainConsistManagementApp.Coach("Sleeper", 72),
                new TrainConsistManagementApp.Coach("Sleeper", 70)
        );
        Map<String, List<TrainConsistManagementApp.Coach>> result = TrainConsistManagementApp.groupByType(inventory);
        assertTrue(result.containsKey("Sleeper"));
        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<TrainConsistManagementApp.Coach> inventory = Arrays.asList(
                new TrainConsistManagementApp.Coach("AC Chair", 56),
                new TrainConsistManagementApp.Coach("AC Chair", 60)
        );
        Map<String, List<TrainConsistManagementApp.Coach>> result = TrainConsistManagementApp.groupByType(inventory);
        assertEquals(2, result.get("AC Chair").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        List<TrainConsistManagementApp.Coach> inventory = Arrays.asList(
                new TrainConsistManagementApp.Coach("Sleeper", 72),
                new TrainConsistManagementApp.Coach("AC Chair", 56)
        );
        Map<String, List<TrainConsistManagementApp.Coach>> result = TrainConsistManagementApp.groupByType(inventory);
        assertEquals(2, result.size());
        assertTrue(result.containsKey("Sleeper") && result.containsKey("AC Chair"));
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<TrainConsistManagementApp.Coach> inventory = new ArrayList<>();
        Map<String, List<TrainConsistManagementApp.Coach>> result = TrainConsistManagementApp.groupByType(inventory);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<TrainConsistManagementApp.Coach> inventory = Arrays.asList(
                new TrainConsistManagementApp.Coach("General", 90)
        );
        Map<String, List<TrainConsistManagementApp.Coach>> result = TrainConsistManagementApp.groupByType(inventory);
        assertEquals(1, result.size());
        assertTrue(result.containsKey("General"));
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        List<TrainConsistManagementApp.Coach> inventory = Arrays.asList(
                new TrainConsistManagementApp.Coach("Sleeper", 72),
                new TrainConsistManagementApp.Coach("AC Chair", 56),
                new TrainConsistManagementApp.Coach("First Class", 24)
        );
        Map<String, List<TrainConsistManagementApp.Coach>> result = TrainConsistManagementApp.groupByType(inventory);
        assertTrue(result.keySet().containsAll(Arrays.asList("Sleeper", "AC Chair", "First Class")));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        List<TrainConsistManagementApp.Coach> inventory = Arrays.asList(
                new TrainConsistManagementApp.Coach("Sleeper", 72),
                new TrainConsistManagementApp.Coach("Sleeper", 70),
                new TrainConsistManagementApp.Coach("AC Chair", 56)
        );
        Map<String, List<TrainConsistManagementApp.Coach>> result = TrainConsistManagementApp.groupByType(inventory);
        assertEquals(2, result.get("Sleeper").size());
        assertEquals(1, result.get("AC Chair").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<TrainConsistManagementApp.Coach> inventory = new ArrayList<>(Arrays.asList(
                new TrainConsistManagementApp.Coach("Sleeper", 72)
        ));
        TrainConsistManagementApp.groupByType(inventory);
        assertEquals(1, inventory.size());
    }
}