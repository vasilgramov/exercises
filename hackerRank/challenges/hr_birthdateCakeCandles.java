package hackerRank.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class hr_birthdateCakeCandles {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int[] candles = new int[n];
        for (int i = 0; i < n; i++) {
            candles[i] = in.nextInt();
        }

        Arrays.sort(candles);
        int count = 1;
        for (int i = candles.length - 2; i >= 0; i--) {
            if (candles[i] == candles[i + 1])
                count++;
            else break;
        }

        System.out.println(count);
    }
}
