package hackerRank.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 8/29/17.
 */
public class hr_saveThePrisoner {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int s = in.nextInt();

            long result = (m + s - 1) % n;
            System.out.println(result == 0 ? n : result);
        }
    }
}
