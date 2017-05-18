package hackerRank.contests.contest_30DaysOfCode;

import java.util.Scanner;

/**
 * Created by vladix on 5/18/17.
 */
public class p27_nestedLogic {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int days2 = in.nextInt();
        int months2 = in.nextInt();
        int years2 = in.nextInt();

        int days1 = in.nextInt();
        int months1 = in.nextInt();
        int years1 = in.nextInt();

        if (years1 > years2) {
            System.out.println(0);
            return;
        }

        if (years1 >= years2 && months1 > months2) {
            System.out.println(0);
            return;
        }

        if (years1 >= years2 && months1 >= months2 && days1 > days2) {
            System.out.println(0);
            return;
        }

        if (years1 < years2) {
            System.out.println(10000);
        } else {
            if (months1 < months2) {
                System.out.println(500 * (months2 - months1));
            } else {
                if (days1 < days2) {
                    System.out.println(15 * (days2 - days1));
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}
