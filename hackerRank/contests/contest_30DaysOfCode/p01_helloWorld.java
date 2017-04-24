package hackerRank.contests.contest_30DaysOfCode;

import java.util.Scanner;

/**
 * Created by vladix on 4/24/17.
 */
public class p01_helloWorld {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputString = scan.nextLine();

        scan.close();

        System.out.println("Hello, World.");
        System.out.println(inputString);
    }
}
