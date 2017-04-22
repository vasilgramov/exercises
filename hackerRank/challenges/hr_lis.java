package hackerRank.challenges;

import java.util.Arrays;
import java.util.Scanner;

public class hr_lis {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(in.nextLine());
        }

        int lisSize = LIC(arr);
        System.out.println(lisSize);
    }

    private static int LIC(int[] arr) {
        int[] memo = new int[arr.length];
        memo[0] = 1;
        int max = -1;

        // TODO: binary search

        for (int i = 1; i < arr.length; i++) {
            memo[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && memo[i] < memo[j] + 1) {
                    memo[i] = memo[j] + 1;
                    if (memo[i] > max) {
                        max = memo[i];
                    }
                }
            }
        }

//        System.out.println(Arrays.toString(memo));

        return max;
    }

    private static class Node {
        private int value;
        private int lisValue;


        public Node(int value, int lisValue) {
            this.value = value;
            this.lisValue = lisValue;
        }
    }
}
