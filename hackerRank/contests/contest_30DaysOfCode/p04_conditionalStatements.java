package hackerRank.contests.contest_30DaysOfCode;

import java.util.Scanner;

/**
 * Created by vladix on 4/24/17.
 */
public class p04_conditionalStatements {

    private static final String WEIRD = "Weird";
    private static final String NOT_WEIRD = "Not Weird";


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        /*
        If  is odd, print Weird
        If  is even and in the inclusive range of 2 to 5, print Not Weird
        If  is even and in the inclusive range of 6 to 20, print Weird
        If  is even and greater than 20, print Not Weird
         */

        int n = Integer.parseInt(in.nextLine());
        if (n % 2 == 1) {
            System.out.println(WEIRD);
        } else {
            if (n >= 2 && n <= 5) {
                System.out.println(NOT_WEIRD);
            } else if (n >= 6 && n <= 20) {
                System.out.println(WEIRD);
            } else {
                System.out.println(NOT_WEIRD);
            }
        }
    }
}
