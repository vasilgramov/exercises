package codinGame.medium;

import java.util.Arrays;
import java.util.Scanner;

public class cg_theGift {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numberOfParticipants = Integer.parseInt(in.nextLine());
        long giftPrice = Long.parseLong(in.nextLine());
        long[] budges = new long[numberOfParticipants];

        long sum = 0;
        for (int i = 0; i < numberOfParticipants; i++) {
            budges[i] = Long.parseLong(in.nextLine());
            sum += budges[i];
        }

        if (sum < giftPrice) {
            System.out.println("IMPOSSIBLE");
        } else {
            long average = giftPrice / numberOfParticipants;

            Arrays.sort(budges);
            long originalGiftPrice = giftPrice;
            long everything = 0;
            long[] pays = new long[numberOfParticipants];
            for (int i = 0; i < budges.length; i++) {
                long currentBudget = budges[i];

                if (currentBudget < average) {
                    pays[i] = budges[i];

                    giftPrice -= budges[i];
                    average = giftPrice / (numberOfParticipants - (i + 1));

                    budges[i] = 0;
                } else {
                    budges[i] -= average;
                    pays[i] = average;
                }

                everything += pays[i];
            }

            if (everything < originalGiftPrice) {
                int lastIndex = pays.length - 1;
                while (everything != originalGiftPrice) {
                    pays[lastIndex]++;
                    everything++;
                    lastIndex--;
                }
            }
            for (int i = 0; i < pays.length; i++) {
                System.out.println(pays[i]);
            }
        }
    }
}
