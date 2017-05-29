package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class lc_nextGreaterElementIII {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int i = nextGreaterElement(n);
    }

    public static int nextGreaterElement(int n) {
        char[] num = (n + "").toCharArray();

        int toSwap = -1;
        int smallIndex = Integer.MIN_VALUE;
        for (int i = num.length - 1; i >= 0; i--) {

            for (int j = i - 1; j >= 0; j--) {

                if (num[i] > num[j]) {
                    if (j > smallIndex) {
                        smallIndex = j;
                        toSwap = i;
                    }
                }
            }
        }

        if (toSwap != -1) {
            char temp = num[smallIndex];
            num[smallIndex] = num[toSwap];
            num[toSwap] = temp;

            StringBuilder result = new StringBuilder();
            for (int i = 0; i <= smallIndex; i++) {
                result.append(num[i]);
            }

            List<Character> toSort = new ArrayList<>();
            for (int i = smallIndex + 1; i < num.length; i++) {
                toSort.add(num[i]);
            }

            Collections.sort(toSort);
            for (int i = 0; i < toSort.size(); i++) {
                result.append(toSort.get(i));
            }


            long i = Long.parseLong(result.toString());
            if (i > 2147483647) {
                return -1;
            }

            return (int)i;
        }


        return -1;
    }
}
