package hackerRank.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 8/20/17.
 */
public class hr_cloudGame {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int[] clouds = new int[n];
        for (int i = 0; i < n; i++) {
            clouds[i] = in.nextInt();
        }

        int e = 100;
        int idx = 2;
        while (idx != 0) {
            if (e <= 0) {
                System.out.println(0);
                return;
            }
            e -= 1;
            if (clouds[idx] == 1) {
                e -= 2;
            }
            idx = (idx + k) % n;
        }

        if (clouds[0] == 1) {
            e -= 2;
        }
        System.out.println(e - 1);
    }
}
