package hackerRank.contests.contest_weekOfCode32;

import java.util.Scanner;

/**
 * Created by vladix on 5/17/17.
 */
public class p03_circularWalk {

    private static int g;
    private static int seed;
    private static int p;
    private static int[] seconds_to_index;
    private static int[] ranges;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        seconds_to_index = new int[n];
        ranges = new int[n];

        int start = in.nextInt();
        int target = in.nextInt();
        int range = in.nextInt();

        g = in.nextInt();
        seed = in.nextInt();
        p = in.nextInt();

        ranges[0] = range;
        fill_ranges(n);
        fill_array(start);

        solution(start);

        System.out.println(ranges[target]);
    }

    private static void fill_ranges(int n) {
        for (int i = 1; i < n; i++) {
            ranges[i] = (ranges[i - 1] * g + seed) % p;
        }
    }

    private static void fill_array(int start) {
        for (int i = 0; i < seconds_to_index.length; i++) {
            if (start != i) {
                seconds_to_index[i] = Integer.MAX_VALUE;
            }
        }
    }

    private static void solution(int start) {
        for (int i = start - ranges[start]; i < start + ranges[start]; i++) {

            if (i != start) {
                int index = i;
                if (index < 0) {
                    index = seconds_to_index.length + index;

                    if (index > seconds_to_index.length) {
                        index = index % seconds_to_index.length;
                    }

                    int needed_seconds = seconds_to_index[start] + 1;

                    if (needed_seconds < seconds_to_index[index]) {
                        seconds_to_index[index] = needed_seconds;
                    }

                    solution(index);
                }
            }

        }
    }
}
