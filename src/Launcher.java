import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Map;

import java.util.TreeMap;

public class Launcher
{
    public static void main(String[] args) throws IOException
    {
        hello();

        System.out.println("Bienvenue");

        var scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("quit"))
        {
            if ("fibo".equalsIgnoreCase((input)))
            {
                System.out.println("Entrer un nombre:");
                int n = scanner.nextInt();
                System.out.println("F(" + n + ") = " + Fibonacci.fibo(n));
                input = scanner.nextLine();
            }
            else if ("freq".equalsIgnoreCase(input))
            {
                System.out.println("Entrer un chemin:");
                String path = scanner.nextLine();
                try
                {
                    freq(path);
                }
                catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
                input = scanner.nextLine();
            }
            else
            {
                System.out.println("Unknown command");
            }
            input = scanner.nextLine();
        }
        scanner.close();
    }


    public static int fibo ( int n)
    {
        if (n <= 1)
        {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }


    public static void freq (String path) throws java.io.IOException
    {
        /*Path path1 = Paths.get(path);
        String text = Files.readString(path1);
        text = text.toLowerCase();
        text = text.replaceAll("\s+", " ").replaceAll("[^a-z0-9 ]", "");
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++)
        {
            System.out.println(words[i]);
        }*/
        //compter les occurences de chaque mot et les trier par ordre décroissant en utilisant split et sort
        Map<String, Integer> map = new TreeMap<>();

        FileInputStream fis = new FileInputStream(path);
        Scanner sc = new Scanner(fis);

        while (sc.hasNextLine()) {
            String[] words = sc.nextLine().replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
            for (String word : words) {
                if (!map.containsKey(word)) {
                    map.put(word, 1);
                } else {
                    map.put(word, map.get(word) + 1);
                }
            }
        }
        //map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(3).forEach(System.out::println);
        //afficher les mots sur la même ligne
        map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(3).forEach(e -> System.out.print(e.getKey() + " "));
        sc.close();
    }

    public static void hello()
    {
        System.out.println("Hello World !");
    }
}