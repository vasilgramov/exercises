package hackerRank.contests.contest_hourRank25;

import java.util.Scanner;

public class p01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int b = in.nextInt();
            int s = in.nextInt();
            int c = in.nextInt();
            int result = profit(b, s, c);
            System.out.println(result);
        }
    }

    private static int profit(int b, int s, int c) {
        int some = c - Math.max(b, s);
        return Math.min(b, s) - some;
    }
}
