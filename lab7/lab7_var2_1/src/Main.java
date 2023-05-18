import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String poem = "bb bbbbb ggb ggyyyb";

        // Паттерн для поиска слов
        Pattern wordPattern = Pattern.compile("\\b\\w+\\b");
        Matcher wordMatcher = wordPattern.matcher(poem);

        Set<Character> commonLetters = null;

        // Находим буквы, которые встречаются в каждом слове
        while (wordMatcher.find()) {
            String word = wordMatcher.group();
            Set<Character> letters = new HashSet<>();

            // Паттерн для поиска букв в слове
            Pattern letterPattern = Pattern.compile("\\p{L}");
            Matcher letterMatcher = letterPattern.matcher(word);

            // Находим все буквы в слове
            while (letterMatcher.find()) {
                char letter = letterMatcher.group().charAt(0);
                letters.add(letter);
            }

            if (commonLetters == null) {
                commonLetters = new HashSet<>(letters);
            } else {
                commonLetters.retainAll(letters);
            }
        }

        System.out.println("Буквы, встречающиеся в каждом слове:");
        if (commonLetters != null && !commonLetters.isEmpty()) {
            for (char letter : commonLetters) {
                System.out.print(letter + " ");
            }
        } else {
            System.out.println("Все слова имеют разные буквы.");
        }
    }
}