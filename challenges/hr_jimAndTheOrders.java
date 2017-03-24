package hackerRank.challenges;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class hr_jimAndTheOrders {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        Map<Integer, Long> valueByIndex = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] line = in.nextLine().split("\\s+");
            int s = Integer.parseInt(line[0]);
            int e = Integer.parseInt(line[1]);
            long k = s + e;
            valueByIndex.put(i, k);
        }

        valueByIndex.entrySet().stream()
                .sorted(Comparator.comparingLong(Map.Entry::getValue))
                .forEach(e -> {
                    System.out.print(e.getKey() + 1 + " ");
                });
    }
}
