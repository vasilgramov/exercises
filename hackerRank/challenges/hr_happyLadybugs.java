package hackerRank.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 8/31/17.
 */
public class hr_happyLadybugs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            String line = in.next();
            char[] ladybugs = new char[27];
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == '_')
                    ladybugs[0]++;
                else
                    ladybugs[line.charAt(j) - 64]++;
            }

            if ((ladybugs[0] >= 1 && allAreTwoOrMore(ladybugs)) ||
                    arePlaced(line))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static boolean arePlaced(String line) {
        if (line.length() == 1 && line.charAt(0) != '_') return false;
        if (line.length() == 2 && line.charAt(0) != line.charAt(1)) return false;

        if (line.charAt(0) != line.charAt(1) ||
                line.charAt(line.length() - 2) != line.charAt(line.length() - 1)) return false;

        for (int i = 1; i < line.length() - 1; i++) {
            if (line.charAt(i) != '_' &&
                    line.charAt(i) != line.charAt(i - 1) &&
                    line.charAt(i) != line.charAt(i + 1)) {
                return false;
            }
        }

        return true;
    }

    private static boolean allAreTwoOrMore(char[] ladybugs) {
        for (int i = 1; i < ladybugs.length; i++) {
            if (ladybugs[i] <= 1 && ladybugs[i] != 0) return false;
        }
        return true;
    }
}
