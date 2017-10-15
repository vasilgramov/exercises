package hackerRank.contests.contest_weekOfCode34;

import java.util.*;

/**
 * Created by vladix on 10/14/17.
 */
public class p02_maximumGCDAndSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        Map<Integer, Integer> memoA = new HashMap<>();
        Map<Integer, Integer> memoB = new HashMap<>();

        int maxA = Integer.MIN_VALUE;
        int maxB = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            maxA = Math.max(maxA, num);

            getDivisors(num, memoA);
        }

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            maxB = Math.max(maxB, num);

            getDivisors(num, memoB);
        }

        int max = Integer.MIN_VALUE;
        for (Integer key : memoA.keySet()) {
            if (memoB.containsKey(key)) {
                max = Math.max(max, key);
            }
        }

        if (max == Integer.MIN_VALUE) {
            System.out.println(maxA + maxB);
        } else {
            System.out.println(memoA.get(max) + memoB.get(max));
        }
    }

    private static void getDivisors(int num, Map<Integer, Integer> memo) {
        updateMemo(1, num, memo);
        updateMemo(num, num, memo);

        for (int i = 2; i <= Math.sqrt(num); i++) { //* i = Math.sqrt(num); i >= 2; i--; ???
            if (num % i == 0) {
                updateMemo(i, num, memo);

                if (i != num / i) {
                    updateMemo(num / i, num, memo);
                }
            }
        }
    }

    private static void updateMemo(int key, int val, Map<Integer, Integer> memo) {
        Integer number = memo.get(key);
        if (number == null) {
            number = val;

            memo.put(key, number);
        } else {
            number = Math.max(number, val);

            memo.put(key, number);
        }
    }
}