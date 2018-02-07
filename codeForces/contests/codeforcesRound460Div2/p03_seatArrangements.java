package codeForces.contests.codeforcesRound460Div2;

import java.util.Scanner;

public class p03_seatArrangements {

    private static final char EMPTY_CELL = '.';

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        char[][] matrix = fillMatrix(in, n, m);

        int totalCombinations = 0;
        totalCombinations += getTotalCombinations(matrix, k, n, m, true);

        if (k > 1)
            totalCombinations += getTotalCombinations(matrix, k, n, m, false);

        System.out.println(totalCombinations);
    }

    private static int getTotalCombinations(char[][] matrix, int k, int row, int col, boolean flag) {
        int combinations = 0;

        for (int i = 0; i < (flag ? row : col); i++) {
            for (int j = 0; j < (flag ? col : row); j++) {

                int count = 0;
                if (flag) {
                    while (j < matrix[i].length && matrix[i][j] == EMPTY_CELL) {
                        count++;
                        j++;
                    }
                } else {
                    while (j < matrix.length && matrix[j][i] == EMPTY_CELL) {
                        count++;
                        j++;
                    }
                }

                if (count >= k)
                    combinations += count - k + 1;
            }
        }

        return combinations;
    }

        private static char[][] fillMatrix (Scanner in,int n, int m){
            char[][] matrix = new char[n][m];
            for (int row = 0; row < n; row++) {
                String line = in.next();
                for (int col = 0; col < line.length(); col++) {
                    matrix[row][col] = line.charAt(col);
                }
            }

            return matrix;
        }
    }
