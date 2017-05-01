package hackerRank.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 5/1/17.
 */
public class hr_countingSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] count = new int[100];
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            count[in.nextInt()]++;
        }

        for (int i = 0; i < count.length; i++) {
            System.out.print(count[i] + " ");
        }
    }
}
