import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExcludeSubstring {
    public static void main(String[] args) {
        String text = "TEST TEEEEEEEEEEEST TEEEEEEEEEEEEEEEEEEEEEEEEST TEST TEEEEEEEES PEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEp";

        String excludedSubstring = findExcludedSubstring(text);

        String transformedText = text.replace(excludedSubstring, "");

        System.out.println("Исходный текст: " + text);
        System.out.println("Преобразованный текст: " + transformedText);
    }

    private static String findExcludedSubstring(String text) {
        Pattern pattern = Pattern.compile("(\\w)(.*)(\\1)");
        Matcher matcher = pattern.matcher(text);

        String excludedSubstring = "";
        int maxSubstringLength = 0;

        while (matcher.find()) {
            String substring = matcher.group(2);
            int substringLength = substring.length();

            if (substringLength > maxSubstringLength) {
                excludedSubstring = matcher.group();
                maxSubstringLength = substringLength;
            }
        }

        return excludedSubstring;
    }
}