package hackerRank.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 5/1/17.
 */
public class hr_jumpingOnTheClouds {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.next();
        }

        int count = 0;
        int index = 0;
        while (index < n - 1) {
            if (isInRange(index + 2, n) && arr[index + 2].equals("0")) {
                index += 2;
            } else {
                index++;
            }

            count++;
        }

        System.out.println(count);
    }

    private static boolean isInRange(int index, int range) {
        return index < range;
    }
}
