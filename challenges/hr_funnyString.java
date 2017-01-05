// https://www.hackerrank.com/challenges/funny-string
package hackerRank.challenges;

import java.util.Scanner;

public class hr_funnyString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        for (int test = 0; test < testCases; test++) {
            String inputText = in.nextLine();
            String reversedInput = new StringBuilder(inputText).reverse().toString();

            boolean isFunny = true;

            outerloop:
            for (int i = 1; i < inputText.length(); i++) {
                int firstResult = Math.abs(inputText.charAt(i) - inputText.charAt(i - 1));
                for (int j = i; j <= i; j++) {
                    int secondResult = Math.abs(reversedInput.charAt(j) - reversedInput.charAt(i - 1));

                    if (firstResult != secondResult) {
                        isFunny = false;
                        break outerloop;
                    }
                }
            }

            if (isFunny) {
                System.out.println("Funny");
            }
            else {
                System.out.println("Not Funny");
            }
        }
    }
}
