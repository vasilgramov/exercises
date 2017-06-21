package hackerRank.challenges;

import java.util.Scanner;

public class hr_camelCase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.next();
        System.out.println(calculateWords(input));
    }

    private static int calculateWords(String string) {
        int c = 1;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == Character.toUpperCase(string.charAt(i))) {
                c++;
            }
        }

        return c;
    }
}
