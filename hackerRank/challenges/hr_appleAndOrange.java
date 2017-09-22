package hackerRank.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 9/21/17.
 */
public class hr_appleAndOrange {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();

        int applesOnHouse = 0;
        for (int i = 0; i < m; i++) {
            int applePosition = a + in.nextInt();
            if (applePosition >= s && applePosition <= t) {
                applesOnHouse++;
            }
        }
        System.out.println(applesOnHouse);

        int orangesOnHouse = 0;
        for (int i = 0; i < n; i++) {
            int orangePosition = b + in.nextInt();
            if (orangePosition >= s && orangePosition <= t) {
                orangesOnHouse++;
            }
        }
        System.out.println(orangesOnHouse);
    }
}

