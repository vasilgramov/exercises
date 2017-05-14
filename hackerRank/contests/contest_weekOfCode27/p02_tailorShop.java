package hackerRank.contests.contest_weekOfCode27;

import java.util.*;

public class p02_tailorShop {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int p = in.nextInt();

        TreeSet<Integer> not_used = new TreeSet<>();
        for (int i = 1; i < 1000000; i++) {
            not_used.add(i);
        }

        Deque<Integer> taken = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int min_price = in.nextInt();

            int needed = 0;
            if (min_price % p == 0) {
                needed = min_price / p;
            } else {
                needed = min_price / p + 1;
            }

            Integer currentTaken = not_used.ceiling(needed);
            not_used.remove(currentTaken);

            taken.add(currentTaken);
        }

        long sum = 0;
        for (Integer num : taken) {
            sum += num;
        }

        System.out.println(sum);
    }
}