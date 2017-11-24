package hackerRank.contests.contest_weekOfCode35;

import java.util.Scanner;

/**
 * Created by vladix on 11/24/17.
 */
public class p02_tripleRecursion {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int matrix_size = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        int[][] matrix = new int[matrix_size][matrix_size];

        logic(matrix_size, matrix, m, k);

        print_matrix(matrix);
    }

    private static void logic(int matrix_size, int[][] matrix, int m, int k) {
        for (int row = 0; row < matrix_size; row++) {
            for (int col = 0; col < matrix_size; col++) {

                fill_by_rules(row, col, matrix, m, k);
            }
        }
    }

    private static void print_matrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }

    private static void fill_by_rules(int row, int col, int[][] matrix, int m, int k) {
        if (row == 0 && col == 0) {
            matrix[row][col] = m;
        } else if (row == col) {
            matrix[row][col] = matrix[row - 1][col - 1] + k;
        } else if (row > col) {
            matrix[row][col] = matrix[row - 1][col] - 1;
        } else if (row < col) {
            matrix[row][col] = matrix[row][col - 1] - 1;
        }
    }
}
