package hackerRank.challenges;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/count-luck?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
public class hr_countLuck {

    private static final char VISITED_CELL = 'X';
    private static boolean hasReachedThePortal = false;

    private static StringBuilder path = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int numberOfTests = Integer.parseInt(in.nextLine());
        for (int i = 0; i < numberOfTests; i++) {
            int[] matrixArgs = stringsToIntegers(in.nextLine().split(" "));
            int rows = matrixArgs[0];
            int cols = matrixArgs[1];

            char[][] matrix = new char[rows][cols];
            char[][] copyMatrix = new char[rows][cols];

            int startRow = 0;
            int startCol = 0;

            for (int row = 0; row < rows; row++) {
                char[] currentRow = in.nextLine().toCharArray();
                for (int col = 0; col < cols; col++) {
                    if (currentRow[col] == 'M') {
                        startRow = row;
                        startCol = col;
                    }

                    matrix[row][col] = currentRow[col];
                    copyMatrix[row][col] = currentRow[col];
                }
            }

            int prediction = Integer.parseInt(in.nextLine());

            path = new StringBuilder();
            hasReachedThePortal = false;
            dfs(matrix, startRow, startCol, 'S');

            int neededWaves = 0;

            for (int j = 0; j < path.length() - 1; j++) {
                char direction = path.charAt(j);
                switch (direction) {
                    case 'U':
                        startRow--;
                        break;
                    case 'R':
                        startCol++;
                        break;
                    case 'D':
                        startRow++;
                        break;
                    case 'L':
                        startCol--;
                        break;
                }

                if (shouldWave(copyMatrix, startRow, startCol)) {
                    neededWaves++;
                }

                copyMatrix[startRow][startCol] = VISITED_CELL;
            }

            if (neededWaves == prediction) {
                System.out.println("Impressed");
            } else {
                System.out.println("Oops!");
            }

        }
    }
    
    private static void dfs(char[][] matrix, int currentRow, int currentCol, char direction) {
        if (hasReachedThePortal) {
            return;
        }

        if (!isInMatrix(currentRow, currentCol, matrix) ||
                matrix[currentRow][currentCol] == 'X' ||
                matrix[currentRow][currentCol] == VISITED_CELL) {
            return;
        }

        path = path.append(direction);
        if (matrix[currentRow][currentCol] == '*') {
            hasReachedThePortal = true;
            return;
        }

        matrix[currentRow][currentCol] = VISITED_CELL;

        dfs(matrix, currentRow -1, currentCol, 'U');     // up
        dfs(matrix, currentRow, currentCol + 1, 'R');     // right
        dfs(matrix, currentRow + 1, currentCol, 'D');    // down
        dfs(matrix, currentRow, currentCol - 1, 'L');     // left

        if (!hasReachedThePortal) {
            path = path.deleteCharAt(path.length() - 1);
        }
    }

    private static boolean shouldWave(char[][] matrix, int currentRow, int currentCol) {
        if (isInMatrix(currentRow - 1, currentCol, matrix) &&
                matrix[currentRow - 1][currentCol] != 'X' &&
                isInMatrix(currentRow, currentCol + 1, matrix) &&
                matrix[currentRow][currentCol + 1] != 'X') {
            return true;
        }

        if (isInMatrix(currentRow, currentCol + 1, matrix) &&
                matrix[currentRow][currentCol + 1] != 'X' &&
                isInMatrix(currentRow + 1, currentCol, matrix) &&
                matrix[currentRow + 1][currentCol] != 'X') {
            return true;
        }

        if (isInMatrix(currentRow + 1, currentCol, matrix) &&
                matrix[currentRow + 1][currentCol] != 'X' &&
                isInMatrix(currentRow, currentCol - 1, matrix) &&
                matrix[currentRow][currentCol - 1] != 'X') {
            return true;
        }

        if (isInMatrix(currentRow, currentCol - 1, matrix) &&
                matrix[currentRow][currentCol - 1] != 'X' &&
                isInMatrix(currentRow - 1, currentCol, matrix) &&
                matrix[currentRow - 1][currentCol] != 'X') {
            return true;
        }

        if (isInMatrix(currentRow - 1, currentCol, matrix) &&
                matrix[currentRow - 1][currentCol] != 'X' &&
                isInMatrix(currentRow + 1, currentCol, matrix) &&
                matrix[currentRow + 1][currentCol] != 'X') {
            return true;
        }

        if (isInMatrix(currentRow, currentCol + 1, matrix) &&
                matrix[currentRow][currentCol + 1] != 'X' &&
                isInMatrix(currentRow, currentCol - 1, matrix) &&
                matrix[currentRow][currentCol - 1] != 'X') {
            return true;
        }

        return false;
    }

    private static boolean isInMatrix(int row, int col, char[][] matrix) {
        if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length) {
            return true;
        }

        return false;
    }

    private static int[] stringsToIntegers(String[] numbersAsString) {
        int[] parsedNumbers = new int[numbersAsString.length];

        for (int i = 0; i < numbersAsString.length; i++) {
            parsedNumbers[i] = Integer.parseInt(numbersAsString[i]);
        }


        return parsedNumbers;
    }
}
