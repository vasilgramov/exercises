package hackerRank.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 7/5/17.
 */
public class hr_compareTheTripplets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();

        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();

        int pointsAlice = ((a0 > b0) ? 1 : 0) + ((a1 > b1) ? 1 : 0) + ((a2 > b2) ? 1 : 0);
        int pointsBob = ((a0 < b0) ? 1 : 0) + ((a1 < b1) ? 1 : 0) + ((a2 < b2) ? 1 : 0);
        System.out.println(pointsAlice + " " + pointsBob);
    }
}
