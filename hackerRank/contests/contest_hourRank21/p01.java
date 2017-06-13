package hackerRank.contests.contest_hourRank21;

import java.util.Scanner;

/**
 * Created by vladix on 6/2/17.
 */
public class p01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int catchers = in.nextInt();
        int location = in.nextInt();

        int[] time = new int[catchers];
        for (int i = 0; i < catchers; i++) {
            time[i] = in.nextInt();
        }

        for (int i = 0; i < catchers; i++) {
            time[i] = Math.abs(location - time[i]) / in.nextInt();
        }

        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < time.length; i++) {
            if (time[i] < min) {
                min = time[i];
                index = i;
            }
        }

        for (int i = 0; i < time.length; i++) {
            if (min == time[i] && i != index) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(index);
    }
}
