package hackerRank.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 8/29/17.
 */
public class hr_fairRations {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] =  in.nextInt();
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                if (i + 1 >= arr.length) {
                    System.out.println("NO");
                    return;
                }

                count += 2;
                arr[i]++;
                arr[i + 1]++;
            }
        }

        System.out.println(count);
    }
}
