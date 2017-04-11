package hackerRank.contests.contest_weekOfCode31;

import java.util.*;

public class p02_accurateSorting {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int queries = in.nextInt();
        for (int i = 0; i < queries; i++) {
            int n = in.nextInt();

            int[] nums = new int[n];
            Set<Integer> sorted_nums = new TreeSet<>();
            for (int j = 0; j < n; j++) {
                int num = in.nextInt();
                nums[j] = num;
                sorted_nums.add(num);
            }

            boolean has_found = false;
            int index_count = 0;
            for (Integer num : sorted_nums) {
                int diff = Math.abs(nums[index_count] - num);
                if (diff > 1) {
                    System.out.println("No");
                    has_found = true;
                    break;
                }

                index_count++;
            }

            if (!has_found) {
                System.out.println("Yes");
            }
        }
    }
}
