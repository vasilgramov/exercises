package codinGame.medium;

import java.util.Scanner;

public class cg_stockExchangeLosses {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int[] stockValues = new int[n];

        for (int i = 0; i < n; i++) {
            stockValues[i] = in.nextInt();
        }

        int maxDifference = 0;
        int biggestNumber = -1;

        for (int i = 0; i < n; i++) {
            int stockValue = stockValues[i];

            if (stockValue > biggestNumber) {
                biggestNumber = stockValue;
                continue;
            }

            if (biggestNumber - stockValue > maxDifference) {
                maxDifference = biggestNumber - stockValue;
            }
        }

        if (maxDifference == 0) System.out.println("0");
        else System.out.println("-" + maxDifference);
    }
}
