package hackerRank.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 9/23/17.
 */
public class hr_queensAttack {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int rQueen = in.nextInt();
        int cQueen = in.nextInt();

        int left = cQueen - 1;
        int right = n - cQueen;
        int up = n - rQueen;
        int down = rQueen - 1;

        int leftUp = Math.min(left, up);
        int leftDown = Math.min(left, down);
        int rightUp = Math.min(right, up);
        int rightDown = Math.min(right, down);

        for (int i = 0; i < k; i++) {
            int rObstacle = in.nextInt();
            int cObstacle = in.nextInt();

            if (rQueen == rObstacle) {
                if (cQueen > cObstacle)
                    left = Math.min(left, cQueen - cObstacle - 1);
                else
                    right = Math.min(right, cObstacle - cQueen - 1);
            }

            if (cQueen == cObstacle) {
                if (rQueen > rObstacle)
                    down = Math.min(down, rQueen - rObstacle - 1);
                else
                    up = Math.min(up, rObstacle - rQueen - 1);
            }

            if (rQueen + cQueen == rObstacle + cObstacle) {
                if (rQueen < rObstacle)
                    leftUp = Math.min(leftUp, rObstacle - rQueen - 1);
                else
                    rightDown = Math.min(rightDown, rQueen - rObstacle - 1);
            }

            if (rQueen - rObstacle == cQueen - cObstacle) {
                if (rQueen < rObstacle)
                    rightUp = Math.min(rightUp, rObstacle - rQueen - 1);
                else
                    leftDown = Math.min(leftDown, rQueen - rObstacle - 1);
            }
        }

        System.out.print(left + right + up + down +
                leftUp + leftDown + rightUp + rightDown);

    }
}