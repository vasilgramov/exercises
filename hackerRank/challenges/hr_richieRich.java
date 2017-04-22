package hackerRank.challenges;

import java.util.Arrays;
import java.util.Scanner;

// Algorithms -> Strings -> Richie Rich
public class hr_richieRich {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

//        int n = in.nextInt();
//        int m = in.nextInt();

        char[] digits = in.next().toCharArray();
        char[] reversed = new char[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[digits.length - 1 - i] = digits[i];
        }

        System.out.println(Arrays.toString(digits));
        System.out.println(Arrays.toString(reversed));
    }
}
