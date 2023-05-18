import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LastWordsSelection {
    public static void main(String[] args) {
        // Путь к входному файлу
        String inputFilePath = "in.txt";

        // Количество последних строк, из которых нужно выбрать последние слова
        int n = 3;

        // Количество последних слов, которые нужно сохранить
        int m = 2;

        // Список для хранения последних слов
        List<String> lastWords = new ArrayList<>();

        // Чтение строк из входного файла
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            List<String> lastNLines = new ArrayList<>();

            // Чтение последних n строк
            while ((line = reader.readLine()) != null) {
                lastNLines.add(line);
                if (lastNLines.size() > n) {
                    lastNLines.remove(0);
                }
            }

            // Выбор последних m слов из каждой строки
            for (String lastLine : lastNLines) {
                String[] words = lastLine.split("\\s+");
                int startIndex = Math.max(0, words.length - m);
                for (int i = startIndex; i < words.length; i++) {
                    lastWords.add(words[i]);
                }
            }

            // Сохранение последних слов в файл
            saveLastWordsToFile(lastWords);

            System.out.println("Последние " + m + " слова из последних " + n + " строк сохранены в файл.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для сохранения последних слов в файл
    private static void saveLastWordsToFile(List<String> lastWords) {
        String outputFilePath = "out.txt";

        try (FileWriter writer = new FileWriter(outputFilePath)) {
            for (String word : lastWords) {
                writer.write(word);
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}