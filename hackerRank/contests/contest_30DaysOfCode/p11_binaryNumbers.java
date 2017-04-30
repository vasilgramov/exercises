package hackerRank.contests.contest_30DaysOfCode;

import java.util.Scanner;

/**
 * Created by vladix on 4/30/17.
 */
public class p11_binaryNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        String binaryString = Integer.toBinaryString(n);

        int maxCount = 0;
        for (int i = 0; i < binaryString.length() - 1; i++) {
            if (binaryString.charAt(i) == '1') {
                int currentCount = 0;

                while (i < binaryString.length() &&
                        binaryString.charAt(i) == '1') {
                    currentCount++;
                    i++;
                }

                if (currentCount > maxCount) {
                    maxCount = currentCount;
                }
            }
        }

        System.out.println(maxCount);
    }
}
