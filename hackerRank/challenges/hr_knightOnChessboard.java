package hackerRank.challenges;

import java.util.*;

/**
 * Created by vladix on 10/6/17.
 */
public class hr_knightOnChessboard {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[][] memo = new int[n][n];

        for (int row = 1; row < n; row++) {
            for (int col = 1; col < n; col++) {
                if (memo[col][row] != 0) {
                    memo[row][col] = memo[col][row];
                    continue;
                }

                int steps = bfs(n, row, col);
                memo[row][col] = steps;
            }
        }

        printResult(memo);
    }

    private static void printResult(int[][] matrix) {
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }

    private static int bfs(int sizeMatrix, int row, int col) {
        Deque<Move> queue = new LinkedList<>();
        boolean[][] visitedCells = new boolean[sizeMatrix][sizeMatrix];

        queue.addAll(getPossibleMoves(0, 0, row, col, 0));
        while (!queue.isEmpty()) {
            Move move = queue.removeFirst();

            // Checks if outside the matrix or if current cell is already visited
            if (!isInMatrix(sizeMatrix, move.row, move.col) || isVisited(visitedCells, move)) {
                continue;
            }

            if (hasReachedEnd(sizeMatrix, move)) {
                return move.steps;
            }

            visitedCells[move.row][move.col] = true;
            queue.addAll(getPossibleMoves(move.row, move.col, row, col, move.steps));
        }

        return -1;
    }

    private static boolean hasReachedEnd(int sizeMatrix, Move move) {
        return move.row == sizeMatrix - 1 && move.col == sizeMatrix - 1;
    }

    private static boolean isVisited(boolean[][] visitedCells, Move move) {
        return visitedCells[move.row][move.col];
    }

    private static boolean isInMatrix(int sizeMatrix, int row, int col) {
        return row >= 0 && row < sizeMatrix && col >= 0 && col < sizeMatrix;
    }

    private static List<Move> getPossibleMoves(int currentRow, int currentCol, int row, int col, int currentSteps) {
        List<Move> moves = new ArrayList<>();

        // Up Left
        moves.add(new Move(currentRow - row, currentCol - col, currentSteps + 1));
        moves.add(new Move(currentRow - col, currentCol - row, currentSteps + 1));

        // Up Right
        moves.add(new Move(currentRow - row, currentCol + col, currentSteps + 1));
        moves.add(new Move(currentRow - col, currentCol + row, currentSteps + 1));

        // Down Right
        moves.add(new Move(currentRow + row, currentCol + col, currentSteps + 1));
        moves.add(new Move(currentRow + col, currentCol + row, currentSteps + 1));

        // Down Left
        moves.add(new Move(currentRow + row, currentCol - col, currentSteps + 1));
        moves.add(new Move(currentRow + col, currentCol - row, currentSteps + 1));

        return moves;
    }

    private static class Move {

        private int row;
        private int col;
        private int steps;

        public Move(int row, int col) {
            this.row = row;
            this.col = col;

            this.steps = 0;
        }

        public Move(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }

        @Override
        public String toString() {
            return this.row + " " + this.col;
        }
    }
}
