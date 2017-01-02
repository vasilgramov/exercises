package hackerRank.contests.contest_hourRank16;

import java.util.Scanner;

public class p02_luckyNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = Integer.parseInt(in.nextLine());
        for (int i = 0; i < q; i++) {
            long currentNumber = Long.parseLong(in.nextLine());

            if (isLucky(currentNumber)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean isLucky(long p) {
        if (p % 4 == 0 || p % 7 == 0) {
            return true;
        }

        long copyP = p;

        while (p > 0) {
            p -= 7;
            copyP -= 4;

            if (p % 4 == 0 && p >= 0) {
                return true;
            }
            if (copyP % 7 == 0 && copyP >= 0) {
                return true;
            }
        }

        return false;
    }
}
