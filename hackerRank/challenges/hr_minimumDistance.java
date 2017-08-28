package hackerRank.challenges;

import java.util.*;

/**
 * Created by vladix on 8/28/17.
 */
public class hr_minimumDistance {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
//        int[] arr = new int[n];

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int number = in.nextInt();
            if (map.containsKey(number)) {
                Set<Integer> numbers = map.get(number);
                numbers.add(i);
                map.put(number, numbers);
            } else {
                Set<Integer> numbers = new TreeSet<>();
                numbers.add(i);
                map.put(number, numbers);
            }
        }

        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Set<Integer>> kvp : map.entrySet()) {
            Integer prev = null;
            for (Integer num : kvp.getValue()) {
                if (prev != null) {
                    min = num - prev < min ? num - prev : min;
                }

                prev = num;
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
