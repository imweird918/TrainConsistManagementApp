import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class TrainConsistManagementAppTest {

    @Test
    void testLoopFilteringLogic() {
        List<TrainConsistManagementApp.Bogie> bogies = List.of(
                new TrainConsistManagementApp.Bogie("Heavy", 70),
                new TrainConsistManagementApp.Bogie("Light", 30)
        );
        List<TrainConsistManagementApp.Bogie> result = TrainConsistManagementApp.filterWithLoop(bogies);
        assertEquals(1, result.size());
        assertTrue(result.get(0).capacity > 60);
    }

    @Test
    void testStreamFilteringLogic() {
        List<TrainConsistManagementApp.Bogie> bogies = List.of(
                new TrainConsistManagementApp.Bogie("Heavy", 80),
                new TrainConsistManagementApp.Bogie("Light", 40)
        );
        List<TrainConsistManagementApp.Bogie> result = TrainConsistManagementApp.filterWithStream(bogies);
        assertEquals(1, result.size());
        assertTrue(result.get(0).capacity > 60);
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<TrainConsistManagementApp.Bogie> bogies = List.of(
                new TrainConsistManagementApp.Bogie("A", 10),
                new TrainConsistManagementApp.Bogie("B", 65),
                new TrainConsistManagementApp.Bogie("C", 90)
        );
        List<TrainConsistManagementApp.Bogie> loopResult = TrainConsistManagementApp.filterWithLoop(bogies);
        List<TrainConsistManagementApp.Bogie> streamResult = TrainConsistManagementApp.filterWithStream(bogies);
        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        long start = System.nanoTime();
        try { Thread.sleep(1); } catch (InterruptedException e) {}
        long end = System.nanoTime();
        assertTrue((end - start) > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<TrainConsistManagementApp.Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            bogies.add(new TrainConsistManagementApp.Bogie("B", 75));
        }
        List<TrainConsistManagementApp.Bogie> result = TrainConsistManagementApp.filterWithStream(bogies);
        assertEquals(5000, result.size());
    }
}