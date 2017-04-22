// https://www.hackerrank.com/contests/w28/challenges/boat-trip
package hackerRank.contests.contest_weekOfCode28;

import java.util.Scanner;

public class p01_boatTrips {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numberOfTrips = in.nextInt();
        int boatCapacity = in.nextInt();
        int totalBoats = in.nextInt();

        int totalCapacity = totalBoats * boatCapacity;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numberOfTrips; i++) {
            int currentPassengers = in.nextInt();
            if (max < currentPassengers) {
                max = currentPassengers;
            }
        }

        if (totalCapacity >= max) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
