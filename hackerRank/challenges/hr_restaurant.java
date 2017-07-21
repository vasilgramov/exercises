package hackerRank.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 7/21/17.
 */
public class hr_restaurant {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int l = in.nextInt();
            int b = in.nextInt();

            if (l == b) {
                System.out.println(1);
            } else {
                int egcd = egcd(l, b);
                System.out.println(l * b / (egcd * egcd));
            }
        }
    }

    public static int egcd(int a, int b) {
        if (a == 0)
            return b;

        while (b != 0) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }

        return a;
    }
}
