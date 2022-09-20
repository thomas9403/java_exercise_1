import java.util.Scanner;

public class Bienvenue {
    public static void main(String[] args) {
        System.out.println("Bienvenue");

        var scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println("Vous avez saisi: " + input);
    }
}