import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TrainConsistManagementAppTest {

    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] types = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        TrainConsistManagementApp.sortBogieTypes(types);
        String[] expected = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};
        assertArrayEquals(expected, types);
    }

    @Test
    void testSort_UnsortedInput() {
        String[] types = {"Luxury", "General", "Sleeper", "AC Chair"};
        TrainConsistManagementApp.sortBogieTypes(types);
        String[] expected = {"AC Chair", "General", "Luxury", "Sleeper"};
        assertArrayEquals(expected, types);
    }

    @Test
    void testSort_AlreadySortedArray() {
        String[] types = {"AC Chair", "First Class", "General"};
        TrainConsistManagementApp.sortBogieTypes(types);
        String[] expected = {"AC Chair", "First Class", "General"};
        assertArrayEquals(expected, types);
    }

    @Test
    void testSort_DuplicateBogieNames() {
        String[] types = {"Sleeper", "AC Chair", "Sleeper", "General"};
        TrainConsistManagementApp.sortBogieTypes(types);
        String[] expected = {"AC Chair", "General", "Sleeper", "Sleeper"};
        assertArrayEquals(expected, types);
    }

    @Test
    void testSort_SingleElementArray() {
        String[] types = {"Sleeper"};
        TrainConsistManagementApp.sortBogieTypes(types);
        String[] expected = {"Sleeper"};
        assertArrayEquals(expected, types);
    }
}