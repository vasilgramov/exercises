// https://www.hackerrank.com/challenges/kaprekar-numbers?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
package hackerRank.challenges;

import java.util.Scanner;

public class hr_modifiedKaprekarNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int start = Integer.parseInt(in.nextLine());
        int end = Integer.parseInt(in.nextLine());

        int count = 0;
        for (int i = start; i <= end; i++) {
            if (isKaprekar(i)) {
                System.out.print(i + " ");
                count++;
            }
        }

        if (count == 0) {
            System.out.println("INVALID RANGE");
        }
    }

    private static boolean isKaprekar(int i) {
        long poweredAsLong = (long)Math.pow(i, 2);
        String powered = Long.toString(poweredAsLong);
        String leftPartAsStr = new String();
        String rightPartAsStr = new String();

        int length = powered.length() / 2;

        for (int j = 0; j < length; j++) {
            leftPartAsStr += powered.charAt(j);
        }

        for (int j = length; j < powered.length(); j++) {
            rightPartAsStr += powered.charAt(j);
        }

        int leftPart = 0;
        int rightPart = 0;
        if (!leftPartAsStr.equals("")) {
            leftPart = Integer.parseInt(leftPartAsStr);
            if (leftPart == 0) {
                return false;
            }
        }

        if (!rightPartAsStr.equals("")) {
            rightPart = Integer.parseInt(rightPartAsStr);
            if (rightPart == 0) {
                return false;
            }
        }

        if (leftPart + rightPart == i) {
            return true;
        }

        return false;
    }
}
