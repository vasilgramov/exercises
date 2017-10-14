package codeForces.contests.educationalCodeforcesRound30;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by vladix on 10/14/17.
 */
public class BalancedSubstring {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        char[] string = in.next().toCharArray();

        int start = 0;

        /*
        * if current character is 0 we decrement our start
        * else increase
        *
        *
        * if we get a number that's been already met there is a balanced substring between them
        * if we get a zero then the string is balanced from the beginning
        *
        * 0011
        * -1
        * -2
        * -1
        * 0
        *
        * ========================
        * 1111100
        * 1
        * 2
        * 3
        * 4
        * 5
        * 4
        * 3
        *
        * 3 and 4 are the pairs that between them we get balanced substring
        * */
        int best = 0;
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, -1);
        for (int i = 0; i < string.length; i++) {
            if (string[i] == '0') start--;
            else start++;

            if (memo.containsKey(start)) {
                int current = i - memo.get(start);
                best = Math.max(current, best);
            } else {
                memo.put(start, i);
            }
        }

        System.out.println(best);
    }
}
