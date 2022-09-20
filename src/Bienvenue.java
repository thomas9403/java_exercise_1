import java.util.Scanner;

public class Bienvenue {
    public static void main(String[] args) {
        System.out.println("Bienvenue");

        var scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("quit")) {
            if("fibo".equalsIgnoreCase((input))){
                System.out.println("Entrer un nombre:");
                int n = scanner.nextInt();
                System.out.println("F(" + n + ") = " + Fibonacci.fibo(n));
                input = scanner.nextLine();
            }
            else {
                System.out.println("Unknown command");
            }
            input = scanner.nextLine();
        }
        scanner.close();
    }
}