package hackerRank.contests.contest_30DaysOfCode;

import java.util.Scanner;

/**
 * Created by vladix on 5/7/17.
 */
public class p18_moreExceptions {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int p = in.nextInt();

            if (n < 0 || p < 0) {
                System.out.println("n and p should be non-negative");
            } else {
                System.out.println((int)Math.pow(n, p));
            }
        }
    }
}
