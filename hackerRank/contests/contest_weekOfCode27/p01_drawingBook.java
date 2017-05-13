package hackerRank.contests.contest_weekOfCode27;

import java.util.Scanner;

/**
 * Created by vladix on 5/13/17.
 */
public class p01_drawingBook {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int pages = in.nextInt();
        int desiredPage = in.nextInt();

        int fromTheBeginnig = desiredPage / 2;
        int fromTheBack = (pages / 2) - fromTheBeginnig;

        System.out.println(Math.min(fromTheBeginnig, fromTheBack));
    }
}
