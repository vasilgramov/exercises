package hackerRank.contest_weekOfCode26;// https://www.hackerrank.com/contests/w26/challenges/twins

import java.util.Scanner;

public class hr_twins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] input = in.nextLine().split("\\s+");
        long start = Long.parseLong(input[0]);
        long end = Long.parseLong(input[1]);

        System.out.println(pairsOfTwins(start, end));
    }

    private static long pairsOfTwins(long start, long end) {
        long pairs = 0;

        for (long i = start; i <= end; i++) {
            if (isPrime(i)) {
                if (i + 2 <= end && isPrime(i + 2)) {
                    pairs++;
                }
            }
        }


        return pairs;
    }

    private static boolean isPrime(long number) {
        long boundary = (long)Math.ceil(Math.sqrt(number));

        for (int i = 2; i <= boundary; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}