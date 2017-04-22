package hackerRank.contests.contest_rookieRank2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<Integer, Integer> countByBird = new HashMap<>();
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            int currentBird = in.nextInt();
            if (!countByBird.containsKey(currentBird)) {
                countByBird.put(currentBird, 0);
            }

            countByBird.put(currentBird, countByBird.get(currentBird) + 1);
        }

        countByBird.entrySet().stream()
                .sorted((b1, b2) -> Integer.compare(b2.getValue(), b1.getValue()))
                .limit(1)
                .forEach(b -> System.out.println(b.getKey()));
    }
}
