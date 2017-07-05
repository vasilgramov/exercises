package hackerRank.challenges;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by vladix on 7/5/17.
 */
public class hr_sherlockAndPlanes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            Set<Integer> x = new HashSet<>();
            Set<Integer> y = new HashSet<>();
            Set<Integer> z = new HashSet<>();

            for (int j = 0; j < 4; j++) {
                x.add(in.nextInt());
                y.add(in.nextInt());
                z.add(in.nextInt());
            }

            if (x.size() == 1 || y.size() == 1 || z.size() == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
