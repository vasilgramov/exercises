package hackerRank.contests.contest_101Hack46;

import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.Scanner;

public class p01 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = Integer.parseInt(in.nextLine());
        int[] cupcakes = new int[n];
        for (int i = 0; i < n; i++) {
            cupcakes[i] = in.nextInt();
        }

        Arrays.sort(cupcakes);

        long calories = 0L;
        int index = 0;
        for (int i = cupcakes.length - 1; i >= 0; i--) {
            calories = calories + cupcakes[i] * (long)Math.pow(2, index);
            index++;
        }

        System.out.println(calories);
    }
}
