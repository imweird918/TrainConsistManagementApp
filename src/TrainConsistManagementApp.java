import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    public static class Coach {
        String type;
        int seatCount;

        public Coach(String type, int seatCount) {
            this.type = type;
            this.seatCount = seatCount;
        }

        public String getType() { return type; }
        public int getSeatCount() { return seatCount; }

        @Override
        public String toString() {
            return String.format("Capacity -> %d", seatCount);
        }
    }

    public static Map<String, List<Coach>> groupByType(List<Coach> inventory) {
        return inventory.stream()
                .collect(Collectors.groupingBy(Coach::getType));
    }

    public static void main(String[] args) {
        List<Coach> inventory = new ArrayList<>();
        inventory.add(new Coach("Sleeper", 72));
        inventory.add(new Coach("AC Chair", 56));
        inventory.add(new Coach("First Class", 24));
        inventory.add(new Coach("Sleeper", 70));
        inventory.add(new Coach("AC Chair", 60));

        System.out.println("All Coaches:");
        inventory.forEach(c -> System.out.println(c.getType() + " -> " + c.getSeatCount()));

        Map<String, List<Coach>> grouped = groupByType(inventory);

        System.out.println("\nGrouped Coaches:");
        grouped.forEach((type, list) -> {
            System.out.println("\nCoach Type: " + type);
            list.forEach(System.out::println);
        });

        System.out.println("\nUC9 grouping completed...");
    }
}