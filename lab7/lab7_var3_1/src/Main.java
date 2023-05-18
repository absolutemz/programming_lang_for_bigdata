import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        String text = "Напечатать слова русского текста в алфавитном порядке по первой букве. Слова, начинающиеся с новой буквы, печатать с красной строки.";

        String[] words = text.split("\\s+"); // Разделение текста на слова

        Set<Character> firstLetters = new TreeSet<>(); // Уникальные первые буквы
        Set<String> uniqueWords = new TreeSet<>(); // Уникальные слова

        // Заполняем множества уникальными первыми буквами и словами
        for (String word : words) {
            if (!word.isEmpty()) {
                char firstLetter = Character.toLowerCase(word.charAt(0));
                firstLetters.add(firstLetter);
                uniqueWords.add(word);
            }
        }

        // Печатаем слова в алфавитном порядке
        for (char letter : firstLetters) {
            boolean newLinePrinted = false; // Флаг для печати красной строки

            for (String word : uniqueWords) {
                if (Character.toLowerCase(word.charAt(0)) == letter) {
                    if (!newLinePrinted) {
                        System.out.println();
                        newLinePrinted = true;
                    }
                    System.out.print(word + " ");
                }
            }
        }
    }
}