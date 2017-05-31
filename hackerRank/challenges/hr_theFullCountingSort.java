package hackerRank.challenges;

import java.util.*;

public class hr_theFullCountingSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<Integer, List<String>> input = new TreeMap<>();

        int n = in.nextInt();

        readInput(in, input, n);

        StringBuilder builder = getOutput(input);
        System.out.println(builder);
    }

    private static void readInput(Scanner in, Map<Integer, List<String>> input, int n) {
        for (int i = 0; i < n; i++) {
            int key = in.nextInt();
            String value = in.next();
            if (i < n / 2) {
                value = "-";
            }
            updateInput(input, key, value);
        }
    }

    private static StringBuilder getOutput(Map<Integer, List<String>> input) {
        StringBuilder builder = new StringBuilder();
        for (List<String> strings : input.values()) {
            for (String string : strings) {
                builder.append(string).append(" ");
            }
        }
        return builder;
    }

    private static void updateInput(Map<Integer, List<String>> input, int key, String value) {
        if (!input.containsKey(key)) {
            List<String> values = new ArrayList<>();
            values.add(value);
            input.put(key, values);
        } else {
            List<String> values = input.get(key);
            values.add(value);
            input.put(key, values);
        }
    }
}
