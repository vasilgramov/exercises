package codeForces.contests.codeforcesRound460Div2;

import java.util.Scanner;

public class p02_perfectNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int searched = in.nextInt();
        int n = 19;
        int count = 0;
        while (true) {

            if (isPerfect(n)) count++;
            if (count == searched) {
                System.out.println(n);
                return;
            }

            n += 9;
        }
    }

    private static boolean isPerfect(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum == 10;
    }
}