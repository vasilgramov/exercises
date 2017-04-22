package hackerRank.challenges;

import java.util.Scanner;

public class hr_redJohnIsBack {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = Integer.parseInt(in.nextLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(in.nextLine());

            int combinations = getCombinations(n);

            int primesCount = 0;
            for (int j = 1; j <= combinations; j++) {
                if (isPrime(j)) {
                    primesCount++;
                }
            }

//            System.out.println(combinations);
            System.out.println(primesCount);
        }
    }

    private static int getCombinations(int n) {
        if (n < 0) {
            return 0;
        }

        if (n < 4) {
            return 1;
        }

        if (n == 4) {
            return 2;
        }


        return getCombinations(n - 1) + getCombinations(n - 4);
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
