// 9. Используя оператор switch, написать программу, которая выводит на экран сообщения о принадлежности некоторого значения k интервалам (-10k, 0], (0, 5], (5, 10], (10, 10k].
// 10. Используя оператор switch, написать программу, которая выводит на экран сообщения о принадлежности некоторого значения k интервалам (-10k, 5], [0, 10], [5, 15], [10, 10k].
// 9. Построить матрицу, вычитая из элементов каждой строки матрицы ее среднее арифметическое.
// 10. Найти максимальный элемент(ы) в матрице и удалить из матрицы все строки и столбцы, его содержащие

// Калинин Илья ИУ6-23М (по списку 9)

import java.util.*;
public class Main {
    public static void main(String[] args) {
        // _____9. Используя оператор switch, написать программу, которая выводит на экран сообщения о принадлежности некоторого значения k интервалам (-10k, 0], (0, 5], (5, 10], (10, 10k]._____
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение k: ");
        int k = scanner.nextInt();
        switch (k > 0 ? (k > 5 ? (k > 10 ? 3 : 2) : 1) : 0) {
            case 0 -> System.out.println("k принадлежит интервалу (-10k, 0]");
            case 1 -> System.out.println("k принадлежит интервалу (0, 5]");
            case 2 -> System.out.println("k принадлежит интервалу (5, 10]");
            case 3 -> System.out.println("k принадлежит интервалу (10, 10k]");
            default -> System.out.println("Некорректное значение k");
        }

        // _____10. Используя оператор switch, написать программу, которая выводит на экран сообщения о принадлежности некоторого значения k интервалам (-10k, 5], [0, 10], [5, 15], [10, 10k]._____
        int interval;
        if (k > -10*k && k <= 5) {
            interval = 1;
        } else if (k > 5 && k <= 10) {
            interval = 2;
        } else if (k > 10 && k <= 10*k) {
            interval = 3;
        } else if (k >= 0 && k <= 10) {
            interval = 4;
        } else {
            interval = 0;
        }

        switch (interval) {
            case 1:
                System.out.println("Значение " + k + " принадлежит интервалу (-10k, 5]");
                break;
            case 2:
                System.out.println("Значение " + k + " принадлежит интервалу (5, 10]");
                break;
            case 3:
                System.out.println("Значение " + k + " принадлежит интервалу (10, 10k]");
                break;
            case 4:
                System.out.println("Значение " + k + " принадлежит интервалу [0, 10]");
                break;
            default:
                System.out.println("Значение " + k + " не принадлежит ни одному из заданных интервалов");
        }
        // _____9. Построить матрицу, вычитая из элементов каждой строки матрицы ее среднее арифметическое._____

        // Создаем матрицу

        /*
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                System.out.println(mas[i][j]);
            }
        }
        */
        double[][] matrix1 = {
                { 3, 5, 7 },
                { 1, 2, 3 },
                { 0, 0, 1 },
                { 4, 6, 8 }
        };

        // Вычисляем среднее арифметическое каждой строки
        double[] averages = new double[matrix1.length];
        for (int i = 0; i < matrix1.length; i++) {
            double sum = 0;
            for (int j = 0; j < matrix1[i].length; j++) {
                sum += matrix1[i][j];
            }
            averages[i] = sum / matrix1[i].length;
        }

        // Вычитаем из каждого элемента каждой строки среднее арифметическое этой строки
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix1[i][j] -= averages[i];
            }
        }

        // Выводим полученную матрицу
        for (double[] row : matrix1) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println();
        // _____10. Найти максимальный элемент(ы) в матрице и удалить из матрицы все строки и столбцы, его содержащие_____
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        // Находим максимальный элемент в матрице
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }

        // Удаляем строки и столбцы, содержащие максимальный элемент
        boolean[] rowToDelete = new boolean[matrix.length];
        boolean[] columnToDelete = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == max) {
                    rowToDelete[i] = true;
                    columnToDelete[j] = true;
                }
            }
        }

        int[][] newMatrix = new int[matrix.length - count(rowToDelete)][matrix[0].length - count(columnToDelete)];
        int row = 0;
        int column;
        for (int i = 0; i < matrix.length; i++) {
            if (!rowToDelete[i]) {
                column = 0;
                for (int j = 0; j < matrix[i].length; j++) {
                    if (!columnToDelete[j]) {
                        newMatrix[row][column] = matrix[i][j];
                        column++;
                    }
                }
                row++;
            }
        }

        // Выводим новую матрицу на экран
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }

        // Вывод даты и имени
        Date date = new Date();

        System.out.println("Калинин И.Г. Дата получения задач: 17Фев2023, Дата сдачи:" + date);
    }
    public static int count(boolean[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]) {
                count++;
            }
        } 
        return count;
    }
}