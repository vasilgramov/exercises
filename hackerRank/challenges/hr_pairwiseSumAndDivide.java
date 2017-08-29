package hackerRank.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 8/24/17.
 */
public class hr_pairwiseSumAndDivide {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
            }

            int sum = 0;
            for (int j = 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    sum += Math.floor((arr[j] + arr[k]) / arr[k] * arr[k]);
                }
            }

            System.out.println(sum);
        }
    }
}
