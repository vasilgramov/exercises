package hackerRank.contests.contest_30DaysOfCode;

import java.util.*;

/**
 * Created by vladix on 5/18/17.
 */
public class p29_regexPatternsDBIntro {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<String> names = new ArrayList<>();

        int t = Integer.parseInt(in.nextLine());
        for (int i = 0; i < t; i++) {
            String[] tokens = in.nextLine().split(" ");
            String name = tokens[0];
            String email = tokens[1];

            if (email.endsWith("@gmail.com")) {
                names.add(name);
            }
        }

        Collections.sort(names);
        for (String name : names) {
            System.out.println(name);
        }
    }
}
