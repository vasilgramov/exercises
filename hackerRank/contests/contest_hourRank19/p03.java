package hackerRank.contests.contest_hourRank19;

import java.util.Scanner;

public class p03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        int[] piles = new int[n];
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            piles[i] = num;
        }

        long count = 1;
        for (int i = 0; i < n - 1; i++) {
            int current = piles[i + 1];
            for (int j = i + 1; j < n; j++) {
                current ^= piles[j];
            }

            if (current == 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}
