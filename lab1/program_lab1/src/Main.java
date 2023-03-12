// 3. Создать приложение, выводящее n строк с переходом и без перехода на новую строку.
// 4. Создать приложение для ввода пароля из командной строки и сравнения его со строкой-образцом.
// Калинин Илья ИУ6-23М

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Приложение, выводящее n строк с переходом и без перехода на новую строку.
        Scanner scanner = new Scanner (System.in);
        System.out.println("Введите число n, определяющее число выводимых строк");
        int count_of_strings = scanner.nextInt();
        System.out.println("Половина строк без перехода на новую строку:");
        for (int i = 0; i < count_of_strings / 2; ++i) {
            System.out.print("-string uses print-");
        }
        System.out.println();
        System.out.println("Половина строк с переходом на новую строку:");
        for (int i = 0; i < count_of_strings / 2; ++i) {
            System.out.println("-string uses println-");
        }
        scanner.nextLine(); // Пропуск /n после вызова scanner.nextInt();

        // Приложение для ввода пароля из командной строки и сравнения его со строкой-образцом
        String password = "secret";
        System.out.print("Введите пароль: ");
        String inputPassword = scanner.nextLine();
        if (inputPassword.equals(password)) {
            System.out.println("Пароль верный.");
        }
        else {
            System.out.println("Пароль неверный.");
        }
        scanner.close();
    }
}