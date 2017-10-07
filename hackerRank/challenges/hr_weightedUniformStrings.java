package hackerRank.challenges;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by vladix on 10/7/17.
 */
public class hr_weightedUniformStrings {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String string = in.next();

        Set<Integer> uniforms = new HashSet<>();
        int memo = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            int current = c - 96;

            if (i == 0 || c == string.charAt(i - 1)) {
                memo += current;
            } else {
                memo = current;
            }

            uniforms.add(memo);
        }

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            if (uniforms.contains(num)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
