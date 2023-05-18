import java.util.*;

class MaxRectangle {
    public static void main(String[] args) {
        int[][] matrix =
                        {{0, 0, 1, 1, 1, 5, 6, 0, 8, 9},
                        {0, 0, 1, 1, 1, 5, 6, 8, 8, 9},
                        {0, 1, 1, 1, 3, 5, 6, 8, 8, 9},
                        {0, 1, 1, 1, 1, 5, 6, 8, 8, 9},
                        {1, 1, 1, 1, 3, 5, 6, 8, 8, 9}};
        String rez  = getMaxRectangleArea(matrix);
        System.out.println("Ответ: " + rez);
    }

    private static String getMaxRectangleArea(int[][] matrix) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> numbers = new HashSet<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxArea = 0;
        int numb_ax=0;

        // Заношу в стек все неповторяющиеся цифры
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ( !numbers.contains(matrix[i][j])) stack.push(matrix[i][j]);
            }
        }
// Прохожусь по каждому объекту матрицы
        for (int st=0;st<stack.size();st++) {
            int sta = stack.pop();
            int[] heights = new int[cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] != sta) {
                        heights[j] = 0;
                    } else {
                        heights[j]++;
                    }
                }
                int area = getMaxHistogramArea(heights);
                if (area > maxArea) {
                    maxArea = area;
                    numb_ax=sta;
                }
            }
        }

        return " Максимальная площадь равна " +maxArea +"; из цифры " +numb_ax;
    }

    private static int getMaxHistogramArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;

        while (i < heights.length) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i++);
            } else {
                int topIndex = stack.pop();
                int area = heights[topIndex] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        while (!stack.isEmpty()) {
            int topIndex = stack.pop();
            int area = heights[topIndex] * (stack.isEmpty() ? i : i - stack.peek() - 1);
            if (area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
    }
}