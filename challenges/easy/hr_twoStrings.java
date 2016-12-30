// https://www.hackerrank.com/challenges/two-strings?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=3-day-campaign
package hackerRank.challenges.easy;

import java.util.Scanner;

public class hr_twoStrings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numberOfTestCases = Integer.parseInt(in.nextLine());

        for (int i = 0; i < numberOfTestCases; i++) {
            String firstStr = in.nextLine();
            String secondStr = in.nextLine();

            boolean hasFound = false;
            if (firstStr.length() <= secondStr.length()) {
                for (int j = 0; j < firstStr.length(); j++) {
                    if (secondStr.indexOf(firstStr.charAt(j)) != -1) {
                        System.out.println("YES");
                        hasFound = true;
                        break;
                    }
                }
            } else {
                for (int j = 0; j < secondStr.length(); j++) {
                    if (firstStr.indexOf(secondStr.charAt(j)) != -1) {
                        System.out.println("YES");
                        hasFound = true;
                        break;
                    }
                }
            }

            if (!hasFound) {
                System.out.println("NO");
            }
        }
    }
}
