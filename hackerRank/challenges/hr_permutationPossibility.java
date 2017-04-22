package hackerRank.challenges;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by vladix on 4/20/17.
 */
public class hr_permutationPossibility {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Set<Integer> sequence = new HashSet<>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            if (sequence.contains(num)) {
                System.out.println("NO");
                return;
            } else {
                sequence.add(num);
            }
        }

        System.out.println("YES");
    }
}
