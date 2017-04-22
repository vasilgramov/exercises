package hackerRank.challenges;

import java.util.*;

public class hr_equal {

    /*
    First we must realize that adding to all but the chosen one is the same as subtracting from only the chosen one.

    Then the other idea is that we must find the optimal solution.
    For example, 0 4 4 could be solved like this: 0 4 4 --> 0 4 2 --> 0 4 0 --> 0 2 0 --> 0 0 0 -->

    But the optimal solution is this: 0 4 4 --> 0 4 -1 --> 0 -1 -1 --> -1 -1 -1 -->

    This is what I call the 'base'. and I add it to the delta, and it turns out you have to make at least 3 trials.
     */

    public static long find_min_actions(int[] cookies) {
        Arrays.sort(cookies);

        long sum = Long.MAX_VALUE;

        for (int base = 0; base < 3; base++) {
            int current_sum = 0;

            for (int i = 0; i < cookies.length; i++) {
                int delta = cookies[i] - cookies[0] + base;
                current_sum += (int) (delta / 5 + delta % 5 / 2 + delta % 5 % 2 / 1);
            }

            sum = Math.min(current_sum, sum);
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        while (n-- > 0) {
            int m = in.nextInt();
            int cookies[] = new int[m];
            for (int cookie_i = 0; cookie_i < m; cookie_i++) {
                cookies[cookie_i] = in.nextInt();
            }

            System.out.println(find_min_actions(cookies));
        }
    }
}