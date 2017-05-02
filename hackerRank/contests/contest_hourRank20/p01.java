package hackerRank.contests.contest_hourRank20;

import java.util.Scanner;

/**
 * Created by vladix on 5/2/17.
 */
public class p01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int n4 = in.nextInt();

        if (Math.min(n3, n4) - Math.max(n1, n2) >= 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
