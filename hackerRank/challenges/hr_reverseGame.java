package hackerRank.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 7/23/17.
 */
public class hr_reverseGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();

            int[] elements = new int[n];
            int end = elements.length - 1;
            int front = 0;
            boolean fromEnd = true;
            for (int j = 0; j < elements.length; j++) {
                if (fromEnd) {
                    elements[j] = end--;
                    fromEnd = false;
                } else {
                    elements[j] = front++;
                    fromEnd = true;
                }
            }

            for (int j = 0; j < elements.length; j++) {
                if (elements[j] == k) {
                    System.out.println(j);
                    break;
                }
            }
        }
    }
}
