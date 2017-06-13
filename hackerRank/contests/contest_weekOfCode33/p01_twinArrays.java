package hackerRank.contests.contest_weekOfCode33;

import java.util.Scanner;

public class p01_twinArrays {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar1 = new int[n];
        for (int ar1_i = 0; ar1_i < n; ar1_i++) {
            ar1[ar1_i] = in.nextInt();
        }
        int[] ar2 = new int[n];
        for (int ar2_i = 0; ar2_i < n; ar2_i++) {
            ar2[ar2_i] = in.nextInt();
        }
        int result = twinArrays(ar1, ar2);
        System.out.println(result);
    }

    private static int twinArrays(int[] ar1, int[] ar2) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ar1.length; i++) {
            for (int j = 0; j < ar2.length; j++) {
                if (i != j) {
                    int current = ar1[i] + ar2[j];
                    if (current < min) {
                        min = current;
                    }
                }
            }
        }

        return min;
    }
}