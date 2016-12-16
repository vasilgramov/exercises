// https://www.hackerrank.com/challenges/taum-and-bday?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

package hackerRank.challenges.easy;

import java.util.Scanner;

public class hr_taumAndBday {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long numberOfTests = Long.parseLong(in.nextLine());
        for (int i = 0; i < numberOfTests; i++) {
            String[] giftData = in.nextLine().split("\\s+");
            long numberOfBlack = Long.parseLong(giftData[0]);
            long numberIfWhite = Long.parseLong(giftData[1]);

            String[] giftArgs = in.nextLine().split("\\s+");
            long blackPrice = Long.parseLong(giftArgs[0]);
            long whitePrice = Long.parseLong(giftArgs[1]);
            long convertPrice = Long.parseLong(giftArgs[2]);

            long firstCondition = blackPrice * numberOfBlack + whitePrice * numberIfWhite;
            long secondCondition = blackPrice * numberOfBlack + (blackPrice + convertPrice) * numberIfWhite;
            long thirdCondition = (whitePrice + convertPrice) * numberOfBlack + whitePrice * numberIfWhite;

            if (firstCondition < secondCondition && firstCondition < thirdCondition) {
                System.out.println(firstCondition);
            } else if (secondCondition < firstCondition && secondCondition < thirdCondition) {
                System.out.println(secondCondition);
            } else {
                System.out.println(thirdCondition);
            }
        }
    }
}

