import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static void main(String[] args) {
        // Создание двух множеств
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        // Вызов методов для определения пересечения и объединения множеств
        Set<Integer> intersection = getIntersection(set1, set2);
        Set<Integer> union = getUnion(set1, set2);

        // Вывод результатов
        System.out.println("Intersection: " + intersection);
        System.out.println("Union: " + union);
    }

    // Метод для определения пересечения двух множеств
    public static Set<Integer> getIntersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }

    // Метод для определения объединения двух множеств
    public static Set<Integer> getUnion(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        return union;
    }
}