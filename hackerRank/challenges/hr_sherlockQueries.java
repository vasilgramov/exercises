package hackerRank.challenges;

import java.util.ArrayList;
import java.util.Scanner;

public class hr_sherlockQueries {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] commandArgs = in.nextLine().split("\\s+");
        int N = Integer.parseInt(commandArgs[0]);
        int M = Integer.parseInt(commandArgs[1]);

        long[] A = new long[N];
        long[] B = new long[M];
        long[] C = new long[M];


        String[] AElements = in.nextLine().split("\\s+");
        String[] BElements = in.nextLine().split("\\s+");
        String[] CElements = in.nextLine().split("\\s+");

        for (int i = 0; i < AElements.length; i++) {
            A[i] = Long.parseLong(AElements[i]);
        }

        for (int i = 0; i < BElements.length; i++) {
            B[i] = Long.parseLong(BElements[i]);
        }

        for (int i = 0; i < CElements.length; i++) {
            C[i] = Long.parseLong(CElements[i]);
        }

        /*
        for i = 1 to M do
            for j = 1 to N do
                if j % B[i] == 0 then
                    A[j] = A[j] * C[i]
                endif
            end do
        end do
         */

        // logic
        long mod = 1000000007L;
        for (int i = 1; i <= M; i++) {
            boolean hasFound = false;
            for (int j = (int)B[i - 1]; j <= N; j += B[i - 1]) {
                A[j - 1] = (A[j - 1] * C[i - 1]) % mod;

//                int plusOne = (int)(j + B[i - 1]);
//                if (isInArray(A, plusOne - 1)) {
//                    A[plusOne] = (A[plusOne] * C[i - 1]) % mod;
//                    j += plusOne;
//                }

//                int plusTwo = plusOne * 2;
//                if (isInArray(A, plusTwo - 1)) {
//                    A[plusTwo] = (A[plusTwo] * C[i - 1]) % mod;
//                    j += plusTwo;
//                }
//
//                int plusThree = plusOne * 3;
//                if (isInArray(A, plusThree - 1)) {
//                    A[plusThree] = (A[plusThree] * C[i - 1]) % mod;
//                    j += plusThree;
//                }
            }
        }

        for (long num : A) {
            System.out.print(num + " ");
        }
    }

    private static boolean isInArray(long[] arr, int index) {
        if (index >= 0 && index < arr.length)
            return true;

        return false;
    }
}
