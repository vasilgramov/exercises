package hackerRank.challenges;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class hr_betweenTwoSets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();

        int start = Integer.MIN_VALUE;
        int end = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if (num > start) start = num;
            A.add(num);
        }

        for (int i = 0; i < m; i++) {
            int num = in.nextInt();
            if (num < end) end = num;
            B.add(num);
        }

        int count = 0;
        for (int i = start; i <= end; i++) {
            boolean hasFound = true;

            for (Integer integer : A) {
                if (i % integer != 0) {
                    hasFound = false;
                    break;
                }
            }

            if (!hasFound) continue;

            for (Integer integer : B) {
                if (integer % i != 0) {
                    hasFound = false;
                    break;
                }
            }

            if (!hasFound) continue;
            count++;
        }

        System.out.println(count);
    }
}
