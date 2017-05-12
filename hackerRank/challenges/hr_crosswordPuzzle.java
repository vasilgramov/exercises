package hackerRank.challenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by vladix on 5/5/17.
 */
public class hr_crosswordPuzzle {

    public static final int MATRIX_SIZE = 10;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char[][] puzzle = new char[10][10];
        for (int row = 0; row < MATRIX_SIZE; row++) {
            char[] currentRow = in.nextLine().toCharArray();
            for (int col = 0; col < MATRIX_SIZE; col++) {
                puzzle[row][col] = currentRow[col];
            }
        }

        for (int row = 0; row < MATRIX_SIZE; row++) {
            for (int col = 0; col < MATRIX_SIZE; col++) {
                if (puzzle[row][col] == '-') {

                    if (isInMatrix(row - 1,col) &&          // UP
                            puzzle[row - 1][col] == '-') {
                        
                    } else if (isInMatrix(row,col + 1) &&   // RIGHT
                            puzzle[row][col + 1] == '-') {

                    } else if (isInMatrix(row + 1,col) &&   // DOWN
                            puzzle[row + 1][col] == '-') {

                    } else if (isInMatrix(row,col - 1) &&    // LEFT
                            puzzle[row][col - 1] == '-') {

                    }
                }
            }
        }
    }

    private static boolean isInMatrix(int row, int col) {
        return row >= 0 && row < MATRIX_SIZE &&
                col >= 0 && col < MATRIX_SIZE;
    }

    private static class Word {
        private int length;

        private Map<Word, Connection> connectionByWord;

        public Word(int length) {
            this.connectionByWord = new HashMap<>();

            this.length = length;
        }
    }

    private static class Connection {
        private int fromIndex;
        private int toIndex;

        public Connection(int fromIndex, int toIndex) {
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
        }
    }
}
