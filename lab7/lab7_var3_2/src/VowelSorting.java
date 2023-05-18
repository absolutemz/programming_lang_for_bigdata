import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VowelSorting {
    public static void main(String[] args) {
        String text = "Рассортировать слова русского текста по возрастанию доли гласных букв аааа";
        String[] words = text.split("\\s+"); // Разделение текста на слова по пробелам

        List<String> sortedWords = new ArrayList<>();
        for (String word : words) {
            // Удаление знаков препинания
            String cleanedWord = word.replaceAll("[^а-яА-ЯёЁ]", "");
            double vowelRatio = calculateVowelRatio(cleanedWord);
            sortedWords.add(cleanedWord + ":" + vowelRatio);
        }

        // Сортировка слов по доли гласных букв
        Collections.sort(sortedWords, Comparator.comparingDouble(VowelSorting::extractVowelRatio));

        for (String word : sortedWords) {
            System.out.println(word);
        }
    }

    private static double calculateVowelRatio(String word) {
        int totalLetters = word.length();
        int vowelCount = word.replaceAll("[^аеёиоуыэюяАЕЁИОУЫЭЮЯ]", "").length();
        return (double) vowelCount / totalLetters;
    }

    private static double extractVowelRatio(String word) {
        String[] parts = word.split(":");
        return Double.parseDouble(parts[1]);
    }
}