package hackerRank.challenges;

import java.time.LocalDate;
import java.util.Scanner;

public class hr_breakingTheRecords {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int games = in.nextInt();
        int firstGame = in.nextInt();
        int lowest = firstGame;
        int highest = firstGame;

        int countLowest = 0;
        int countHighest = 0;
        for (int i = 1; i < games; i++) {
            int current = in.nextInt();

            if (current < lowest) {
                lowest = current;
                countLowest++;
            } else if (current > highest) {
                highest = current;
                countHighest++;
            }

        }

        System.out.println(countHighest + " " + countLowest);
    }
}
