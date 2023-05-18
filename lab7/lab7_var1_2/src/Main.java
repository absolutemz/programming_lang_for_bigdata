public class Main {
    public static void main(String[] args) {
        String text = "Lorem ipsum (dolor sit amet), consectetur adipiscing elit. *Integer euismod* pretium ipsum, nec aliquet mauris pharetra vel.";

        char startChar = '('; // Символ начала
        char endChar = ')'; // Символ конца
        String pattern = "\\" + startChar + "(.*?)" + "\\" + endChar;
        String result = text.replaceAll(pattern, "");

        System.out.println(result);
    }
}