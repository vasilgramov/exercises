package hackerRank.contests.contest_hourRank17;

import java.util.Scanner;

public class p01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        in.nextLine();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int current = in.nextInt();

            if (current > max)
                max = current;

        }

        if (max == Integer.MIN_VALUE || max < k)
            System.out.println(0);
        else
            System.out.println(max - k);
    }
}
