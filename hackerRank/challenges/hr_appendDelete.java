package hackerRank.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 9/4/17.
 */
public class hr_appendDelete {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String t = in.next();
        String s = in.next();
        int k = in.nextInt();

        int commonLength = 0;

        for (int i = 0; i < java.lang.Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) == t.charAt(i))
                commonLength++;
            else
                break;
        }

        if ((s.length() + t.length() - 2 * commonLength) > k) {
            System.out.println("No");
        } else if ((s.length() + t.length() - 2 * commonLength) % 2 == k % 2) {
            System.out.println("Yes");
        } else if ((s.length() + t.length() - k) < 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        System.out.println("Yes");
    }
}
