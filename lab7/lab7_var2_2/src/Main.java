import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = "В тексте найти первую подстроку максимальной длины, не содержащую букв.";

        Pattern pattern = Pattern.compile("[^\\p{L}]+");
        Matcher matcher = pattern.matcher(text);

        String longestSubstring = "";
        int maxLength = 0;

        while (matcher.find()) {
            String substring = matcher.group();
            int length = substring.length();
            if (length > maxLength) {
                maxLength = length;
                longestSubstring = substring;
            }
        }

        System.out.println("Первая подстрока максимальной длины, не содержащая букв: " + longestSubstring);
    }
}