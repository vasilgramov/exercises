package hackerRank.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 10/1/17.
 */
public class hr_beautifulPairs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//
//        int n = in.nextInt();
//        int[] a = new int[n];
//        int[] b = new int[n];
//
//        fillArr(in, a);
//        fillArr(in, b);
//
//        Map<Integer, Integer> memoA = new TreeMap<>();
//        Map<Integer, Integer> memoB = new TreeMap<>();
//
//        for (int i = 0; i < n; i++) {
//            int numA = a[i];
//            int numB = b[i];
//
//            updateMemo(memoA, numA);
//            updateMemo(memoB, numB);
//        }
//
//        int pairs = 0;
//        boolean hasUsed = false;
//        for (Map.Entry<Integer, Integer> kvp : memoA.entrySet()) {
//            int key = kvp.getKey();
//            int val = kvp.getValue();
//
//            Integer count = memoB.get(key);
//            if (count != null) {
//                if (val > count && !hasUsed) {
//                    pairs += count + 1;
//                    hasUsed = true;
//                } else {
//                    pairs += Math.min(val, count);
//                }
//            }

        int n = in.nextInt();
        int a[] = new int[1001];
        int sum = 0;
        for(int i=1;i<=n;i++)
            a[in.nextInt()]++;


        for(int i=1;i<=n;i++)
        {
            int v = in.nextInt();
            if(a[v]>0)
            {
                sum++;
                a[v]--;
            }
        }



        if(sum<n)
            System.out.print(sum+1);
        else
            System.out.print(sum-1);
    }

//        System.out.println(pairs);


//    private static void updateMemo(Map<Integer, Integer> memo, int n) {
//        if (!memo.containsKey(n)) {
//            memo.put(n, 1);
//        } else {
//            memo.put(n, memo.get(n) + 1);
//        }
//    }
//
//    private static void fillArr(Scanner in, int[] arr) {
//
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = in.nextInt();
//        }
//    }
}
