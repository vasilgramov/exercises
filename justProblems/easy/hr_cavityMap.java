package hackerRank.justProblems.easy;// https://www.hackerrank.com/challenges/cavity-map

import java.util.Scanner;

public class hr_cavityMap {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            char[] line = in.nextLine().toCharArray();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = line[j];
            }
        }


        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (matrix[i][j] > matrix[i + 1][j] &&
                    matrix[i][j] > matrix[i - 1][j] &&
                    matrix[i][j] > matrix[i][j + 1] &&
                    matrix[i][j] > matrix[i][j - 1])  {
                    matrix[i][j] = 'X';
                }
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "");
            }
            System.out.println();
        }
    }
}
