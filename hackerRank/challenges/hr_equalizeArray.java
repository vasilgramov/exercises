package hackerRank.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 9/19/17.
 */
public class hr_equalizeArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] memo = new int[101];
        for (int i = 0; i < n; i++) {
            memo[in.nextInt()]++;
        }

        int max = 0;
        for (int num : memo) {
            if (num > max) {
                max = num;
            }
        }

        System.out.println(n - max);
    }
}
