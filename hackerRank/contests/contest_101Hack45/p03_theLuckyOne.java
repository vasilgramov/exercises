package hackerRank.contests.contest_101Hack45;

import java.math.BigInteger;
import java.util.Scanner;

public class p03_theLuckyOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
//        BigInteger[] nums = new BigInteger[n];

        String[] elements = in.nextLine().split("\\s+");
        for (int i = 0; i < elements.length; i++) {
            BigInteger divisor = new BigInteger(elements[i]);
            int count = 0;
            boolean toReturn = true;
            for (int j = 0; j < elements.length; j++) {
                if (i == j)
                    continue;

                BigInteger delimiter = new BigInteger(elements[j]);
                if (divisor.compareTo(delimiter) < 0 && divisor.remainder(delimiter).equals("0")) {
                    continue;
                } else {
                    count++;
                }

                if (count > 1) {
                    toReturn = false;
                    break;
                }
            }

            if (toReturn)
                System.out.println(divisor);
        }
    }
}
