import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    public static class Coach {
        String type;
        int seatCount;

        public Coach(String type, int seatCount) {
            this.type = type;
            this.seatCount = seatCount;
        }

        public int getSeatCount() {
            return seatCount;
        }

        @Override
        public String toString() {
            return String.format("%s -> %d", type, seatCount);
        }
    }

    public static List<Coach> filterHighCapacity(List<Coach> inventory, int threshold) {
        return inventory.stream()
                .filter(c -> c.getSeatCount() > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Coach> inventory = new ArrayList<>();
        inventory.add(new Coach("Sleeper", 72));
        inventory.add(new Coach("AC Chair", 56));
        inventory.add(new Coach("First Class", 24));
        inventory.add(new Coach("General", 90));

        System.out.println("Full Inventory:");
        inventory.forEach(System.out::println);

        List<Coach> results = filterHighCapacity(inventory, 60);

        System.out.println("\nFiltered Results (> 60):");
        results.forEach(System.out::println);
    }
}