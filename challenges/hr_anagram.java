// https://www.hackerrank.com/challenges/anagram?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
package hackerRank.challenges;

import java.util.Scanner;

public class hr_anagram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numberOfTests = Integer.parseInt(in.nextLine());
        for (int i = 0; i < numberOfTests; i++) {
            String currentInput = in.nextLine();
            if (currentInput.length() % 2 == 1) {
                System.out.println(-1);
            } else {
                int mid = currentInput.length() / 2;
                String firstPart = currentInput.substring(0, mid);
                String secondPart = currentInput.substring(mid);

                StringBuilder s2 = new StringBuilder(secondPart);
                
                for (int j = 0; j < firstPart.length(); j++) {
                    if (s2.toString().contains(Character.toString(firstPart.charAt(j)))) {
                        s2.deleteCharAt(s2.indexOf(Character.toString(firstPart.charAt(j))));
                    }
                }

                System.out.println(s2.length());
            }
        }
    }
}
