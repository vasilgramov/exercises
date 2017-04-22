package codinGame.medium;

import java.util.Scanner;

public class cg_doNotPanic {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int nbOfFloors = in.nextInt();
        int width = in.nextInt();
        int nbRounds = in.nextInt();
        int exitFloor = in.nextInt();
        int exitPos = in.nextInt();
        int nbTotalClones = in.nextInt();
        int nbAdditionalElevators = in.nextInt();
        int nbElevators = in.nextInt();

        int[][] elevatorsArgs = new int[nbElevators][2];
        for (int i = 0; i < nbElevators; i++) {
            int elevatorFloor = in.nextInt();
            int elevatorPos = in.nextInt();

            elevatorsArgs[i][0] = elevatorFloor;
            elevatorsArgs[i][1] = elevatorPos;
        }

        boolean hasGoneUp = false;
        while (true) {
            int cloneFloor = in.nextInt();
            int clonePos = in.nextInt();
            String cloneDirection = in.next();

            if (cloneFloor == -1 && clonePos == -1 && cloneDirection.equals("NONE")) {
                System.out.println("WAIT");
                continue;
            }

            if (cloneFloor == exitFloor) {
                movingOnTheExitFloor(exitPos, clonePos, cloneDirection);
            } else {
                goingUpToTheExitFloor(elevatorsArgs, cloneFloor, clonePos, cloneDirection);
            }
        }
    }

    private static void goingUpToTheExitFloor(int[][] elevatorsArgs, int cloneFloor, int clonePos, String cloneDirection) {
        for (int i = 0; i < elevatorsArgs.length; i++) {    // optimize to save current elevatorFloor and elevatorPos
            if (elevatorsArgs[i][0] == cloneFloor) {
                if (clonePos == elevatorsArgs[i][1]) {
                    System.out.println("WAIT");
                } else if (clonePos > elevatorsArgs[i][1]) {
                    if (cloneDirection.equals("RIGHT")) {
                        System.out.println("BLOCK");
                    } else {
                        System.out.println("WAIT");
                    }
                } else if (clonePos < elevatorsArgs[i][1]) {
                    if (cloneDirection.equals("RIGHT")) {
                        System.out.println("WAIT");
                    } else {
                        System.out.println("BLOCK");
                    }
                }
            }
        }
    }

    private static void movingOnTheExitFloor(int exitPos, int clonePos, String cloneDirection) {
        if (clonePos >= exitPos) {
            if (cloneDirection.equals("RIGHT")) {
                System.out.println("BLOCK");
            } else {
                System.out.println("WAIT");
            }
        } else {
            if (cloneDirection.equals("RIGHT")) {
                System.out.println("WAIT");
            } else {
                System.out.println("BLOCK");
            }
        }
    }
}

