//package codeForces.contests.codeforcesRound410Div2;

import java.util.Scanner;

/**
 * Created by vladix on 4/22/17.
 */
public class p01_mikeAndPalindrome {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        boolean hasFound = false;
        int count = 0;
        for (int i = 0; i < input.length() / 2; i++) {
            char front = input.charAt(i);
            char end = input.charAt(input.length() - count - 1);

            if (front != end && !hasFound) {
                hasFound = true;
            } else if (front != end && hasFound) {
                System.out.println("NO");
                return;
            }

            count++;
        }

        if (hasFound || (!hasFound && input.length() % 2 == 1)) {
            System.out.println("YES");
        } else  {
            System.out.println("NO");
        }
    }
}
