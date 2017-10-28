package codeChef.contests.octoberLunchTime2017;

import java.util.Scanner;

/**
 * Created by vladix on 10/28/17.
 */
public class p01_buggyCalculator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int f = in.nextInt();
            int s = in.nextInt();

            StringBuilder result = new StringBuilder();
            String current = (sum(f, s));
            int idx = 0;


            if (current.length() == 1) {
                System.out.println(current);
            } else {
                while (current.charAt(idx) == '0') {
                    idx++;
                }
                for (int j = idx; j < current.length(); j++) {
                    result.append(current.charAt(j));
                }

                System.out.println(result);
            }

        }
    }

    private static String sum(int f, int s) {
        String fStr = f + "";
        String sStr = s + "";

        String result = null;
        if (fStr.length() < sStr.length()) {
            result = getSum(f, s);
        } else {
            result = getSum(s, f);
        }

        return result;
    }

    private static String getSum(int f, int s) {
        String fStr = f + "";
        String sStr = s + "";
        StringBuilder result = new StringBuilder();

        int idx = 1;
        for (int i = fStr.length() - 1; i >= 0; i--) {
            int fN = Integer.parseInt(fStr.charAt(fStr.length() - idx) + "");
            int sN = Integer.parseInt(sStr.charAt(sStr.length() - idx) + "");

            String sum = (fN + sN) + "";
            result.append(sum.charAt(sum.length() - 1)).append("");
            idx++;
        }

        int count = 0;
        sStr = new StringBuilder(sStr).reverse().toString();
        int rotations = Math.abs(fStr.length() - sStr.length());
        while (rotations-- > 0) {
            result.append(sStr.charAt(fStr.length() + count));
        }

        return result.reverse().toString();
    }
}
