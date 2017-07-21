package hackerRank.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 7/21/17.
 */
public class hr_bdayGift {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += in.nextLong();
        }

        System.out.printf("%.1f\n", sum / 2);
    }
}
