import java.util.Scanner;

public class Bienvenue {
    public static void main(String[] args) {
        System.out.println("Bienvenue");

        var scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        if (!"quit".equals(input)) {
            System.out.println("Unknown command");
        }
    }
}