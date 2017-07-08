package hackerRank.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 7/8/17.
 */
public class hr_beautifulBinaryString {

    static int minSteps(int n, String B){
        int count = 0;
        for (int i = 1; i < B.length() - 1; i++) {
            if (B.charAt(i) == '1' && B.charAt(i - 1) == '0' && B.charAt(i + 1) == '0') {
                count++;
                i += 2;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String B = in.next();
        int result = minSteps(n, B);
        System.out.println(result);
    }
}
