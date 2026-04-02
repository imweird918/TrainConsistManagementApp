import java.util.Scanner;
import java.util.regex.Pattern;

public class TrainConsistManagementApp {

    private static final String TRAIN_ID_PATTERN = "^TRN-\\d{4}$";
    private static final String CARGO_CODE_PATTERN = "^PET-[A-Z]{2}$";

    public static boolean isValidTrainID(String id) {
        return id != null && Pattern.matches(TRAIN_ID_PATTERN, id);
    }

    public static boolean isValidCargoCode(String code) {
        return code != null && Pattern.matches(CARGO_CODE_PATTERN, code);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Train ID & Cargo Validation ===");

        System.out.print("Enter Train ID (TRN-1234): ");
        String trainId = input.nextLine();

        System.out.print("Enter Cargo Code (PET-AB): ");
        String cargoCode = input.nextLine();

        System.out.println("\nResults:");
        System.out.println("Train ID [" + trainId + "] Valid: " + isValidTrainID(trainId));
        System.out.println("Cargo Code [" + cargoCode + "] Valid: " + isValidCargoCode(cargoCode));

        input.close();
    }
}