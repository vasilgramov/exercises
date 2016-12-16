package hackerRank.challenges.medium;

import java.util.ArrayList;
import java.util.Scanner;

public class hr_encryption {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input00 = in.nextLine();
        int rows = (int)Math.floor(Math.sqrt(input00.length()));
        int cols = (int)Math.ceil(Math.sqrt(input00.length()));

        if (rows * cols < input00.length()) {
            rows++;
        }

        String[] data = input00.split("\\s+");

        String input = String.join("", data);

        //System.out.println(input.length());

        char[][] matrix = new char[rows][cols];
        buildMatrix(input, rows, cols, matrix);

        //printMatrix(matrix, rows, cols);
        
        encryptedMessages(matrix, rows, cols);
    }
    
    private static void encryptedMessages(char[][] matrix, int rows, int cols) {
        ArrayList<String> words = new ArrayList<>();

        for (int col = 0; col < cols; col++) {
            StringBuilder currentWord = new StringBuilder();
            for (int row = 0; row < rows; row++) {
                if (matrix[row][col] == '\u0000') {
                    continue;
                }

                currentWord.append(matrix[row][col]);
            }

            words.add(currentWord.toString());
        }

        String output101 = String.join(" ", words).trim();
        System.out.println(output101);
    }

    private static void printMatrix(char[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }

    private static void buildMatrix(String input, int rows, int cols, char[][] matrix) {
        int index = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (index < input.length()) {
                    matrix[row][col] = input.charAt(index);
                    index++;
                }
            }
        }
    }
}
