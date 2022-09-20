public class HelloWorldLauncher { // (1)
    public static void main(String[] args) { // (2)
        System.out.println("Hello " + (args.length > 0 ? args[0] : "World")); // (3)
    }
}