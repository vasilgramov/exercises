package hackerRank.challenges;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/connected-cell-in-a-grid?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
public class hr_connectedCellsInMatrix {

    static int rows;
    static int cols;
    static int[][] matrix;

    static int count = 0;
    static int bestCount = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        rows = Integer.parseInt(in.nextLine());
        cols = Integer.parseInt(in.nextLine());

        matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] currentRow = in.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(currentRow[j]);
            }
        }


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    searchForBiggestRegion(matrix, i, j);

                    if (count > bestCount) {
                        bestCount = count;
                    }

                    count = 0;
                }
            }
        }

        System.out.println(bestCount);
    }

    private static void searchForBiggestRegion(int[][] matrix, int currentRow, int currentCol) {
        if (!isInMatrix(currentRow, currentCol) ||
                matrix[currentRow][currentCol] == -1 ||
                matrix[currentRow][currentCol] == 0) {
            return;
        }

        if (matrix[currentRow][currentCol] == 1) {
            matrix[currentRow][currentCol] = -1;
            count++;
        }

        searchForBiggestRegion(matrix, currentRow - 1, currentCol - 1);   // up-left
        searchForBiggestRegion(matrix, currentRow - 1, currentCol);                 // up
        searchForBiggestRegion(matrix, currentRow - 1, currentCol + 1);   // up-right
        searchForBiggestRegion(matrix, currentRow, currentCol - 1);                  // left
        searchForBiggestRegion(matrix, currentRow, currentCol + 1);                  // right
        searchForBiggestRegion(matrix, currentRow + 1, currentCol - 1);     // down-left
        searchForBiggestRegion(matrix, currentRow + 1, currentCol); // down
        searchForBiggestRegion(matrix, currentRow + 1, currentCol + 1); // down-right
    }

    private static void checkForGreaterCount(int currentCount) {
        if (currentCount > count) {
            count = currentCount;
        }
    }

    private static boolean isInMatrix(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols)
            return true;

        return false;
    }
}
