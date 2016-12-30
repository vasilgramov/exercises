// https://www.hackerrank.com/challenges/sherlock-and-the-beast
package hackerRank.challenges.easy;

import java.util.Scanner;

public class hr_sherlockAndTheBeast {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int testsCount = Integer.parseInt(in.nextLine());
        for (int i = 0; i < testsCount; i++) {
            int currentNumber = Integer.parseInt(in.nextLine());

            if (currentNumber < 3) {
                System.out.println(-1);
                continue;
            }
            else if (currentNumber % 3 == 0) {
                System.out.println(newString("555", currentNumber / 3));
                continue;
            }

            int count = 1;
            boolean hasFound = false;
            while (count <= currentNumber) {
                if ((currentNumber - count) % 3 == 0 && count % 5 == 0) {
                    System.out.println(newString("555", (currentNumber - count) / 3) + newString("33333", count / 5));
                    hasFound = true;
                    break;
                }

                count++;
            }

            if (!hasFound) {
                if (currentNumber % 5  == 0) {
                    System.out.println(newString("33333", count / 5));
                }
                else {
                    System.out.println(-1);
                }
            }
        }
    }

    private static String newString(String str, int count) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < count; i++) {
            builder.append(str);
        }

        return builder.toString();
    }
}
