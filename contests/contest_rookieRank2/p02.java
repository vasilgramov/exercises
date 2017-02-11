package hackerRank.contests.contest_rookieRank2;

import java.util.Arrays;
import java.util.Scanner;

public class p02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        Arrays.sort(nums);
        long minDiff = Long.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] < minDiff)
                minDiff = nums[i + 1] - nums[i];
        }

        System.out.println(minDiff);
    }
}
