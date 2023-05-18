import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class MatrixTranspose {
    public static void main(String[] args) {
        // Путь к входному файлу
        String inputFilePath = "lab5_var3.txt";

        // Чтение содержимого файла
        String input = "";
        try {
            Path path = Paths.get(inputFilePath);
            input = Files.readString(path);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Разделяем строки по символу перевода строки
        String[] rows = input.trim().split("\n");
        int numRows = rows.length;

        // Определяем размер матрицы
        int numCols = 0;
        for (String row : rows) {
            String[] elements = row.trim().split(" ");
            numCols = Math.max(numCols, elements.length);
        }

        // Создаем двумерный массив для матрицы
        String[][] matrix = new String[numRows][numCols];

        // Заполняем матрицу из строк файла
        for (int i = 0; i < numRows; i++) {
            String[] elements = rows[i].trim().split(" ");
            for (int j = 0; j < elements.length; j++) {
                matrix[i][j] = elements[j];
            }
        }

        // Вывод исходной матрицы
        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        // Транспонирование матрицы
        String[][] transposedMatrix = transposeMatrix(matrix);

        // Вывод транспонированной матрицы
        System.out.println("Транспонированная матрица:");
        printMatrix(transposedMatrix);
    }

    // Метод для вывода матрицы
    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    // Метод для транспонирования матрицы
    private static String[][] transposeMatrix(String[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        String[][] transposedMatrix = new String[numCols][numRows];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }
}