package hackerRank.challenges;

import java.math.BigInteger;
import java.util.Scanner;

public class hr_fibonacciModified {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String t1 = in.next();
        String t2 = in.next();

        int n = in.nextInt();

        BigInteger t1BI = new BigInteger(t1);
        BigInteger t2BI = new BigInteger(t2);

        for (int i = 0; i < n - 2; i++) {
            BigInteger t3BI = t1BI.add(t2BI.pow(2));
            t1BI = t2BI;
            t2BI = t3BI;
        }

        System.out.println(t2BI);
    }
}
