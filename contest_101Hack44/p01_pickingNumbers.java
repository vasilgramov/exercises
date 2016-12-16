package hackerRank.contest_101Hack44;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class p01_pickingNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        Arrays.sort(a);

        ArrayList<Integer> max = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            ArrayList<Integer> current = new ArrayList<>();

            for (int j = i; j < a.length; j++) {
                if (Math.abs(a[i] - a[j]) <= 1) {
                    current.add(a[j]);
                }
            }

            if (current.size() > max.size()) {
                max = current;
            }
        }

//        for (int i = 0; i < max.size(); i++) {
//            System.out.println(max.get(i));
//        }

        System.out.println(max.size());
    }
}
