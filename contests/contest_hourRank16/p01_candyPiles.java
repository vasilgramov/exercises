package hackerRank.contests.contest_hourRank16;

import java.util.Scanner;

public class p01_candyPiles {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        long firstMin = Long.MAX_VALUE;
        long secondMin = Long.MAX_VALUE;
        boolean twoEquals = false;
        for (int i = 0; i < n; i++) {
            long currentPileSize = in.nextLong();
            if (firstMin > currentPileSize) {
                secondMin = firstMin;
                firstMin = currentPileSize;
            } else if (firstMin == currentPileSize) {
                twoEquals = true;
                break;
            } else if (secondMin > currentPileSize){
                secondMin = currentPileSize;
            }
        }

        if (twoEquals) {
            System.out.println(firstMin + " " + n);
        } else {
            long current = firstMin * 2;

            if (current < secondMin) {
                System.out.println(current + " " + 1);
            } else {
                System.out.println(secondMin + " " + 1);
            }
        }
    }
}
