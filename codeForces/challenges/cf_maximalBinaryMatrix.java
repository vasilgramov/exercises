package codeForces.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 5/7/17.
 */
public class cf_maximalBinaryMatrix {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int matrixSize = in.nextInt();
        int toUse = in.nextInt();

        if (matrixSize * matrixSize < toUse) {
            System.out.println(-1);
            return;
        }

        boolean[][] matrix = new boolean[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            if (toUse <= 0) break;

            if (toUse >= i + 1) {
                int count = 0;
                for (int j = 0; j < i + 1; j++) {
                    matrix[i - count][j] = true;
                    count++;
                    toUse--;
                }

                if (!matrix[i][i]) {
                    matrix[i][i] = true;
                    toUse--;
                }

                printMatrix(matrixSize, matrix);
            } else {
                matrix[i][i] = true;
                toUse--;

                int count = 0;
                while (toUse >= 2) {
                    matrix[count][i - count] = true;
                    matrix[i - count][count] = true;

                    toUse -= 2;
                }

                break;
            }
        }

        printMatrix(matrixSize, matrix);
    }

    private static void printMatrix(int matrixSize, boolean[][] matrix) {
        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                if (matrix[row][col]) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }

            System.out.println();
        }
    }
}