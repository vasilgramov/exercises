package hackerRank.justProblems.easy;// https://www.hackerrank.com/challenges/saveprincess2

import java.util.Scanner;

    public class hr_botSavesPrincess2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        String[] botArgs = in.nextLine().split("\\s+");
        int botRow = Integer.parseInt(botArgs[0]);
        int botCol = Integer.parseInt(botArgs[1]);

        for (int i = 0; i < n; i++) {
            String line = in.nextLine();

            if (line.contains("p")) {
                if (i == botRow) {
                    if (line.indexOf("p") < botCol) {
                        System.out.println("LEFT");
                    } else {
                        System.out.println("RIGHT");
                    }
                } else {
                    if (i < botRow) {
                        System.out.println("UP");
                    } else {
                        System.out.println("DOWN");
                    }
                }
                break;
            }
        }
    }
}
