// https://www.hackerrank.com/challenges/cut-the-sticks?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
package hackerRank.challenges;

import java.util.Arrays;
import java.util.Scanner;

public class hr_cutTheSticks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numberOfSticks = Integer.parseInt(in.nextLine());
        int[] sticks = new int[numberOfSticks];
        for (int i = 0; i < numberOfSticks; i++) {
            sticks[i] = in.nextInt();
        }

        Arrays.sort(sticks);

        for (int i = 0; i < sticks.length; i++) {
            int count = 0;
            for (int j = i; j < sticks.length; j++) {
                if (sticks[i] == sticks[j]) {
                    count++;
                } else {
                    i += count - 1;
                    break;
                }
            }

            if (numberOfSticks > 0)
                System.out.println(numberOfSticks);
            numberOfSticks -= count;
        }
    }
}
