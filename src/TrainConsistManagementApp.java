import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    public static class GoodsBogie {
        String type;
        String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println(" UC12 - Safety Compliance Check for Goods Bogies ");
        System.out.println("==========================================================\n");

        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal"));

        System.out.println("Goods Bogies in Train:");
        goodsBogies.forEach(b -> System.out.println(b.type + " -> " + b.cargo));
        System.out.println();

        boolean isSafe = validateSafety(goodsBogies);

        System.out.println("Safety Compliance Status: " + isSafe);
        System.out.println("Train formation is " + (isSafe ? "SAFE." : "NOT SAFE."));
        System.out.println("\nUC12 safety validation completed...");
    }

    public static boolean validateSafety(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b -> !"Cylindrical".equalsIgnoreCase(b.type) ||
                        "Petroleum".equalsIgnoreCase(b.cargo));
    }
}