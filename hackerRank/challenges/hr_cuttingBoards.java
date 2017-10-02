package hackerRank.challenges;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by vladix on 9/29/17.
 */
public class hr_cuttingBoards {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();

        for (int k = 0; k < q; k++) {
            int m = in.nextInt();
            int n = in.nextInt();

            long verticalMultiplier = 1;
            long horizontalMultiplier = 1;

            Line[] lines = getLines(in, m, n);

            Arrays.sort(lines);

            long cost = 0L;
            for (int i = lines.length - 1; i >= 0; i--) {
                Line line = lines[i];
                if (line.horizontalOrVertical.equals("horizontal")) {
                    cost += line.value * verticalMultiplier;
                    horizontalMultiplier++;
                } else {
                    cost += line.value * horizontalMultiplier;
                    verticalMultiplier++;
                }
            }

            cost = cost % (long) (Math.pow(10, 9) + 7);
            System.out.println(cost);
        }
    }

    private static Line[] getLines(Scanner in, int m, int n) {
        Line[] lines = new Line[(m + n) - 2];

        int idx = 0;
        for (int j = 0; j < m - 1; j++) {
            lines[idx++] = new Line(in.nextInt(), "horizontal");
        }

        for (int j = 0; j < n - 1; j++) {
            lines[idx++] = new Line(in.nextInt(), "vertical");
        }

        return lines;
    }

    private static class Line implements Comparable<Line> {
        private int value;
        private String horizontalOrVertical;

        public Line(int value, String horizontalOrVertical) {
            this.value = value;
            this.horizontalOrVertical = horizontalOrVertical;
        }

        @Override
        public int compareTo(Line o) {
            return Integer.compare(this.value, o.value);
        }
    }
}
