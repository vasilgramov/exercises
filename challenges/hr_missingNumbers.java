package hackerRank.challenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class hr_missingNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        Map<Integer, Integer> countByNumsA = new HashMap<>();
        getNumbers(in, n, countByNumsA);

        in.nextLine();

        int m = Integer.parseInt(in.nextLine());
        Map<Integer, Integer> countByNumsB = new TreeMap<>();
        getNumbers(in, m, countByNumsB);

        for (Map.Entry<Integer, Integer> integerIntegerEntry : countByNumsB.entrySet()) {
            int num = integerIntegerEntry.getKey();
            int repetitionsInB = integerIntegerEntry.getValue();
            int repetitionsInA = countByNumsA.get(num);

            if (repetitionsInB > repetitionsInA)
                System.out.print(num + " ");
        }

        System.out.println();
    }

    private static void getNumbers(Scanner in, int countOfNumbers, Map<Integer, Integer> countByNumber) {
        for (int i = 0; i < countOfNumbers; i++) {
            int currentNumber = in.nextInt();

            if (!countByNumber.containsKey(currentNumber)) {
                countByNumber.put(currentNumber, 1);
            } else {
                countByNumber.put(currentNumber, countByNumber.get(currentNumber) + 1);
            }
        }
    }
}
