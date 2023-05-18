import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MatrixRotation {
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

        // Создаем двумерный массив для матрицы
        int[][] matrix = new int[numRows][numRows];

        // Заполняем матрицу из строк файла
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numRows; j++) {
                matrix[i][j] = Integer.parseInt(rows[i].trim());
            }
        }

        // Вывод исходной матрицы
        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        // Поворот матрицы на 90 градусов по часовой стрелке
        int[][] rotatedMatrix = rotateMatrix(matrix);

        // Вывод повернутой матрицы
        System.out.println("Повернутая матрица:");
        printMatrix(rotatedMatrix);
    }

    // Метод для вывода матрицы
    private static void printMatrix(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Метод для поворота матрицы на 90 градусов по часовой стрелке
    private static int[][] rotateMatrix(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        int[][] rotatedMatrix = new int[numCols][numRows];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                rotatedMatrix[j][numRows - 1 - i] = matrix[i][j];
            }
        }
        return rotatedMatrix;
    }
}