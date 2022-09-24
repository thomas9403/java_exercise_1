import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.FileNotFoundException;
import java.io.File;

public class Frequence {
    public static void freq(String path) throws IOException {
        Path path1 = Paths.get(path);
        String text = Files.readString(path1);
        text = text.toLowerCase();
        text = text.replaceAll("\s+", " ").replaceAll("[^a-z0-9 ]", "");
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++)
        {
            System.out.println(words[i]);
        }
        int max = 0;
        String maxWord = "";
        for (int i = 0; i < words.length; i++)
        {
            int count = 0;
            for (int j = 0; j < words.length; j++)
            {
                if (words[i].equals(words[j]))
                {
                    count++;
                }
            }
            if (count > max)
            {
                max = count;
                maxWord = words[i];
            }
        }
        System.out.println("Le mot le plus fréquent est " + maxWord + " avec " + max + " occurences");
    }
}