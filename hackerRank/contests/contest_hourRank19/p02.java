package hackerRank.contests.contest_hourRank19;

import java.math.BigInteger;
import java.util.Scanner;

public class p02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];

        BigInteger totalSum = BigInteger.ZERO;
        for(int s_i=0; s_i < n; s_i++){
            int num = in.nextInt();
            s[s_i] = num;

            totalSum = totalSum.add(new BigInteger(num + ""));
        }

        long count = 1L;
        for (int i = 0; i < s.length; i++) {
            long added = 1;
            BigInteger current = new BigInteger(s[i] + "");

            if (totalSum.subtract(current).mod(new BigInteger("2")).equals(BigInteger.ZERO) && n - added % 2 == 1) {
                count++;
            }

            for (int j = i + 1; j < s.length; j++) {
                current = current.add(new BigInteger(s[j] + ""));
                added++;
                if (totalSum.subtract(current).mod(new BigInteger("2")).equals(BigInteger.ZERO) && n - added % 2 == 1) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
