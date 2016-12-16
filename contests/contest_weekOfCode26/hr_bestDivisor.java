package hackerRank.contests.contest_weekOfCode26;// https://www.hackerrank.com/contests/w26/challenges/best-divisor

import java.util.*;

public class hr_bestDivisor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int bestDivisor = findTheBestDivisor(n);

        System.out.println(bestDivisor);
    }

    private static int findTheBestDivisor(int n) {
        int bestDivisor = 0;
        int bestSum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                int currentNum = i;
                int currentSumOfDigits = 0;
                while (currentNum > 0) {
                    currentSumOfDigits += currentNum % 10;
                    currentNum /= 10;
                }
                if (currentSumOfDigits > bestSum) {
                    bestSum = currentSumOfDigits;
                    bestDivisor = i;
                }
            }
        }

        int fakeN = n;
        int currentSum = 0;
        while (n > 0) {
            currentSum += n % 10;
            n = n / 10;
        }

        if (currentSum > bestSum){
            return fakeN;
        }

        return bestDivisor;
    }
}