package hackerRank.contests.contest_30DaysOfCode;

import java.util.Scanner;

/**
 * Created by vladix on 4/26/17.
 */
public class p07_review {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            char[] line = in.nextLine().toCharArray();
            StringBuilder even = new StringBuilder();
            StringBuilder odd = new StringBuilder();
            for (int j = 0; j < line.length; j++) {
                if (j % 2 == 0) {
                    even.append(line[j]);
                } else {
                    odd.append(line[j]);
                }
            }

            System.out.println(even + " " + odd);
        }
    }
}
