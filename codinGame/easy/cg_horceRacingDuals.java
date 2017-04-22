package codinGame.easy;// https://www.codingame.com/ide/619493638832ec3e5d7e3ca8e748007e8b5a501


import java.util.Arrays;
import java.util.Scanner;

public class cg_horceRacingDuals {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        int[] horses = new int[n];
        for (int i = 0; i < n; i++) {
            horses[i] = Integer.parseInt(in.nextLine());
        }

        int diff = Integer.MAX_VALUE;
        Arrays.sort(horses);
        for (int i = 1; i < horses.length; i++) {
            int currentDiff = horses[i] - horses[i - 1];

            if (currentDiff < diff) {
                diff = currentDiff;
            }
        }


        System.out.println(diff);
    }
}
