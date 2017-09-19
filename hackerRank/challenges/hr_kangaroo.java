package hackerRank.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 9/19/17.
 */
public class hr_kangaroo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int x1 = in.nextInt();
        int v1 = in.nextInt();

        int x2 = in.nextInt();
        int v2 = in.nextInt();

        int difference = Math.abs(x1 - x2);
        while (true) {
            x1 += v1;
            x2 += v2;

            if (x1 - x2 == 0) {
                System.out.println("YES");
                return;
            }

            if (Math.abs(x1 - x2) > difference) {
                System.out.println("NO");
                return;
            }
        }
    }
}
