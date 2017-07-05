package hackerRank.contests.contest_hourRank22;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by vladix on 7/2/17.
 */
public class p01 {

    static int smallestSizeSubsequence(int n, int[] A) {
        Arrays.sort(A);

        int sum = 0;
        for (int i : A) {
            sum += i;
        }

        if (sum % 2 == 0) {
            return 0;
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                return 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        int result = smallestSizeSubsequence(n, A);
        System.out.println(result);
    }
}
