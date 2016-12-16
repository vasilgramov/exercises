package hackerRank.challenges.easy;// https://www.hackerrank.com/challenges/saveprincess

import java.util.Scanner;

public class hr_botSavesPrincess {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        int princessRow = 0;
        int princessCol = 0;

        for (int i = 0; i < n; i++) {
            String currentLineSymbols = in.nextLine();

            if (currentLineSymbols.contains("p")) {
                princessRow = i;
                princessCol = currentLineSymbols.indexOf("p");
            }
        }

        if (princessRow == 0) {
            for (int i = 0; i < n / 2; i++) {
                System.out.println("UP");
            }
        } else {
            for (int i = 0; i < n / 2; i++) {
                System.out.println("DOWN");
            }
        }

        if (princessCol == 0) {
            for (int i = 0; i < n / 2; i++) {
                System.out.println("LEFT");
            }
        } else {
            for (int i = 0; i < n / 2; i++) {
                System.out.println("RIGHT");
            }
        }
    }
}
