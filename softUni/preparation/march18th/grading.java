package softUni.preparation.march18th;

import java.math.BigInteger;
import java.util.Scanner;

public class grading {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] inputArgs = in.nextLine().split(" ");
        BigInteger startNumber = new BigInteger(inputArgs[0]);
        BigInteger endNumber = new BigInteger(inputArgs[1]);

//        BigInteger difference = endNumber.add(startNumber).divide(new BigInteger("2"));

        BigInteger difference = endNumber.add(startNumber).divide(new BigInteger("2"));
//        if (difference.mod(new BigInteger("2")).toString().equals("1")) {
//            difference = difference.add(new BigInteger("1"));
//        }
//
//        difference = difference

        System.out.println(difference.mod(new BigInteger("5")).add(new BigInteger("2")));
    }
}
