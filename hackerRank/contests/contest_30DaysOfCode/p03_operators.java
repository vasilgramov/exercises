package hackerRank.contests.contest_30DaysOfCode;

import java.util.Scanner;

/**
 * Created by vladix on 4/24/17.
 */
public class p03_operators {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double mealCost = Double.parseDouble(in.nextLine());
        int tipPercent = Integer.parseInt(in.nextLine());
        int taxPercent = Integer.parseInt(in.nextLine());

        double tip = mealCost * tipPercent / 100.0;
        double tax = mealCost * taxPercent / 100.0;

        int total = (int)Math.round(mealCost + tip + tax);
        System.out.printf("The total meal cost is %d dollars.", total);
    }
}
