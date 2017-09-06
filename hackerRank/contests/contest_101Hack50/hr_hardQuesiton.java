package hackerRank.contests.contest_101Hack50;

import java.util.Scanner;

/**
 * Created by vladix on 9/6/17.
 */
public class hr_hardQuesiton {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        char[] v = in.next().toCharArray();
        char[] c = in.next().toCharArray();

        int count = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] == '.') continue;

            if (v[i] != c[i]) count++;
        }

        System.out.println(count);
    }
}
