import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    public static class Bogie {
        String type;
        int capacity;

        public Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println(" UC13 - Performance Comparison (Loops vs Streams) ");
        System.out.println("==========================================================\n");

        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("Type" + i, (int) (Math.random() * 100)));
        }

        long startLoop = System.nanoTime();
        List<Bogie> loopFiltered = filterWithLoop(bogies);
        long endLoop = System.nanoTime();
        long loopDuration = endLoop - startLoop;

        long startStream = System.nanoTime();
        List<Bogie> streamFiltered = filterWithStream(bogies);
        long endStream = System.nanoTime();
        long streamDuration = endStream - startStream;

        System.out.println("Loop Execution Time (ns): " + loopDuration);
        System.out.println("Stream Execution Time (ns): " + streamDuration);
        System.out.println("\nUC13 performance benchmarking completed...");
    }

    public static List<Bogie> filterWithLoop(List<Bogie> bogies) {
        List<Bogie> filtered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                filtered.add(b);
            }
        }
        return filtered;
    }

    public static List<Bogie> filterWithStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }
}