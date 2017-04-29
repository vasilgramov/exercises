package codeForces.contests.codeforcesRound408Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by vladix on 4/29/17.
 */
public class p02_findTheBone {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = in.readLine().trim().split(" ");
        int numberOfCups = Integer.parseInt(tokens[0]);
        int numberOfHoles = Integer.parseInt(tokens[1]);
        int swappingOperation = Integer.parseInt(tokens[2]);

        String[] holesIndexesStrings = in.readLine().trim().split(" ");
        boolean[] cups = new boolean[numberOfCups + 1];
        for (int i = 0; i < numberOfHoles; i++) {
            int index = Integer.parseInt(holesIndexesStrings[i]);
            cups[index] = true;
        }

        int lastIndex = 1;
        for (int i = 0; i < swappingOperation; i++) {
            String[] tokens1 = in.readLine().trim().split(" ");
            int from = Integer.parseInt(tokens1[0]);
            int to = Integer.parseInt(tokens1[1]);

            if (lastIndex == from || lastIndex == to) {
                if (cups[lastIndex]) {
                    System.out.println(lastIndex);
                    return;
                }

                if (cups[from]) {
                    System.out.println(from);
                    return;
                }

                if (cups[to]) {
                    System.out.println(to);
                    return;
                }

                if (lastIndex == from) {
                    lastIndex = to;
                } else {
                    lastIndex = from;
                }
            }
        }

        System.out.println(lastIndex);
    }
}
