package hackerRank.challenges;

import java.math.BigInteger;
import java.util.Scanner;

public class hr_halloweenParty {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(in.nextLine());

            if (k % 2 == 0) {
                BigInteger result = new BigInteger(Integer.toString(k / 2))
                        .multiply(new BigInteger(Integer.toString(k / 2)));
                System.out.println(result);
            } else {
                BigInteger result = new BigInteger(Integer.toString((k + 1) / 2))
                        .multiply(new BigInteger(Integer.toString((k + 1) / 2)));
                result = result.subtract(new BigInteger(Integer.toString((k  + 1) / 2)));
                System.out.println(result);
            }
        }
    }
}
