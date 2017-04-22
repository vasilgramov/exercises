package softUni.preparation.april2th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class partition {

    static int total;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        for (int j = 0; j < n; j++) {
            int k = Integer.parseInt(in.readLine());
            String[] inputNumbersAsStrings = in.readLine().split("\\s+");

            int currentTotal = 0;
            int[] numbers =  new int[inputNumbersAsStrings.length];
            for (int i = 0; i < inputNumbersAsStrings.length; i++) {
                int currentNumber = Integer.parseInt(inputNumbersAsStrings[i]);
                numbers[i] = currentNumber;
                currentTotal += currentNumber;
            }

            total = currentTotal;
            int sum = findMin(numbers, numbers.length);

            System.out.println(sum);
        }
    }

    private static int findMin(int[] arr, int n)
    {
        int sum = total;

        boolean[][] dp = new boolean[n+1][sum / 2 + 1 ];

        // Initialize first column as true. 0 sum is possible
        // with all elements.
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        int diff = Integer.MAX_VALUE;
        // Fill the partition table in bottom up manner
        for (int i=1; i<=n; i++)
        {
            for (int j=1; j<=sum / 2; j++)
            {
                // If i'th element is excluded
                dp[i][j] = dp[i-1][j];

                // If i'th element is included
                if (arr[i-1] <= j)
                    dp[i][j] |= dp[i-1][j-arr[i-1]];

                if (dp[n][j] && (sum - 2 * j) >= 0 &&  (sum - 2 * j) < diff) {
                    diff = sum - 2 * j;
                }
            }
        }

        return diff;
    }
}
