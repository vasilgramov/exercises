package hackerRank.challenges;

import java.util.Scanner;

public class hr_superSixSubstrings {

    static long[][] memoize = new long[100002][5];
    static String input;

    static void fillMatrxi() {
        for (int i = 0; i < memoize.length; i++) {
            for (int j = 0; j < memoize[i].length; j++) {
                memoize[i][j] = -1;
            }
        }
    }

    static long f(int i, int m) {
        if (i == input.length()) {
            return 0;
        }

        if (memoize[i][m] != -1) {
            return memoize[i][m];
        }

        int x = Integer.parseInt(Character.toString(input.charAt(i)));
        int toAdd = 0;
        if (((x + m) % 3) == 0 && x % 2 == 0) {
            toAdd++;
        }

        long ans = f(i + 1, (m + x) % 3) + toAdd;
        memoize[i][m] = ans;

        return memoize[i][m];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        fillMatrxi();

        input = in.nextLine();
        long ans = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '0') ans++;
            else {
                ans += f(i, 0);
            }
        }


        System.out.println(ans);
    }
}
