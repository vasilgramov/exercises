package hackerRank.contests.contest_weekOfCode33;

import java.util.Scanner;

public class p02_patternCount {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = patternCount(s);
            System.out.println(result);
        }
    }

    private static int patternCount(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                i++;

                while (i < s.length() && s.charAt(i) == '0') {
                    i++;
                }

                if (i < s.length() && s.charAt(i) == '1' && s.charAt(i - 1) != '1') {
                    count++;
                }

                i--;
            }
        }

        return count;
    }
}
