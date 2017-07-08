package hackerRank.challenges;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by vladix on 7/8/17.
 */
public class hr_rectangularGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int rows = in.nextInt();
        int cols = in.nextInt();

        for (int i = 0; i < n - 1; i++) {
            int row = in.nextInt();
            int col = in.nextInt();

            rows = Math.min(rows, row);
            cols = Math.min(cols, col);
        }

        BigInteger bigInteger1 = new BigInteger(rows + "");
        BigInteger bigInteger2 = new BigInteger(cols + "");
        BigInteger multiply = bigInteger1.multiply(bigInteger2);
        System.out.println(multiply);
    }
}
