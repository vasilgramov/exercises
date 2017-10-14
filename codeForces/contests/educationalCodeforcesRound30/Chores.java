package codeForces.contests.educationalCodeforcesRound30;

import java.util.Scanner;

/**
 * Created by vladix on 10/14/17.
 */
public class Chores {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int choresToDo = in.nextInt();
        int numberOfChoresInX = in.nextInt();
        int x = in.nextInt();

        int[] chores = new int[choresToDo];
        for (int i = 0; i < choresToDo; i++) {
            chores[i] = in.nextInt();
        }

        int result = 0;
        for (int i = chores.length - 1; i >= 0; i--) {
            int chore = chores[i];

            if (numberOfChoresInX > 0 && x < chore) {
                numberOfChoresInX--;
                result += x;
            } else {
                result += chore;
            }
        }

        System.out.println(result);
    }
}
