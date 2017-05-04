package codeForces.contests.codeforcesRound411Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by vladix on 5/4/17.
 */
public class p01 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Integer> countByDivisor = new HashMap<>();

        String[] tokens = in.readLine().split(" ");
        int l = Integer.parseInt(tokens[0]);
        int r = Integer.parseInt(tokens[1]);

        if (r - l > 100) {
            System.out.println(2);
            return;
        }

        for (int number = l; number <= r; number++) {
            for (int divisor = (int)Math.sqrt(number); divisor >= 2; divisor--) {
                if (number % divisor == 0) {
                    if (!countByDivisor.containsKey(divisor)) {
                        countByDivisor.put(divisor, 1);
                    } else {
                        countByDivisor.put(divisor, countByDivisor.get(divisor) + 1);
                    }
                }
            }
        }

        int max = 0;
        int count = -1;
        for (Map.Entry<Integer, Integer> countByDivisorEntry : countByDivisor.entrySet()) {
            if (countByDivisorEntry.getValue() > count) {
                count = countByDivisorEntry.getValue();
                max = countByDivisorEntry.getKey();
            }
        }

        System.out.println(max);
    }
}
