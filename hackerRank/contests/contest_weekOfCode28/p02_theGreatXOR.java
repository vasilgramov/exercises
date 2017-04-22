package hackerRank.contests.contest_weekOfCode28;

import java.util.Scanner;

public class p02_theGreatXOR {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int queries = Integer.parseInt(in.nextLine());
        for (int i = 0; i < queries; i++) {
            long currentNumber = Long.parseLong(in.nextLine());
            String currentNumberAsBinary = Long.toBinaryString(currentNumber);

            long counter = 0;
            for (int j = 0; j < currentNumberAsBinary.length(); j++) {
                if (currentNumberAsBinary.charAt(j) == '0') {
                    long startNumber = Long.parseLong(1 + newString(currentNumberAsBinary.length() - 1 - j, "1"), 2);
                    long endNumber = (long)Math.pow(2, currentNumberAsBinary.length() - j - 1);

                    counter += startNumber - endNumber + 1;
                }
            }


            System.out.println(counter);
        }
    }

    private static String newString(int n, String str) {
        StringBuilder builder = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            builder.append(str);
        }

        return builder.toString();
    }
}
