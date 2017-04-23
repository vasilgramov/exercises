package codeForces.contests.codeforcesRound410Div2;

import java.util.Scanner;

/**
 * Created by vladix on 4/22/17.
 */
public class p02_mikeAndStrings {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        String[] strings = new String[n];
        int[] neededRotations = new int[n];

        strings[0] = in.nextLine();
        for (int i = 1; i < n; i++) {
            String s = in.nextLine();
            if (isRotation(s, strings[0])) {
                strings[i] = s;
            } else {
                System.out.println(-1);
                return;
            }
        }

        for (int i = 0; i < n; i++) {
            String toCheck = strings[i];
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    String current = strings[j] + strings[j];
                    int rotations = current.indexOf(toCheck);
                    neededRotations[i] += rotations;
                }
            }
        }

        int min = neededRotations[0];
        for (int i = 1; i < neededRotations.length; i++) {
            if (neededRotations[i] < min) {
                min = neededRotations[i];
            }
        }

        System.out.println(min);

    }

    private static boolean isRotation(String s1,String s2) {
        return (s1.length() == s2.length()) && ((s1 + s1).contains(s2));
    }
}
