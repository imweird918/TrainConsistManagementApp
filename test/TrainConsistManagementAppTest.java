import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(TrainConsistManagementApp.isValidTrainID("TRN-6524"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(TrainConsistManagementApp.isValidTrainID("TRAIN-1234"));
        assertFalse(TrainConsistManagementApp.isValidTrainID("TRN1234"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(TrainConsistManagementApp.isValidCargoCode("PET-FH"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(TrainConsistManagementApp.isValidCargoCode("PET-abc"));
        assertFalse(TrainConsistManagementApp.isValidCargoCode("CARGO-AB"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(TrainConsistManagementApp.isValidTrainID("TRN-123"));
        assertFalse(TrainConsistManagementApp.isValidTrainID("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(TrainConsistManagementApp.isValidCargoCode("pet-AB"));
        assertFalse(TrainConsistManagementApp.isValidCargoCode("PET-aB"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(TrainConsistManagementApp.isValidTrainID(""));
        assertFalse(TrainConsistManagementApp.isValidCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(TrainConsistManagementApp.isValidTrainID(" TRN-1234 "));
        assertFalse(TrainConsistManagementApp.isValidCargoCode("PET-ABC"));
    }
}