import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TrainConsistManagementAppTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] ids = {};
        assertThrows(IllegalStateException.class, () -> {
            TrainConsistManagementApp.validateAndSearch(ids, "BG101");
        });
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] ids = {"BG101", "BG205"};
        assertDoesNotThrow(() -> {
            TrainConsistManagementApp.validateAndSearch(ids, "BG101");
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] ids = {"BG101", "BG205", "BG309"};
        assertTrue(TrainConsistManagementApp.validateAndSearch(ids, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] ids = {"BG101", "BG205", "BG309"};
        assertFalse(TrainConsistManagementApp.validateAndSearch(ids, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] ids = {"BG101"};
        assertTrue(TrainConsistManagementApp.validateAndSearch(ids, "BG101"));
    }
}