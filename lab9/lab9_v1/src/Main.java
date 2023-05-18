import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("foo", "bar", "baz", "foo", "qux");

        String target = "foo";

        long count = strings.stream()
                .filter(s -> s.equals(target))
                .count();

        System.out.println("Количество вхождений строки \"" + target + "\": " + count);


        Collection<Student> students = Arrays.asList(
                new Student("Ivan", 40),
                new Student("Petr", 60),
                new Student("Olga", 70)
        );

        List<Student> filteredStudents = students.stream()
                .filter(student -> student.getName().startsWith("P"))
                .filter(student -> student.getRating() >= 40 && student.getRating() <= 60)
                .collect(Collectors.toList());

        System.out.println("Список студентов с именем, начинающимся на P и рейтингом в интервале 40-60:");
        for (Student student : filteredStudents) {
            System.out.println(student.getName() + ", рейтинг: " + student.getRating());
        }
    }
    static class Student {
        private String name;
        private int rating;

        public Student(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }

        public String getName() {
            return name;
        }

        public int getRating() {
            return rating;
        }
    }

}