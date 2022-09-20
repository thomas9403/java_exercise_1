import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.FileNotFoundException;
import java.io.File;

public class Frequence {
    public static void Freq(String path) throws FileNotFoundException {
        //System.out.println("Renseignez un chemin:");
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        String text = scanner.nextLine();
        while (scanner.hasNextLine()) {
            text += scanner.nextLine();
        }
        text = text.toLowerCase();
        text.replaceAll("[a-z]", "");
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++)
        {
            System.out.println(words[i]);
        }
        scanner.close();
    }
    public static void main(String[] args) throws FileNotFoundException
    {
        Freq("/home/vondracek/Documents/java/java_exercise_1/text.txt");
    }
}