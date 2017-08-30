package hackerRank.challenges;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by vladix on 8/30/17.
 */
public class hr_diwaliLights {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();

            BigInteger result = new BigInteger("2")
                    .pow(n)
                    .mod(new BigInteger("100000"))
                    .subtract(BigInteger.ONE);

            System.out.println(result.toString());
        }
    }
}
