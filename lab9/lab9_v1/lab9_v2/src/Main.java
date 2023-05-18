import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 7, 3);

        Optional<Integer> max = numbers.stream()
                .reduce(Integer::max);

        Optional<Integer> min = numbers.stream()
                .reduce(Integer::min);

        max.ifPresent(value -> System.out.println("Максимум: " + value));
        min.ifPresent(value -> System.out.println("Минимум: " + value));

        List<Integer> numbers2 = Arrays.asList(5, 10, 15, 20, 25);

        int sum = numbers2.stream()
                .filter(number -> number > 10)
                .reduce(0, Integer::sum);

        System.out.println("Сумма чисел, которые больше 10: " + sum);
    }
}