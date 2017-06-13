package hackerRank.challenges;

import java.util.*;

/**
 * Created by vladix on 6/3/17.
 */
public class hr_closestNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Map<Integer, List<Integer>> map = new TreeMap<>();

        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            int first = arr[i];
            int second = arr[i + 1];

            int diff = Math.abs(first - second);
            map.putIfAbsent(diff, new ArrayList<>());

            List<Integer> pairs = map.get(diff);
            pairs.add(first);
            pairs.add(second);

            map.put(diff, pairs);
        }

        List<Integer> value = map.entrySet().iterator().next().getValue();
        for (Integer integer : value) {
            System.out.print(integer + " ");
        }

        System.out.println();
    }
}
