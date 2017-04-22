package softUni.preparation.march18th;

import java.math.BigInteger;
import java.util.Scanner;

public class digit {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        BigInteger poweredNumber = new BigInteger(Integer.toString(n));
        poweredNumber = poweredNumber.pow(n);
        int length = poweredNumber.toString().length();
        if (n > length) {
            System.out.println("*");
        } else {
            System.out.println(poweredNumber.toString().charAt(n - 1));
        }
    }
}
