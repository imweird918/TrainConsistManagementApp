public class TrainConsistManagementApp {

    public static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    public static class GoodsBogie {
        String shape;
        String cargo;

        public GoodsBogie(String shape) {
            this.shape = shape;
        }

        public void assignCargo(String cargo) {
            try {
                if ("Rectangular".equalsIgnoreCase(this.shape) && "Petroleum".equalsIgnoreCase(cargo)) {
                    throw new CargoSafetyException("Error: Unsafe cargo assignment!");
                }
                this.cargo = cargo;
                System.out.println("Cargo assigned successfully -> " + cargo);
            } catch (CargoSafetyException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("Cargo validation completed for " + this.shape + " bogie");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println(" UC15 - Safe Cargo Assignment ");
        System.out.println("==========================================================\n");

        GoodsBogie cylindrical = new GoodsBogie("Cylindrical");
        cylindrical.assignCargo("Petroleum");

        System.out.println();

        GoodsBogie rectangular = new GoodsBogie("Rectangular");
        rectangular.assignCargo("Petroleum");

        System.out.println("\nUC15 runtime handling completed...");
    }
}