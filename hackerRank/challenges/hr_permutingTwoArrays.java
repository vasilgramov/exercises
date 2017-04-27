package hackerRank.challenges;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by vladix on 4/27/17.
 */
public class hr_permutingTwoArrays {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int q = Integer.parseInt(in.nextLine());
        for (int i = 0; i < q; i++) {
            int n = in.nextInt();
            int k = in.nextInt();

            int[] arr1 = new int[n];
            int[] arr2 = new int[n];
            for (int j = 0; j < n; j++) {
                arr1[j] = in.nextInt();
            }

            for (int j = 0; j < n; j++) {
                arr2[j] = in.nextInt();
            }

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            boolean has_found = false;
            for (int j = 0; j < n; j++) {
                int arr1_num = arr1[j];
                int arr2_num = arr2[n - j - 1];

                if (arr1_num + arr2_num < k) {
                    System.out.println("NO");
                    has_found = true;
                    break;
                }
            }

            if (!has_found) {
                System.out.println("YES");
            }
        }
    }
}
