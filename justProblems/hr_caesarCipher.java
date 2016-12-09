package hackerRank.justProblems;// https://www.hackerrank.com/challenges/caesar-cipher-1?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

import java.util.Scanner;

public class hr_caesarCipher {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int length = Integer.parseInt(in.nextLine());
        String text = in.nextLine();
        int encrypionKey = Integer.parseInt(in.nextLine()) % 26;

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (Character.isAlphabetic(text.charAt(i))) {
                boolean isUpperCase = Character.isUpperCase(text.charAt(i));
                char curretLetter = (char)(text.charAt(i) + encrypionKey);
                if (isUpperCase && curretLetter > 90) {
                    curretLetter -= 26;
                } else if (!isUpperCase && curretLetter > 122) {
                    curretLetter -= 26;
                }

                builder.append(curretLetter);
            } else {
                builder.append(text.charAt(i));
            }
        }

        System.out.println(builder.toString());
    }
}
