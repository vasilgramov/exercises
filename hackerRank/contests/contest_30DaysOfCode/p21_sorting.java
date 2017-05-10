package hackerRank.contests.contest_30DaysOfCode;

import java.util.Scanner;

/**
 * Created by vladix on 5/10/17.
 */
public class p21_sorting {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int numSwaps = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int currentNum = arr[j];
                int nextNum = arr[j + 1];

                if (currentNum > nextNum) {
                    numSwaps++;
                    arr[j] = arr[j + 1];
                    arr[j + 1] = currentNum;
                }
            }
        }

        System.out.printf("Array is sorted in %d swaps.%n", numSwaps);
        System.out.printf("First Element: %d %n", arr[0]);
        System.out.printf("Last Element: %d %n", arr[arr.length - 1]);
    }
}
