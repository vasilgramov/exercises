package hackerRank.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 9/19/17.
 */
public class hr_birthdayChocolate {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] chocos = new int[n];
        for (int i = 0; i < n; i++) {
            chocos[i] = in.nextInt();
        }

        int d = in.nextInt();
        int m = in.nextInt();

        int count = 0;
        for (int i = 0; i < chocos.length; i++) {
            int sum = 0;
            for (int j = i; j < i + m && j < chocos.length; j++) {
                sum += chocos[j];

                if (sum > d) break;
            }

            if (sum == d) count++;
        }

        System.out.println(count);
    }
}
