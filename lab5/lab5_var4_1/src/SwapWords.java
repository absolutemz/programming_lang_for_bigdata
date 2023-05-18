import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SwapWords {
    public static void main(String[] args) {
        // Путь к входному файлу
        String inputFilePath = "in.txt";

        // Путь к выходному файлу
        String outputDirectoryPath = System.getProperty("user.dir");
        String outputFilePath = outputDirectoryPath + File.separator + "out.txt";

        // Создание новой директории
        File outputDirectory = new File(outputDirectoryPath);
        outputDirectory.mkdir();

        // Создание нового файла
        File outputFile = new File(outputFilePath);
        try {
            outputFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Чтение строк из входного файла и запись результатов в новый файл
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                if (words.length > 1) {
                    // Меняем местами первое и последнее слово
                    String temp = words[0];
                    words[0] = words[words.length - 1];
                    words[words.length - 1] = temp;
                }

                // Записываем строку в новый файл
                writer.write(String.join(" ", words));
                writer.newLine();
            }

            System.out.println("Результаты записаны в файл: " + outputFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}