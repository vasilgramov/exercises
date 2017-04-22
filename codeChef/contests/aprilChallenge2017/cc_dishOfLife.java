package codeChef.contests.aprilChallenge2017;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class cc_dishOfLife {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = Integer.parseInt(in.nextLine());
        for (int i = 0; i < t; i++) {
            String[] NK = in.nextLine().split(" ");
            int n = Integer.parseInt(NK[0]);
            int k = Integer.parseInt(NK[1]);

            boolean hasFound = false;
            Set<Integer> ingredients = new HashSet<>();
            while (n-- > 0) {
                String line = in.nextLine();
                if (hasFound) {
                    n--;
                    continue;
                }

                String[] tokens = line.split(" ");
                for (int j = 1; j < tokens.length; j++) {
                    int current = Integer.parseInt(tokens[j]);
                    ingredients.add(current);
                }

                if (ingredients.size() == k && n >= 1) {
                    System.out.println("some");
                    hasFound = true;
                }
            }

            if (!hasFound) {
                if (ingredients.size() == k) {
                    System.out.println("all");
                } else {
                    System.out.println("sad");
                }
            }
        }
    }
}
