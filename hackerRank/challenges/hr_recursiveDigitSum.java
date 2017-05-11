package hackerRank.challenges;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by vladix on 5/11/17.
 */

// algorithms -> recursion
public class hr_recursiveDigitSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String n = in.next();
        int k = in.nextInt();

        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < n.length(); i++) {
            sum = sum.add(new BigInteger(n.charAt(i) + ""));
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            builder.append(sum);
        }

        System.out.println(getSuperDigit(builder.toString()));
    }
    
    // recursive
    private static int getSuperDigit(String num) {
        if (num.length() == 1) {
            return Integer.parseInt(num);
        }

        BigInteger currentDigitsSum = BigInteger.ZERO;
        for (int i = 0; i < num.length(); i++) {
            currentDigitsSum = currentDigitsSum.add(new BigInteger(num.charAt(i) + ""));
        }

        return getSuperDigit(currentDigitsSum.toString());
    }
}
