package codeForces.contests.codeforcesRound439Div2;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by vladix on 10/8/17.
 */
public class problemB {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        BigInteger a = new BigInteger(in.next() + "");
        BigInteger b = new BigInteger(in.next() + "");

        BigInteger subtract = b.subtract(a);

        if (a.equals(b)) {
            System.out.println("1");
        } else if (subtract.compareTo(new BigInteger("5")) >= 0) {
            System.out.println("0");
        } else {
            int iterations = Integer.parseInt(subtract.toString());
            BigInteger result = a.add(BigInteger.ONE);
            for (int i = 0; i < iterations - 1; i++) {
                result = result.multiply(a.add(new BigInteger((i + 2) + "")));
            }

            System.out.println(result.toString().charAt(result.toString().length() - 1));
        }
    }
}
