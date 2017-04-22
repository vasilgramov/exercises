package hackerRank.contests.contest_rookieRank2;

import java.util.Scanner;

public class p03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String currentString = in.nextLine();

            boolean hasFirst = false;
            boolean hasSecond = false;
            boolean hasThird = false;
            boolean hasFourth = false;
            boolean hasFifth = false;
            boolean hasSixth = false;
            boolean hasSeventh = false;
            boolean hasEight = false;
            boolean hasNine = false;
            boolean hasFound = false;
            for (int j = 0; j < currentString.length(); j++) {
                char currentChar = currentString.charAt(j);
                if (!hasFirst && (currentChar == 'h')) {
                    hasFirst = true;
                    continue;
                }

                if (hasFirst && !hasSecond && (currentChar == 'a')) {
                    hasSecond = true;
                    continue;
                }

                if (hasSecond && (currentChar == 'c')) {
                    hasThird = true;
                    continue;
                }

                if (hasThird && !hasFourth && (currentChar == 'k')) {
                    hasFourth = true;
                    continue;
                }

                if (hasFourth && (currentChar == 'e')) {
                    hasFifth = true;
                    continue;
                }

                if (hasFifth && !hasSixth &&  (currentChar == 'r')) {
                    hasSixth = true;
                    continue;
                }

                if (hasSixth && (currentChar == 'r')) {
                    hasSeventh = true;
                    continue;
                }

                if (hasSeventh && (currentChar == 'a')) {
                    hasEight = true;
                    continue;
                }

                if (hasEight && (currentChar == 'n')) {
                    hasNine = true;
                    continue;
                }

                if (hasNine && (currentChar == 'k')) {
                    System.out.println("YES");
                    hasFound = true;
                    break;
                }
            }

            if (!hasFound) {
                System.out.println("NO");
            }
        }
    }
}
