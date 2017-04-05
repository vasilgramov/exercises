package hackerRank.challenges;

import java.util.Scanner;

public class hr_trees {

    // Find the count of all possible combinations for placing A B C D, there should not be consecutive trees of same type;
    private static long[][][][][] memo = new long[11][11][11][11][5];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        memo[0][0][0][0][0] = 1;
        memo[0][0][0][0][1] = 1;
        memo[0][0][0][0][2] = 1;
        memo[0][0][0][0][3] = 1;

        int a = Integer.parseInt(in.nextLine());
        int b = Integer.parseInt(in.nextLine());
        int c = Integer.parseInt(in.nextLine());
        int d = Integer.parseInt(in.nextLine());

        long comb = findAllPossibleCombinations(a, b, c, d, 4);

        System.out.println(comb);
    }

    private static long findAllPossibleCombinations(int a, int b, int c, int d, int lastType) {
        if (memo[a][b][c][d][lastType] > 0) {
            return memo[a][b][c][d][lastType];
        }

        long count = 0;

        if (a > 0 && lastType != 0) {
            count += findAllPossibleCombinations(a - 1, b, c, d, 0);
        }

        if (b > 0 && lastType != 1) {
            count += findAllPossibleCombinations(a, b - 1, c, d, 1);
        }

        if (c > 0 && lastType != 2) {
            count += findAllPossibleCombinations(a, b, c - 1, d, 2);
        }

        if (d > 0 && lastType != 3) {
            count += findAllPossibleCombinations(a, b, c, d - 1, 3);
        }

        memo[a][b][c][d][lastType] = count;

        return count;
    }
}
