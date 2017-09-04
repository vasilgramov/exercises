package hackerRank.challenges;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by vladix on 9/4/17.
 */
public class hr_extraLongFactorials {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        System.out.println(fact(n));
    }

    public static BigInteger fact(int n) {
        if (n == 1) return BigInteger.ONE;

        return fact(n - 1).multiply(new BigInteger(n + ""));
    }
}
