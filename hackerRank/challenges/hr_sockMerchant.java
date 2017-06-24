package hackerRank.challenges;

import java.util.Scanner;

public class hr_sockMerchant {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] memo = new int[101];
        for (int i = 0; i < n; i++) {
            memo[in.nextInt()]++;
        }

        int result = 0;
        for (int i = 0; i < memo.length; i++) {
            result += memo[i] / 2;
        }

        System.out.println(result);
    }
}
