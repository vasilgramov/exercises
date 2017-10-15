package hackerRank.contests.contest_weekOfCode34;

import java.util.Scanner;

/**
 * Created by vladix on 10/14/17.
 */
public class p01_onceInATram {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt() + 1;
        while (1 != 0) {
            if (isLucky(n)) {
                System.out.println(n);
                return;
            }

            n++;
        }
    }

    private static boolean isLucky(int n) {
        String string = n + "";

        int left = 0;
        int right = 0;
        for (int i = 0; i < string.length(); i++) {
            if (i <= 2) left += Integer.parseInt(string.charAt(i) + "");
            else right += Integer.parseInt(string.charAt(i) + "");
        }

        return left == right;
    }
}
