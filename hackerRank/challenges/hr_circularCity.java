package hackerRank.challenges;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/circle-city?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

public class hr_circularCity {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-- > 0) {
            long d = in.nextLong();
            long k = in.nextLong();
            long c = 0;

            long s = (long) Math.ceil(Math.sqrt(d));
            for (int i = 0; i < s; i++) {
                double j = Math.sqrt(d - i * i);
                if (j == (long) j) {
                    c += 4;
                }
            }

            if (k >= c) {
                System.out.println("possible");
            } else {
                System.out.println("impossible");
            }
        }
    }
}
