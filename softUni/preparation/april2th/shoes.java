package softUni.preparation.april2th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class shoes {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());
        for (int i = 0; i < t; i++) {
            TreeMap<Integer, Integer> countByShoeSize = new TreeMap<>();
//            Map<Integer, Integer> memo = new HashMap<>();

            String NM = in.readLine();

            String[] neededSizes = in.readLine().split("\\s+");
            String[] availableSizes = in.readLine().split("\\s+");

            for (int j = 0; j < availableSizes.length; j++) {
                int c = Integer.parseInt(availableSizes[j]);
                if (!countByShoeSize.containsKey(c)) {
                    countByShoeSize.put(c, 1);
                } else {
                    countByShoeSize.put(c, countByShoeSize.get(c) + 1);
                }
            }

            int count = 0;
            for (int j = 0; j < neededSizes.length; j++) {
                int c = Integer.parseInt(neededSizes[j]);

                Integer ceil = countByShoeSize.ceilingKey(c);
                while (ceil != null && countByShoeSize.get(ceil) == 0) {
                    ceil = countByShoeSize.ceilingKey(ceil + 1);
                }

                if (ceil != null && countByShoeSize.get(ceil) > 0) {
                    count++;
                    countByShoeSize.put(ceil, countByShoeSize.get(ceil) - 1);
                }
            }

            System.out.println(count);
        }
    }
}
