package hackerRank.challenges;

import java.util.Scanner;

public class hr_repeatedString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String string = in.nextLine();
        long n = Long.parseLong(in.nextLine());

        long count = 0L;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'a') {
                count++;
            }
        }

        long numberOfRepetitions = n / string.length();
        count = count * numberOfRepetitions;
        if (n % string.length() != 0) {
            long left = n - (numberOfRepetitions * string.length());
            for (int i = 0; i < left; i++) {
                if (string.charAt(i) == 'a') {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
