package hackerRank.contests.contest_30DaysOfCode;

import java.util.Scanner;

/**
 * Created by vladix on 5/1/17.
 */
public class p12_2dArrays {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[][] matrix = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] currentRow = in.nextLine().split("\\s+");

            for (int j = 0; j < 6; j++) {
                matrix[i][j] = Integer.parseInt(currentRow[j]);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int currentSum =
                        matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2] +
                                     + matrix[i + 1][j + 1] +
                        matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];

                if (currentSum > max) max = currentSum;
            }
        }

        System.out.println(max);
    }
}
