package codeForces.contests.codeforcesRound408Div2;

import java.util.Scanner;

/**
 * Created by vladix on 4/29/17.
 */
public class p01_buyingAHouse {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] tokens = in.nextLine().split(" ");
        int numberOfHouses = Integer.parseInt(tokens[0]);
        int crushHouse = Integer.parseInt(tokens[1]) - 1;
        int money = Integer.parseInt(tokens[2]);

        String[] housePricesStrings = in.nextLine().split(" ");
        int[] housePrices = new int[housePricesStrings.length];
        for (int i = 0; i < housePricesStrings.length; i++) {
            housePrices[i] = Integer.parseInt(housePricesStrings[i]);
        }

        int temp = 1;
        while (true) {
            if (isInArray(housePrices.length,crushHouse - temp) &&
                    housePrices[crushHouse - temp] <= money &&
                    housePrices[crushHouse - temp] != 0) {
                System.out.println(temp * 10);
                return;
            } else if (isInArray(housePrices.length,crushHouse + temp) &&
                    housePrices[crushHouse + temp] <= money &&
                    housePrices[crushHouse + temp] != 0) {
                System.out.println(temp * 10);
                return;
            }

            temp++;
        }
    }

    private static boolean isInArray(int arraySize, int index) {
        return index >= 0 && index < arraySize;
    }
}
