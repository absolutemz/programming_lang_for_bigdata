import java.util.Arrays;

public class BoolMatrix {
    private boolean[][] matrix;
    private int rows;
    private int columns;

    public BoolMatrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new boolean[rows][columns];
    }

    public BoolMatrix(boolean[][] matrix) {
        this.rows = matrix.length;
        this.columns = matrix[0].length;
        this.matrix = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            this.matrix[i] = Arrays.copyOf(matrix[i], columns);
        }
    }

    public boolean[][] getMatrix() {
        return matrix;
    }

    public BoolMatrix logicalOr(BoolMatrix other) {
        if (rows != other.rows || columns != other.columns) {
            throw new IllegalArgumentException("Матрицы должны иметь одинаковые размеры.");
        }

        BoolMatrix result = new BoolMatrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.matrix[i][j] = matrix[i][j] || other.matrix[i][j];
            }
        }
        return result;
    }

    public BoolMatrix logicalAnd(BoolMatrix other) {
        if (rows != other.rows || columns != other.columns) {
            throw new IllegalArgumentException("Матрицы должны иметь одинаковые размеры.");
        }

        BoolMatrix result = new BoolMatrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.matrix[i][j] = matrix[i][j] && other.matrix[i][j];
            }
        }
        return result;
    }

    public BoolMatrix logicalNot() {
        BoolMatrix result = new BoolMatrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.matrix[i][j] = !matrix[i][j];
            }
        }
        return result;
    }

    public int countOnes() {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public void sortRowsLexicographically() {
        Arrays.sort(matrix, (row1, row2) -> {
            for (int i = 0; i < columns; i++) {
                if (row1[i] != row2[i]) {
                    return row1[i] ? 1 : -1;
                }
            }
            return 0;
        });
    }

    public static void main(String[] args) {
        boolean[][] data = {
                {true, false, true},
                {false, true, false},
                {true, true, false}
        };

        BoolMatrix matrix1 = new BoolMatrix(data);
        BoolMatrix matrix2 = new BoolMatrix(3, 3);

        System.out.println("Матрица 1:");
        printMatrix(matrix1.getMatrix());
        System.out.println();

        System.out.println("Матрица 2:");
        printMatrix(matrix2.getMatrix());
        System.out.println();

        BoolMatrix matrix3 = matrix1.logicalOr(matrix2);
        System.out.println("Матрица 3 (логическое ИЛИ):");
        printMatrix(matrix3.getMatrix());
        System.out.println();

        BoolMatrix matrix4 = matrix1.logicalAnd(matrix2);
        System.out.println("Матрица 4 (логическое И):");
        printMatrix(matrix4.getMatrix());
        System.out.println();

        BoolMatrix matrix5 = matrix1.logicalNot();
        System.out.println("Матрица 5 (логическое НЕ):");
        printMatrix(matrix5.getMatrix());
        System.out.println();

        int onesCount = matrix1.countOnes();
        System.out.println("Количество единиц в Матрице 1: " + onesCount);
        System.out.println();

        System.out.println("Матрица 1 до сортировки строк:");
        printMatrix(matrix1.getMatrix());
        System.out.println();

        matrix1.sortRowsLexicographically();
        System.out.println("Матрица 1 после сортировки строк в лексикографическом порядке:");
        printMatrix(matrix1.getMatrix());
    }

    private static void printMatrix(boolean[][] matrix) {
        for (boolean[] row : matrix) {
            for (boolean element : row) {
                System.out.print(element ? "1 " : "0 ");
            }
            System.out.println();
        }
    }
}