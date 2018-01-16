package codeForces.contests.educationalCodeforcesRound36;

import java.util.Scanner;

public class p02_browser {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int numberOfTabs = in.nextInt();
        int cursorPosition = in.nextInt();
        int left = in.nextInt();
        int right = in.nextInt();

        int toRemoveLeft = left - 1;
        int toRemoveRight = numberOfTabs - right;

        if (toRemoveLeft == 0 && toRemoveRight == 0) System.out.println(0);
        else if (toRemoveLeft > 0 && toRemoveRight == 0) {
            int toMove = calculateToMove(cursorPosition, left);
            System.out.println(toMove + 1);  // + 1 for removing all tabs to the left
        } else if (toRemoveLeft == 0 && toRemoveRight > 0) {
            int toMove = calculateToMove(cursorPosition, right);
            System.out.println(toMove + 1);  // + 1 for removing all tabs to the right
        } else {
            int toMoveLeft = calculateToMove(cursorPosition, left);
            int toMoveRight = calculateToMove(cursorPosition, right);

            if (toMoveLeft < toMoveRight) {
                System.out.println(toMoveLeft + 1 + calculateToMove(left, right) + 1);
            } else {
                System.out.println(toMoveRight + 1 + calculateToMove(right, left) + 1);
            }
        }
    }

    private static int calculateToMove(int cursor, int end) {
        return Math.abs(cursor - end);
    }
}
