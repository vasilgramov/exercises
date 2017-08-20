package hackerRank.challenges;

import java.util.*;

/**
 * Created by vladix on 8/20/17.
 */
public class hr_easySum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long t = in.nextLong();
        for (long i = 0; i < t; i++) {
            long a = in.nextLong();
            long b = in.nextLong();

            a = (((b - 1) * b) / 2) * (a / b) + (a % b) * (a % b + 1) / 2;
            System.out.println(a);
        }
    }
}