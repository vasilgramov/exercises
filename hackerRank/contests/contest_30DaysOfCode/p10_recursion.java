package hackerRank.contests.contest_30DaysOfCode;

import java.util.Scanner;

/**
 * Created by vladix on 4/29/17.
 */
public class p10_recursion {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n  = Integer.parseInt(in.nextLine());
        System.out.println(factorial(n));
    }

    private static int factorial(int n) {
        if (n == 1) return 1;

        return n * factorial(n - 1);
    }
}
