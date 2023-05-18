// Калинин Илья ИУ6-23М (по списку 9)
//9.	Определить класс Квадратное уравнение. Класс должен содержать несколько конструкторов.
// Реализовать методы для поиска корней, экстремумов, а также интервалов убывания/возрастания.
// Создать массив объектов и определить наибольшие и наименьшие по значению корни.
//10.	Определить класс Булева матрица (BoolMatrix) размерности (n x m).
// Класс должен содержать несколько конструкторов. Реализовать методы для логического сложения (дизъюнкции),
// умножения и инверсии матриц. Реализовать методы для подсчета числа единиц в матрице и упорядочения строк в
// лексикографическом порядке
public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] findRoots() {
        double discriminant = Math.pow(b, 2) - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return new double[]{root1, root2};
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        } else {
            return new double[]{};
        }
    }

    public double[] findExtremes() {
        double x = -b / (2 * a);
        double y = a * Math.pow(x, 2) + b * x + c;
        return new double[]{x, y};
    }

    public boolean isIncreasing() {
        return a > 0;
    }

    public boolean isDecreasing() {
        return a < 0;
    }

    public static void main(String[] args) {
        QuadraticEquation[] equations = new QuadraticEquation[3];
        equations[0] = new QuadraticEquation(); // Использование конструктора без параметров
        equations[1] = new QuadraticEquation(1, -3, 2);
        equations[2] = new QuadraticEquation(2, 4, -6);

        double smallestRoot = Double.POSITIVE_INFINITY;
        double largestRoot = Double.NEGATIVE_INFINITY;

        for (QuadraticEquation equation : equations) {
            double[] roots = equation.findRoots();
            for (double root : roots) {
                if (root < smallestRoot) {
                    smallestRoot = root;
                }
                if (root > largestRoot) {
                    largestRoot = root;
                }
            }
        }

        System.out.println("Smallest root: " + smallestRoot);
        System.out.println("Largest root: " + largestRoot);
    }
}