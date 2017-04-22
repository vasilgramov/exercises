package hackerRank.challenges;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class hr_allSumsWithLimitedCoins {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] coins = stringsToIntegers(in.nextLine().split("\\s+"));
        Set<Integer> allPossibleSums = findAllPossibleSums(coins);
        System.out.println(allPossibleSums);
    }

    private static Set<Integer> findAllPossibleSums(int[] coins) {
        Set<Integer> sums = new HashSet<>();
        sums.add(0);
        for (int coin : coins) {
            Set<Integer> newSums = new HashSet<>();
            for (Integer sum : sums) {
                newSums.add(sum + coin);
            }

            sums.addAll(newSums);
        }

        return sums;
    }

    private static int[] stringsToIntegers(String[] numbersAsString) {
        int[] parsedNumbers = new int[numbersAsString.length];

        for (int i = 0; i < numbersAsString.length; i++) {
            parsedNumbers[i] = Integer.parseInt(numbersAsString[i]);
        }


        return parsedNumbers;
    }
}
