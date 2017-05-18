package hackerRank.contests.contest_weekOfCode32;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by vladix on 5/16/17.
 */
public class p02_fightTheMonsters {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        double hit = in.nextDouble();
        long t = in.nextLong();

        long[] hps = new long[n];
        for (int i = 0; i < n; i++) {
            hps[i] = in.nextLong();
        }

        Arrays.sort(hps);

        long killed_monsters = 0;
        for (int i = 0; i < hps.length; i++) {
            long needed_seconds = (long)Math.ceil(hps[i] / hit);
            if (needed_seconds <= t) {
                t -= needed_seconds;
            } else {
                break;
            }

            killed_monsters++;
        }

        System.out.println(killed_monsters);
    }
}
