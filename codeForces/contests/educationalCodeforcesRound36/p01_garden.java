package codeForces.contests.educationalCodeforcesRound36;

import java.util.Scanner;

public class p01_garden {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int numberOfBuckets = in.nextInt();
        int lengthOfGarden = in.nextInt();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numberOfBuckets; i++) {
            int lengthOfSegment = in.nextInt();

            int current = lengthOfGarden / lengthOfSegment;
            if (lengthOfGarden % lengthOfSegment == 0 && current < min) {
                min = current;
            }
        }

        System.out.println(min);
    }
}
