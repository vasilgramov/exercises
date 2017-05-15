package hackerRank.contests.contest_30DaysOfCode;

import java.util.Scanner;

/**
 * Created by vladix on 5/15/17.
 */
public class p26_runningTimeComplexity {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();

            if (isPrime(n)) {
                System.out.println("Prime");
            } else {
                System.out.println("Not prime");
            }
        }
    }

    private static boolean isPrime(int number) {
        if (number == 1) return false;
        if (number == 2) return true;

        for (int i = 2; i <= Math.ceil(Math.sqrt(number)); ++i) {
            if (number % i == 0) return false;
        }

        return true;
    }
}
