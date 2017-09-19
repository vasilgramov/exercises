package hackerRank.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 9/19/17.
 */
public class hr_migratoryBirds {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] memo = new int[6];

        for (int i = 0; i < n; i++) {
            memo[in.nextInt()]++;
        }

        int max = -1;
        int idx = 0;
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] > max) {
                max = memo[i];
                idx = i;
            }
        }

        System.out.println(idx);
    }
}
