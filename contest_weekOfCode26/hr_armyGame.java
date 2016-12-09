package hackerRank.contest_weekOfCode26;// https://www.hackerrank.com/contests/w26/challenges/game-with-cells

import java.util.Scanner;

public class hr_armyGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] gridArgs = in.nextLine().split("\\s+");
        int rows = Integer.parseInt(gridArgs[0]);
        int cols = Integer.parseInt(gridArgs[1]);

        int totalPackages = 0;
        if (rows >= 2 && cols >= 2) {
            int rowsPackages = cols / 2 + cols % 2;

            int totalColsForPackiging = rows / 2 + rows % 2;

            totalPackages = rowsPackages * totalColsForPackiging;
        } else {
            if (rows == 1) {
                totalPackages = cols / 2 + cols % 2;
            } else {
                totalPackages = rows / 2 + rows % 2;
            }
        }

        System.out.println(totalPackages);
    }
}
