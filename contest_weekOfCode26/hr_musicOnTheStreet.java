package hackerRank.contest_weekOfCode26;// https://www.hackerrank.com/contests/w26/challenges/street-parade-1

import java.util.Scanner;

public class hr_musicOnTheStreet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long n = Long.parseLong(in.nextLine());
        String[] someUselessShit = in.nextLine().split("\\s+");
        String[] playerArgs = in.nextLine().split("\\s+");
        long miles = Long.parseLong(playerArgs[0]);
        long minHours = Long.parseLong(playerArgs[1]);
        long maxHours = Long.parseLong(playerArgs[2]);

        long x = miles / (n + 1);
        while (x < minHours) {
            n--;
            x = miles / (n + 1);

            if (n == 1) {
                System.out.println(someUselessShit[someUselessShit.length - 1]);
                return;
            }
        }

        long leftMiles = miles - (x * n);
        x += leftMiles;
        if (x > maxHours) {
            x = maxHours;
        }

        System.out.println(Long.parseLong(someUselessShit[0]) - x);
    }
}
