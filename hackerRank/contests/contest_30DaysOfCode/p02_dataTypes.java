package hackerRank.contests.contest_30DaysOfCode;

import java.util.Scanner;

/**
 * Created by vladix on 4/24/17.
 */
public class p02_dataTypes {

    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";
        Scanner in = new Scanner(System.in);

        int i1 = Integer.parseInt(in.nextLine());
        double d1 = Double.parseDouble(in.nextLine());
        String s1 = in.nextLine();

        System.out.println(i + i1);
        System.out.println(d + d1);
        System.out.println(s + s1);
    }
}
