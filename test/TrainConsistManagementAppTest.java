import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TrainConsistManagementAppTest {

    @Test
    void testBinarySearch_BogieFound() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(TrainConsistManagementApp.binarySearchBogie(ids, "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(TrainConsistManagementApp.binarySearchBogie(ids, "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(TrainConsistManagementApp.binarySearchBogie(ids, "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(TrainConsistManagementApp.binarySearchBogie(ids, "BG550"));
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        String[] ids = {"BG101"};
        assertTrue(TrainConsistManagementApp.binarySearchBogie(ids, "BG101"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] ids = {};
        assertFalse(TrainConsistManagementApp.binarySearchBogie(ids, "BG101"));
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] ids = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        // The method sorts the array internally to handle this
        assertTrue(TrainConsistManagementApp.binarySearchBogie(ids, "BG205"));
    }
}