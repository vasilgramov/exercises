package hackerRank.challenges;

import java.math.BigDecimal;
import java.util.*;

// https://www.hackerrank.com/challenges/sherlock-and-pairs
public class hr_sherlockAndPairs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = Integer.parseInt(in.nextLine());

        for (int i = 0; i < t; i++) {
            Map<Integer, Integer> numbers = new HashMap<>();

            int n = Integer.parseInt(in.nextLine());
            for (int j = 0; j < n; j++) {
                int currentNumber = in.nextInt();

                if (!numbers.containsKey(currentNumber)) {
                    numbers.put(currentNumber, 0);
                } else {
                    int currentCount = numbers.get(currentNumber);
                    if (currentCount == 0) {
                        currentCount = 2;
                    } else {
                        currentCount++;
                    }

                    numbers.put(currentNumber, currentCount);
                }
            }

            BigDecimal count = BigDecimal.ZERO;
            for (Integer integer : numbers.values()) {
                count = count.add(new BigDecimal(integer).multiply(new BigDecimal(integer - 1)));
            }

            System.out.println(count);

            in.nextLine();
        }
    }
}
