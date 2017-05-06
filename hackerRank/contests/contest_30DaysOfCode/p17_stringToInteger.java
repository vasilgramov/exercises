package hackerRank.contests.contest_30DaysOfCode;

import java.util.Scanner;

/**
 * Created by vladix on 5/6/17.
 */
public class p17_stringToInteger {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.next();
        try {
            int num = Integer.parseInt(str);
            System.out.println(num);
        } catch (NumberFormatException nfe) {
            System.out.println("Bad String");
        }
    }
}
