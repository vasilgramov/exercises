package softUni.preparation.march18th;

import java.math.BigInteger;
import java.util.Scanner;

public class boredom {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String n = in.nextLine();

        // (n ^ 2 + n - index * 2) = 0


        BigInteger plus = new BigInteger(n).multiply(new BigInteger("2")).multiply(new BigInteger("4"));
        System.out.println(plus);
        BigInteger d = (BigInteger.ONE).add(plus);

//        int result = -1 +  / 2;
//        System.out.println(result);
    }
}
