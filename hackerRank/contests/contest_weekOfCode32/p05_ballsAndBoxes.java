package hackerRank.contests.contest_weekOfCode32;

import java.util.*;

/**
 * Created by vladix on 5/19/17.
 */
public class p05_ballsAndBoxes {

    private static int ballsCount = 0;
    private static int[] balls;

    private static int[] takenColor;

    private static int[] allowedBalls;
    private static int[][] matrix;

    private static PriorityQueue<Cell> priorityQueue = new PriorityQueue<>();


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        /*
        ------ Put balls while ballsCount > 0 AND after putting we increase candiesCount
         */

        int n = in.nextInt();
        int m = in.nextInt();


        getBallsCount(in, n);

        getAllowedBallsForCol(in, m);

        buildMatrix(in, n, m);

        int count = 0;
        while (ballsCount > 0 && priorityQueue.size() > 0) {
            Cell cell = priorityQueue.extractMax();
            if (cell.value > 0) {
                int row = cell.row;
                int col = cell.col;

                if (balls[row] > 0) {
                    balls[row]--;
                    ballsCount--;

                    count += cell.value;

                    allowedBalls[col]--;
                    int allowed = allowedBalls[col];

                    if (allowed <= 0) {
                        List<Cell> heap = priorityQueue.heap;
                        for (Cell currentCell : heap) {
                            if (currentCell.col == col) {
                                int newValue = currentCell.value - (int) Math.pow(Math.abs(allowed) + 1, 2);

                                currentCell.value = newValue;
                                priorityQueue.decreaseKey(currentCell);
                            }
                        }
                    }
                }
            } else {
                break;
            }
        }


        System.out.println(count);

    }

    private static void buildMatrix(Scanner in, int n, int m) {
        matrix = new int[n][m];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                int value = in.nextInt();
                matrix[row][col] = value;

                int allowed = allowedBalls[col];
                if (allowed <= 0) {
                    value = value - (int) Math.pow(Math.abs(allowed) + 1, 2);
                }

                Cell cell = new Cell(row, col, value);

                priorityQueue.enqueue(cell);
            }
        }
    }

    private static void getAllowedBallsForCol(Scanner in, int m) {
        allowedBalls = new int[m];
        takenColor = new int[m];

        for (int i = 0; i < m; i++) {
            allowedBalls[i] = in.nextInt();
        }
    }

    private static void getBallsCount(Scanner in, int n) {
        balls = new int[n];

        for (int i = 0; i < n; i++) {
            int currentBallsCount = in.nextInt();

            ballsCount += currentBallsCount;
            balls[i] = currentBallsCount;
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }


    private static class Cell implements Comparable<Cell> {

        private int row;
        private int col;
        private int value;

        public Cell(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }

        @Override
        public int compareTo(Cell o) {
            return Integer.compare(this.value, o.value);
        }

        @Override
        public boolean equals(Object obj) {
            Cell cell = ((Cell) obj);

            return this.row == cell.row && this.col == cell.col;
        }

        @Override
        public int hashCode() {
            return String.format("%d%d", this.row, this.col).hashCode();
        }

        @Override
        public String toString() {
            return String.format("%d %d %d", this.row, this.col, this.value);
        }

    }

    private static class PriorityQueue<T extends Comparable<T>> {
        private Map<T, Integer> searchCollection;
        private List<T> heap;

        public PriorityQueue() {
            this.heap = new ArrayList<>();
            this.searchCollection = new HashMap<T, Integer>();
        }

        public int size() {
            return this.heap.size();
        }

        public T peekMin() {
            return this.heap.get(0);
        }

        public boolean contains(T element) {
            return this.searchCollection.containsKey(element);
        }

        public void enqueue(T element) {
            this.searchCollection.put(element, this.heap.size());
            this.heap.add(element);
            this.heapifyUp(this.heap.size() - 1);
        }

        public T extractMax() {
            T max = this.heap.get(0);
            T last = this.heap.get(this.heap.size() - 1);
            this.searchCollection.put(last, 0);
            this.heap.set(0, last);
            this.heap.remove(this.heap.size() - 1);
            if (this.heap.size() > 0) {
                this.heapifyDown(0);
            }

            this.searchCollection.remove(max);

            return max;
        }

        public void decreaseKey(T element) {
            int index = this.searchCollection.get(element);
            this.heapifyUp(index);
        }

        private void heapifyDown(int i) {
            int left = (2 * i) + 1;
            int right = (2 * i) + 2;
            int biggest = i;

            if (left < this.heap.size() && this.heap.get(left).compareTo(this.heap.get(biggest)) > 0) {
                biggest = left;
            }

            if (right < this.heap.size() && this.heap.get(right).compareTo(this.heap.get(biggest)) > 0) {
                biggest = right;
            }

            if (biggest != i) {
                T old = this.heap.get(i);
                this.searchCollection.put(old, biggest);
                this.searchCollection.put(this.heap.get(biggest), i);
                this.heap.set(i, this.heap.get(biggest));
                this.heap.set(biggest, old);
                this.heapifyDown(biggest);
            }
        }

        private void heapifyUp(int i) {
            int parent = (i - 1) / 2;
            while (i > 0 && this.heap.get(i).compareTo(this.heap.get(parent)) > 0) {
                T old = this.heap.get(i);
                this.searchCollection.put(old, parent);
                this.searchCollection.put(this.heap.get(parent), i);
                this.heap.set(i, this.heap.get(parent));
                this.heap.set(parent, old);

                i = parent;
                parent = (i - 1) / 2;
            }
        }
    }
}
