import java.util.LinkedList;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC4 - Maintain Ordered Bogie Consist ");
        System.out.println("==========================================\n");

        LinkedList<String> trainFormation = new LinkedList<>();

        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("AC");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(trainFormation + "\n");

        trainFormation.add(2, "Pantry Car");

        System.out.println("After Inserting 'Pantry Car' at position 2:");
        System.out.println(trainFormation + "\n");

        trainFormation.removeFirst();
        trainFormation.removeLast();

        System.out.println("After Removing First and Last Bogie:");
        System.out.println(trainFormation + "\n");

        System.out.println("UC4 ordered consist operations completed...");
    }
}