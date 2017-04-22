// https://www.hackerrank.com/challenges/two-strings?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=3-day-campaign
package hackerRank.challenges;

import java.util.*;

public class hr_twoStrings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numberOfTestCases = Integer.parseInt(in.nextLine());

        for (int i = 0; i < numberOfTestCases; i++) {
            String firstInput = in.nextLine();
            String secondInput = in.nextLine();
            boolean hasFound = false;

            for (int j = 97; j < 122; j++) {
                char currentChar = (char)j;

                if (firstInput.indexOf(currentChar) != -1 && secondInput.indexOf(currentChar) != -1) {
                    hasFound = true;
                    break;
                }
            }
            
            if (hasFound) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
