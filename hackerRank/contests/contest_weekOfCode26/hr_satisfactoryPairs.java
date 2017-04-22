package hackerRank.contests.contest_weekOfCode26;// https://www.hackerrank.com/contests/w26/challenges/pairs-again

import java.util.Scanner;

public class hr_satisfactoryPairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //long n = Long.parseLong(in.nextLine());

        //long pairs = findSatisfactoryPairs(n);
        //System.out.println(pairs);

        System.out.println(gcd(0, 5));
    }

    private static long findSatisfactoryPairs(long n) {
        long pairs = 0;

        for (long i = 1; i < n ; i++) {
            for (long j = i + 1; j < n; j++) {
                outerloop:
                for (int k = 1; k <= n / 2; k++) {
                    for (int l = 1; l <= n / 2; l++) {
                        if ((i * k) + (j * l) == n) {
                            //System.out.println(i + " * " + k + " + " + j + " * " + l);
                            pairs++;
                            break outerloop;
                        }
                    }
                }
            }
        }

        return pairs;
    }

    public static int gcd(int a, int b) {
        if (a == 0)
            return b;

        while (b != 0) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }

        return a;
    }
}
