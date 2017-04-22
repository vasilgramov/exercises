package hackerRank.challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Scanner;

public class hr_maxMin {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int numbersCount = Integer.parseInt(in.readLine());
        int lengthCount = Integer.parseInt(in.readLine());

        long[] numbers = new long[numbersCount];
        for (int i = 0; i < numbersCount; i++) {
            numbers[i] = Integer.parseInt(in.readLine());
        }

        Arrays.sort(numbers);

        long unfairness = Long.MAX_VALUE;
        for (int i = 0; i < numbersCount - lengthCount + 1; i++) {
            long num1 = numbers[i];
            long num2 = numbers[i + lengthCount - 1];

            if (num2 - num1 < unfairness)
                unfairness = num2 - num1;
        }

        System.out.println(unfairness);
    }
}
