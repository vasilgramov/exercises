package hackerRank.contests.contest_30DaysOfCode;

import java.util.*;

/**
 * Created by vladix on 5/19/17.
 */
public class p30_BitwiseAND {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int s = in.nextInt();

            int[] numers = new int[n];

            for (int j = 0; j < n; j++) {
                numers[i] = j + 1;
            }

            Set<Integer> nums = new HashSet<>();
            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {

                    int result = j & k;

                    nums.add(result);

                }
            }

            int max = -1;
            for (Integer num : nums) {
                if (num > max && num < s) {
                    max = num;
                }
            }

            System.out.println(max);
        }
    }
}
