package hackerRank.contests.contest_30DaysOfCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by vladix on 4/28/17.
 */
public class p09_dictionariesAndMaps {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<String, String> valueByKey = new HashMap<>();
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = in.nextLine().split("\\s+");
            String key = tokens[0];
            String value = tokens[1];

            valueByKey.put(key, value);
        }

        while (in.hasNextLine()) {
            String searched = in.nextLine();

            if (!valueByKey.containsKey(searched)) {
                System.out.println("Not found");
            } else {
                System.out.println(String.format("%s=%s", searched, valueByKey.get(searched)));
            }
        }
    }
}
