package hackerRank.challenges;

import java.util.Scanner;

public class hr_theCoinChangeProblem {

    static long numberOfWays(int S[], int m, int n) {
        long[] table = new long[n+1];

        table[0] = 1;

        for (int i=0; i<m; i++)
            for (int j=S[i]; j<=n; j++)
                table[j] += table[j-S[i]];

        return table[n];
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String[] NM = in.nextLine().split("\\s+");
        int n = Integer.parseInt(NM[0]);
        int m = Integer.parseInt(NM[1]);

        int arr[] = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(numberOfWays(arr, m, n));
    }
}

