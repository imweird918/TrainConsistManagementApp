import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TrainConsistManagementAppTest {

    @Test
    void testSearch_BogieFound() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(TrainConsistManagementApp.findBogieById(ids, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(TrainConsistManagementApp.findBogieById(ids, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(TrainConsistManagementApp.findBogieById(ids, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        String[] ids = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(TrainConsistManagementApp.findBogieById(ids, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] ids = {"BG101"};
        assertTrue(TrainConsistManagementApp.findBogieById(ids, "BG101"));
    }
}