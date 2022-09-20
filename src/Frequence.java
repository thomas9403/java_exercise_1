import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.FileNotFoundException;
import java.io.File;

public class Frequence {
    public static void Freq(String path) throws IOException {
        Path path1 = Paths.get(path);
        String text = Files.readString(path1);
        text = text.toLowerCase();
        text = text.replaceAll("\s+", " ").replaceAll("[^a-z0-9 ]", "");
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++)
        {
            System.out.println(words[i]);
        }
    }
    public static void main(String[] args) throws IOException
    {
        Freq("/home/vondracek/Documents/java/java_exercise_1/text.txt");
    }
}