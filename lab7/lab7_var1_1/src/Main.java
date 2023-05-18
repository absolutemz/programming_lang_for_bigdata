import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet, consnte iuris, ut bibendum dui lectus non nisi. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae;";

        int wordLength = 5; // Длина слова, которое нужно удалить
        String pattern = "\\b[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]\\w{" + (wordLength - 1) + "}\\b";
        String result = text.replaceAll(pattern, "");

        System.out.println(result);
    }
}