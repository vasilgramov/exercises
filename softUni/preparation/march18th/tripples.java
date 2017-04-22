package softUni.preparation.march18th;

import java.util.*;

public class tripples {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<Long, Long> repetitionByNumber = new HashMap<>();

        long maxNumber = Long.MIN_VALUE;

        String[] numbersAsString = in.nextLine().split("\\s+");
        LinkedHashSet<Long> numbers = new LinkedHashSet<>();

        List<Long> indexedNumbers = new ArrayList<>();

        for (int i = 0; i < numbersAsString.length; i++) {
            long currentNumber = Long.parseLong(numbersAsString[i]);
            if (currentNumber > maxNumber) {
                maxNumber = currentNumber;
            }

            if (!numbers.contains(currentNumber)) {
                numbers.add(currentNumber);
                indexedNumbers.add(currentNumber);
            }

            if (!repetitionByNumber.containsKey(currentNumber)) {
                repetitionByNumber.put(currentNumber, 1L);
            } else {
                repetitionByNumber.put(currentNumber, repetitionByNumber.get(currentNumber) + 1);
            }
        }


        int count = 0;
        for (int i = 0; i < indexedNumbers.size(); i++) {
            long n1 = indexedNumbers.get(i);
            if (repetitionByNumber.containsKey(n1 * 2)) {
                long k = repetitionByNumber.get(n1) - 1;
                k = (k * (k + 1)) / 2;
                long q = repetitionByNumber.get(n1 * 2);
                count += k * q;
            }

            for (int j = i + 1; j < repetitionByNumber.size(); j++) {
                long n2 = indexedNumbers.get(j);

                long sum = n1 + n2;

                if (sum > maxNumber) {
                    break;
                } else {
                    if (repetitionByNumber.containsKey(sum)) {
                        long n1Repetitoin = repetitionByNumber.get(n1);
                        long n2Repetitoin = repetitionByNumber.get(n2);
                        long sumRepetition = repetitionByNumber.get(sum);

                        count += n1Repetitoin * n2Repetitoin * sumRepetition;
                    }
                }
            }
        }


        System.out.println(count);
    }
}
