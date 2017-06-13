package hackerRank.challenges;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by vladix on 6/4/17.
 */
public class hr_findTheMedian {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);
        System.out.println(arr[arr.length / 2]);
    }
}
