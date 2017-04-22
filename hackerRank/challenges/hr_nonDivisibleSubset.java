package hackerRank.challenges;

import java.util.*;

// https://www.hackerrank.com/challenges/non-divisible-subset
public class hr_nonDivisibleSubset {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] tokens = stringsToIntegers(in.nextLine().split("\\s+"));

        int n = tokens[0];
        int k = tokens[1];

        int[] remainderByK = new int[k];

        String[] numbersAsString = in.nextLine().split("\\s+");
        for (int i = 0; i < n; i++) {
            long currentNumber = Long.parseLong(numbersAsString[i]);

            int remainder = (int)currentNumber % k;
            remainderByK[remainder]++;
        }

        int total = 0;
        if (remainderByK[0] > 0) {
            total++;
        }
        if (k % 2 == 0 && remainderByK.length > k / 2 && remainderByK[k / 2] > 0) {
            total++;
        }


        Map<Integer, Integer> countByNumber = new HashMap<>();
        for (int i = 1; i < k; i++) {
            if (k % 2 == 0 && i == k / 2) {
                continue;
            }

            countByNumber.put(i, remainderByK[i]);
        }

        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
        countByNumber.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> {
                    sortedMap.put(e.getKey(), e.getValue());
                });

        Set<Integer> keys = new HashSet<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : sortedMap.entrySet()) {
            int key = integerIntegerEntry.getKey();
            int value = integerIntegerEntry.getValue();

            int needed = k - key;
            if (!keys.contains(needed)) {
                keys.add(key);
                total += value;
            }
        }

        System.out.println(total);
    }

    private static int[] stringsToIntegers(String[] numbersAsString) {
        int[] parsedNumbers = new int[numbersAsString.length];

        for (int i = 0; i < numbersAsString.length; i++) {
            parsedNumbers[i] = Integer.parseInt(numbersAsString[i]);
        }


        return parsedNumbers;
    }
}