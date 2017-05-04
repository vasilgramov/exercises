package softUni.problems;

import java.lang.reflect.Executable;
import java.util.Scanner;

/**
 * Created by vladix on 5/3/17.
 */
public class su_handScore {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] cards = in.nextLine().split("\\s+");

        int total = 0;
        for (int i = 0; i < cards.length; i++) {
            char suit = cards[i].charAt(cards[i].length() - 1);
            int count = 0;
            int score = 0;

            while (i < cards.length && suit == cards[i].charAt(cards[i].length() - 1)) {
                String face = cards[i].substring(0, cards[i].length() - 1);

                int currentScore = 0;
                try {
                    currentScore = Integer.parseInt(face);
                } catch (Exception e) {
                    switch (face) {
                        case "J":
                            currentScore = 12;
                            break;
                        case "Q":
                            currentScore = 13;
                            break;
                        case "K":
                            currentScore = 14;
                            break;
                        case "A":
                            currentScore = 15;
                            break;
                    }
                }

                score += currentScore;
                i++;
                count++;
            }

            i--;
            total += score * count;
        }

        System.out.println(total);
    }
}
