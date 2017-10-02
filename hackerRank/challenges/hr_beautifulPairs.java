package hackerRank.challenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by vladix on 10/1/17.
 */
public class hr_beautifulPairs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        fillArr(in, a);
        fillArr(in, b);

        Map<Integer, Integer> memoA = new HashMap<>();
        Map<Integer, Integer> memoB = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int numA = a[i];
            int numB = b[i];

            updateMemo(memoA, numA);
            updateMemo(memoB, numB);
        }


        int counter = getPairwiseDisjointBeautifulPairs(memoA, memoB);

        if (counter + 1 > n) {  // if the arrays are equal we must change one element and we get n - 1 pairs
            System.out.println(counter - 1);
        } else {                // we have the count of equal elements, before changing the element
            System.out.println(counter + 1);
        }
    }

    private static int getPairwiseDisjointBeautifulPairs(Map<Integer, Integer> memoA, Map<Integer, Integer> memoB) {
        int counter = 0;
        for (Map.Entry<Integer, Integer> kvp : memoA.entrySet()) {
            int key = kvp.getKey();
            int valA = kvp.getValue();

            Integer valB = memoB.get(key);
            if (valB != null) {
                counter += Math.min(valA, valB);
            }
        }
        return counter;
    }

    private static void updateMemo(Map<Integer, Integer> memo, int n) {
        if (!memo.containsKey(n)) {
            memo.put(n, 1);
        } else {
            memo.put(n, memo.get(n) + 1);
        }
    }

    private static void fillArr(Scanner in, int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
    }
}
