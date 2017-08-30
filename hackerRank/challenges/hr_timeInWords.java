package hackerRank.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 8/30/17.
 */
public class hr_timeInWords {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int m = in.nextInt();

        String[] ones = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"twenty", "thirty"};


        if (m == 0) {
            System.out.println(ones[h - 1] + " o' clock");
        } else if (m < 30) {
            if (m == 15) {
                System.out.println(ones[14] + " past " + ones[h - 1]);
            } else if (m < 20) {
                if (m == 1) {
                    System.out.println(ones[m - 1] + " minute past " + ones[h - 1]);
                } else {
                    System.out.println(ones[m - 1] + " minutes past " + ones[h - 1]);
                }
            } else {
                System.out.println("twenty " + ones[m - 21] + " minutes past " + ones[h - 1]);
            }
        } else if (m > 30) {
            m = 60 - m;
            if (m == 15) {
                System.out.println(ones[14] + " to " + ones[h]);
            } else if (m < 20) {
                if (m == 1) {
                    System.out.println(ones[m - 1] + " minute to " + ones[h]);
                } else {
                    System.out.println(ones[m - 1] + " minutes to " + ones[h]);
                }
            } else {
                System.out.println("twenty " + ones[m - 21] + " minutes to " + ones[h]);
            }
        } else {
            System.out.println("half past " + ones[h - 1]);
        }
    }
}