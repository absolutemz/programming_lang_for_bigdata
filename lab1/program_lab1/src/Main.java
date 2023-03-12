// 3. Создать приложение, выводящее n строк с переходом и без перехода на новую строку.
// 4. Создать приложение для ввода пароля из командной строки и сравнения его со строкой-образцом.
// 9. Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести: Отсортированные числа в порядке возрастания и убывания.
// 10. Числа в порядке убывания частоты встречаемости чисел.

// Калинин Илья ИУ6-23М (по списку 9)

import java.util.*;
public class Main {
    public static void main(String[] args) {
        // ______Приложение, выводящее n строк с переходом и без перехода на новую строку.______
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

        // ______Приложение для ввода пароля из командной строки и сравнения его со строкой-образцом______
        String password = "secret";
        System.out.print("Введите пароль: ");
        String inputPassword = scanner.nextLine();
        if (inputPassword.equals(password)) {
            System.out.println("Пароль верный.");
        }
        else {
            System.out.println("Пароль неверный.");
        }
        // ______Отсортированные числа в порядке возрастания и убывания.______


        // Ввод чисел и размещение их в массиве
        System.out.print("Введите количество чисел: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        System.out.println("Введите " + n + " чисел:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println("Вы ввели следующие числа:");
        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        //Сортировка по возрастанию
        Arrays.sort(numbers);

        System.out.println("Отсортированные числа по возрастанию:");
        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        //Поскольку массив использует простой тип (не получится использовать java.util.Comparator) - развернем
        //отсортированный по возрастанию массив (по О-большому получится выигрыш)
        for (int i = 0; i < n / 2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[n - i - 1];
            numbers[n - i - 1] = temp;
        }
        System.out.println("Отсортированные числа по убыванию:");
        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i] + " ");
        }

        // ______Числа в порядке убывания частоты встречаемости чисел.______
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (frequency.containsKey(numbers[i])) {
                frequency.put(numbers[i], frequency.get(numbers[i]) + 1);
            } else {
                frequency.put(numbers[i], 1);
            }
        }
        System.out.println();
        System.out.println("Отсортированные числа по убыванию частоты вхождения:");
        frequency.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByKey().reversed())
                .forEach(entry -> System.out.print(entry.getKey() + " "));

    }
}