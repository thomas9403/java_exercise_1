import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Launcher  {
    public static void main(String[] args) throws IOException {
        
        System.out.println("Bienvenue !");
        var scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Command> commands = new ArrayList<Command>();
        commands.add(new Freq());
        commands.add(new Fibo());
        commands.add(new Quit());
        while (!"quit".equalsIgnoreCase(input)) {
            Boolean found = false;
            for (Command command : commands) {
                if (command.name().equalsIgnoreCase(input)) {
                    found = true;
                    command.run(scanner);
                    break;
                }
            }
            if (!found) {
                System.out.println("Unknown command");
            }
            input = scanner.nextLine();
        }
    }
    public static int fibo(int nb) {
        if(nb <= 1) {
            return nb;
        }
        return fibo(nb-1) + fibo(nb-2);
    }

    public static void freq(String path) throws IOException {
        Path filePath = Paths.get(path);
        String content = Files.readString(filePath);
        if(content.isEmpty()) {
            System.out.println("Empty file");
        }
        content = content.toLowerCase();
        Stream<String> stream = Arrays.stream(content.replaceAll("[^a-zA-Z]", " ").split(" ")).filter(word -> !word.isEmpty());
        Map<String,Long> result = stream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        result.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(3).forEach(entry -> System.out.print(entry.getKey() + " "));
        System.out.print("\n");
    }
}

interface Command 
{
    String name();
    Boolean run(Scanner scanner);
}
class Quit implements Command 
{
    public String name() 
    {
        return "quit";
    }
    public Boolean run(Scanner scanner) 
    {
        return true;
    }
}
class Fibo implements Command 
{
    public String name() 
    {
        return "fibo";
    }
    public Boolean run(Scanner scanner) 
    {
        System.out.println("Entrez un nombre n :");
        // get the input from the user and convert it to an integer using Integer.parseInt() method
        int nb = Integer.parseInt(scanner.nextLine());
        if (nb < 0) 
        {
            System.out.println("Le nombre doit être positif");
        } 
        else 
        {
            System.out.println("f("+nb+") = " + Launcher.fibo(nb));
        }
        return false;
    }
}

class Freq implements Command 
{
    public String name() 
    {
        return "freq";
    }
    public Boolean run(Scanner scanner) 
    {
        System.out.println("Entrez le chemin du fichier :");
        String path = scanner.nextLine();
        try 
        {
            Launcher.freq(path);
        } 
        catch (IOException e) 
        {
            System.out.println("Unreadable file :" + e.getClass().getSimpleName() + e.getMessage());
        }
        return false;
    }
}