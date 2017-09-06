package hackerRank.contests.contest_101Hack50;

import java.util.Scanner;

/**
 * Created by vladix on 9/6/17.
 */
public class hr_evenOddBoxes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int b = in.nextInt();
            int[] choco = new int[b];

            for (int j = 0; j < b; j++) {
                choco[j] = in.nextInt();
            }

            boolean even = true;
            int count = 0;
            int reserve = 0;
            for (int j = 0; j < choco.length; j++) {
                if (even) {

                    if (choco[j] % 2 != 0) {
                        count++;
                        reserve++;
                    }
                } else {

                    if (choco[j] % 2 == 0) {
                        count++;
                        reserve++;
                    }
                }

                even = !even;
            }
        }
    }
}
