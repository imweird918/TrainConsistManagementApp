import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    public static class Coach {
        String type;
        int seatCount;

        public Coach(String type, int seatCount) {
            this.type = type;
            this.seatCount = seatCount;
        }

        public int getSeatCount() { return seatCount; }
        public String getType() { return type; }

        @Override
        public String toString() {
            return String.format("%s -> %d", type, seatCount);
        }
    }

    public static int calculateTotalSeats(List<Coach> inventory) {
        return inventory.stream()
                .map(Coach::getSeatCount) // Extract capacity
                .reduce(0, Integer::sum);  // Aggregate into total
    }

    public static void main(String[] args) {
        List<Coach> inventory = new ArrayList<>();
        inventory.add(new Coach("Sleeper", 72));
        inventory.add(new Coach("AC Chair", 56));
        inventory.add(new Coach("First Class", 24));
        inventory.add(new Coach("Sleeper", 70));

        System.out.println("Coaches in Train:");
        inventory.forEach(System.out::println);

        int totalSeats = calculateTotalSeats(inventory);

        System.out.println("\nTotal Seating Capacity of Train: " + totalSeats);
        System.out.println("\nUC10 aggregation completed...");
    }
}