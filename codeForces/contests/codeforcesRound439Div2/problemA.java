package codeForces.contests.codeforcesRound439Div2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by vladix on 10/8/17.
 */
public class problemA {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();

        for (int i = 0; i < n; i++) {
            a.add(in.nextInt());
        }

        for (int i = 0; i < n; i++) {
            b.add(in.nextInt());
        }

        int count = 0;
        for (Integer aN : a) {
            for (Integer bN : b) {
                int result = aN ^ bN;

                if (a.contains(result) || b.contains(result)) count++;
            }
        }

        if (count % 2 == 0) System.out.println("Karen");
        else System.out.println("Koyomi");
    }
}
