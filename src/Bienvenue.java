import java.util.Scanner;

public class Bienvenue {
    public static void main(String[] args) {
        System.out.println("Bienvenue");

        var scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("quit")) {
            System.out.println("Unknown command");
            input = scanner.nextLine();
        }
    }
}