//package codeForces.contests.codeforcesRound460Div2;

import java.util.Scanner;

public class p01_supermarket {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int shops = in.nextInt();
        int kilosToBuy = in.nextInt();

        double min = Double.MAX_VALUE;
        for (int i = 0; i < shops; i++) {
            double price = in.nextInt();
            double kilos = in.nextInt();

            min = Math.min(min, price / kilos);
        }

        System.out.println(min * kilosToBuy);
    }
}
