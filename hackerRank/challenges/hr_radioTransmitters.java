package hackerRank.challenges;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by vladix on 7/20/17.
 */
public class hr_radioTransmitters {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
        }

        Arrays.sort(x);
        int numOfTransmitters = 0;
        int i = 0;

        /*
            Greedy approach
            -- go to right (until we can reach next house) - this will be our mid point
            -- go to right / (end until we can reach next house)
         */
        while (i < n) {

            numOfTransmitters++;
            int loc = x[i] + k;
            while (i < n && x[i] <= loc) {
                i++;
            }

            loc = x[--i] + k;
            while (i < n && x[i] <= loc) {
                i++;
            }
        }
        System.out.println(numOfTransmitters);
    }
}
