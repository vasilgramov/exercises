package hackerRank.challenges;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by vladix on 8/30/17.
 */
public class hr_beautifulTriplets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int d = in.nextInt();

        Set<Integer> numbers = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            numbers.add(in.nextInt());
        }

        int count = 0;
        for (Integer number : numbers) {
            if (numbers.contains(number + d) && numbers.contains(number + 2 * d)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
