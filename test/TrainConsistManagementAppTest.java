import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TrainConsistManagementAppTest {

    @Test
    void testException_ValidCapacityCreation() throws TrainConsistManagementApp.InvalidCapacityException {
        TrainConsistManagementApp.PassengerBogie bogie = new TrainConsistManagementApp.PassengerBogie("Sleeper", 72);
        assertNotNull(bogie);
        assertEquals(72, bogie.capacity);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception exception = assertThrows(TrainConsistManagementApp.InvalidCapacityException.class, () -> {
            new TrainConsistManagementApp.PassengerBogie("AC", -10);
        });
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        assertThrows(TrainConsistManagementApp.InvalidCapacityException.class, () -> {
            new TrainConsistManagementApp.PassengerBogie("General", 0);
        });
    }

    @Test
    void testException_ExceptionMessageValidation() {
        try {
            new TrainConsistManagementApp.PassengerBogie("Chair Car", 0);
            fail("Expected InvalidCapacityException was not thrown");
        } catch (TrainConsistManagementApp.InvalidCapacityException e) {
            assertEquals("Capacity must be greater than zero", e.getMessage());
        }
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws TrainConsistManagementApp.InvalidCapacityException {
        TrainConsistManagementApp.PassengerBogie bogie = new TrainConsistManagementApp.PassengerBogie("First Class", 24);
        assertEquals("First Class", bogie.type);
        assertEquals(24, bogie.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws TrainConsistManagementApp.InvalidCapacityException {
        TrainConsistManagementApp.PassengerBogie b1 = new TrainConsistManagementApp.PassengerBogie("TypeA", 10);
        TrainConsistManagementApp.PassengerBogie b2 = new TrainConsistManagementApp.PassengerBogie("TypeB", 20);
        assertNotSame(b1, b2);
    }
}