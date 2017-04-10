package hackerRank.challenges;

import java.math.BigInteger;
import java.util.Scanner;

public class hr_samAndSubStrings {
    /*
    Input  : num = “1234”
    Output : 1670
    Sum = 1 + 2 + 3 + 4 + 12 + 23 + 34 + 123 + 234 + 1234 = 1670

    Example : num = "1234"
    sumofdigit[0] = 1 = 1
    sumofdigit[1] = 2 + 12  = 14
    sumofdigit[2] = 3 + 23  + 123 = 149
    sumofdigit[3] = 4 + 34  + 234 + 1234  = 1506
    Rescult = 1670

    For above example,
    sumofdigit[3] = 4 + 34 + 234 + 1234
                  = 4 + 30 + 4 + 230 + 4 + 1230 + 4
                  = 4*4 + 10*(3 + 23 +123)
                  = 4*4 + 10*(sumofdigit[2]) <- O.O
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long mod = 1000000007L;

        double total = 0L;

        String number = in.nextLine();
        double prev = number.charAt(0) - '0';
        total += prev;

        for (int i = 1; i < number.length(); i++) {
            double sum_of_digit = (((number.charAt(i) - '0') * (i + 1)) + (10 * prev)) % mod;

            total += sum_of_digit;
            prev = sum_of_digit;
        }

        System.out.printf("%.0f", total % mod);
    }
}
