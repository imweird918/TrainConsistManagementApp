import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class TrainConsistManagementAppTest {

    @Test
    void testCargo_SafeAssignment() {
        TrainConsistManagementApp.GoodsBogie bogie = new TrainConsistManagementApp.GoodsBogie("Cylindrical");
        bogie.assignCargo("Petroleum");
        assertEquals("Petroleum", bogie.cargo);
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        TrainConsistManagementApp.GoodsBogie bogie = new TrainConsistManagementApp.GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");

        assertTrue(outContent.toString().contains("Error: Unsafe cargo assignment!"));
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        TrainConsistManagementApp.GoodsBogie bogie = new TrainConsistManagementApp.GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");
        assertNull(bogie.cargo);
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        TrainConsistManagementApp.GoodsBogie bogie1 = new TrainConsistManagementApp.GoodsBogie("Rectangular");
        TrainConsistManagementApp.GoodsBogie bogie2 = new TrainConsistManagementApp.GoodsBogie("Cylindrical");

        bogie1.assignCargo("Petroleum"); // Throws/Catches
        bogie2.assignCargo("Grain");     // Continues

        assertEquals("Grain", bogie2.cargo);
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        TrainConsistManagementApp.GoodsBogie bogie = new TrainConsistManagementApp.GoodsBogie("Rectangular");
        bogie.assignCargo("Petroleum");

        assertTrue(outContent.toString().contains("Cargo validation completed"));
    }
}