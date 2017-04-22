package hackerRank.contests.contest_weekOfCode31;

import java.util.*;

public class p03_zeroOneGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int g = Integer.parseInt(in.nextLine());
        for (int i = 0; i < g; i++) {
            int n = Integer.parseInt(in.nextLine());
            String[] tokens = in.nextLine().split(" ");
            int onesCount = 0;
            Set<Integer> removedOnesIndeces = new HashSet<>();
            for (int j = 1; j < tokens.length - 1; j++) {
                if (tokens[j].equals("1") &&
                        tokens[j - 1].equals("0") &&
                        tokens[j + 1].equals("0")) {
                    onesCount++;
                    removedOnesIndeces.add(j);
                }
            }

            String[] newTokens = new String[tokens.length - onesCount];
            int idx = 0;
            for (int j = 0; j < tokens.length; j++) {
                if (!removedOnesIndeces.contains(j)) {
                    newTokens[idx++] = tokens[j];
                }
            }

            int zerosCount = 0;
            for (int j = 1; j < newTokens.length - 1; j++) {
                if (newTokens[j - 1].equals("0") &&
                        newTokens[j + 1].equals("0")) {
                    zerosCount++;
                }
            }

            if ((onesCount + zerosCount) % 2 == 0) {
                System.out.println("Bob");
            } else {
                System.out.println("Alice");
            }
        }
    }
}
