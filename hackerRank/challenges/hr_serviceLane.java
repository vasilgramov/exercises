// https://www.hackerrank.com/challenges/service-lane?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
package hackerRank.challenges;

import java.util.Scanner;

public class hr_serviceLane {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int lengthOfFreeway = in.nextInt();
        int numberOfTests = in.nextInt();
        
        int[] serviceLaneEntrySegments = new int[lengthOfFreeway];
        for (int i = 0; i < lengthOfFreeway; i++) {
            serviceLaneEntrySegments[i] = in.nextInt();
        }

        for (int i = 0; i < numberOfTests; i++) {
            int start = in.nextInt();
            int end = in.nextInt();

            int min = Integer.MAX_VALUE;
            for (int j = start; j <= end; j++) {
                if (serviceLaneEntrySegments[j] < min) {
                    min = serviceLaneEntrySegments[j];
                }
            }

            if (min == 1) {
                System.out.println(1);
            } else if (min == 2) {
                System.out.println(2);
            } else {
                System.out.println(3);
            }
        }
    }
}
