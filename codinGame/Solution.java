package codinGame;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by vladix on 5/4/17.
 */

public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            int E = in.nextInt();
            nums[i] = E;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) builder.append(" ");
            else builder.append((char)(122 - nums[i]));
        }
        System.out.println(builder);
    }
}