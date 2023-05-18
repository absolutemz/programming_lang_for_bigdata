import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordTransformation {
    public static void main(String[] args) {
        String text = "simple test ttttthhhhhhhhhhh afffffffb aaffffffffaFfffb";

        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(text);

        StringBuilder transformedText = new StringBuilder();
        while (matcher.find()) {
            String word = matcher.group();
            String transformedWord = transformWord(word);
            transformedText.append(transformedWord).append(" ");
        }

        System.out.println("Исходный текст: " + text);
        System.out.println("Преобразованный текст: " + transformedText.toString().trim());
    }

    private static String transformWord(String word) {
        char firstChar = word.charAt(0);
        char lastChar = word.charAt(word.length() - 1);
        String innerChars = word.substring(1, word.length() - 1);

        // Удаляем символы, равные первой и последней букве, оставляя первую и последнюю букву нетронутыми
        String transformedWord = innerChars.replaceAll(String.valueOf(firstChar), "")
                .replaceAll(String.valueOf(lastChar), "");

        return firstChar + transformedWord + lastChar;
    }
}