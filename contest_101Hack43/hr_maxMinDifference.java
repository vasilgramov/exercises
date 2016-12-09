package hackerRank.contest_101Hack43;

import java.util.Arrays;
import java.util.Scanner;

public class hr_maxMinDifference {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int totalNumbersCount = Integer.parseInt(in.nextLine());
        String[] numbersAsString = in.nextLine().split("\\s+");

        long[] numbers = new long[totalNumbersCount];
        for (int i = 0; i < totalNumbersCount; i++) {
            numbers[i] = Long.parseLong(numbersAsString[i]);
        }

        Arrays.sort(numbers);

        long firstNum = numbers[0];
        long secondNum = numbers[1];

        long beforeLastNum = numbers[numbers.length - 2];
        long lastNum = numbers[numbers.length - 1];

        long diffBetweenFirstAndSecond = secondNum - firstNum;
        long diffBetweenLastAndBeforeLast = lastNum - beforeLastNum;

        if (diffBetweenFirstAndSecond < diffBetweenLastAndBeforeLast) {
            System.out.println(beforeLastNum - firstNum);
        } else {
            System.out.println(lastNum - secondNum);
        }
    }
}
