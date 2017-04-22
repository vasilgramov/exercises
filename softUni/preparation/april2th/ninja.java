package softUni.preparation.april2th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ninja {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(in.readLine());

            boolean[][] matrix = new boolean[n][n];
            for (int row = 0; row < n; row++) {
                String[] currentRow = in.readLine().split("\\s+");
                for (int col = 0; col < currentRow.length; col++) {
                    if (currentRow[col].equals("!")) {
                        matrix[row][col] = true;
                    }
                }
            }

            int[][] moves = new int[n][n];

            moves[0][0] = 1;
            fillFRow(n, matrix, moves);
            fillFCol(n, matrix, moves);

            printMoves(moves);
            int stepsCount = 1;
            // TODO!!!
            for (int row = 1; row < n; row++) {
                for (int col = 1; col < n; col++) {
                    int needFromUp = 0;
                    if (moves[row - 1][col] % 2 == 1 && matrix[row][col] ||
                            moves[row - 1][col] % 2 == col && !matrix[row][col]) {
                        needFromUp = moves[row - 1][col] + 1;
                    } else if (moves[row - 1][col] % 2 == 1 && !matrix[row][col] ||
                            moves[row - 1][col] % 2 == col && matrix[row][col]) {
                        needFromUp = moves[row - 1][col] + 1;
                    }

                    int needFromLeft = 0;
                    if (moves[row][col - 1] % 2 == 1 && matrix[row][col] ||
                            moves[row][col - 1] % 2 == row && !matrix[row][col]) {
                        needFromLeft = moves[row][col - 1] + 1;
                    } else if (moves[row][col - 1] % 2 == 1 && !matrix[row][col] ||
                            moves[row][col - 1] % 2 == row && matrix[row][col]) {
                        needFromLeft = moves[row][col - 1] + 1;
                    }

                    if (needFromUp <= needFromLeft) {
                        moves[row][col] = needFromUp;
                    } else {
                        moves[row][col] = needFromLeft;
                    }
                }
            }

            System.out.println(moves[n - 1][n - 1]);
        }
    }

    private static void printMoves(int[][] moves) {
        for (int row = 0; row < moves.length; row++) {
            for (int col = 0; col < moves[row].length; col++) {
                System.out.print(moves[row][col] + " ");
            }

            System.out.println();
        }
    }

    private static void fillFCol(int n, boolean[][] matrix, int[][] moves) throws Exception {
        for (int col = 1; col < n; col++) {
            if (col % 2 == 1 && matrix[0][col] ||
                    col % 2 == 0 && !matrix[0][col]) {
                moves[0][col] = moves[0][col - 1] + 1;
            } else if (col % 2 == 1 && !matrix[0][col] ||
                    col % 2 == 0 && matrix[0][col]) {
                moves[0][col] = moves[0][col - 1] + 2;
            } else {
                throw new Exception("WTF ???");
            }
        }
    }

    private static void fillFRow(int n, boolean[][] matrix, int[][] moves) throws Exception {
        for (int row = 1; row < n; row++) {
            if (row % 2 == 1 && matrix[row][0] ||
                    row % 2 == 0 && !matrix[row][0]) {
                moves[row][0] = moves[row - 1][0] + 1;
            } else if (row % 2 == 1 && !matrix[row][0] ||
                    row % 2 == 0 && matrix[row][0]) {
                moves[row][0] = moves[row - 1][0] + 2;
            } else {
                throw new Exception("WTF ???");
            }
        }
    }
}
