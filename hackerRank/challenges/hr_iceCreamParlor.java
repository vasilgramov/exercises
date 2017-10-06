package hackerRank.challenges;

import java.util.*;

/**
 * Created by vladix on 10/6/17.
 */
public class hr_iceCreamParlor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int m = in.nextInt();
            int n = in.nextInt();

            Map<Integer, List<Integer>> idByPrice = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int price = in.nextInt();

                if (!idByPrice.containsKey(price)) {
                    List<Integer> ids = new ArrayList<>();
                    ids.add(j + 1);
                    idByPrice.put(price, ids);
                } else {
                    List<Integer> ids = idByPrice.get(price);
                    ids.add(j + 1);
                    idByPrice.put(price, ids);
                }
            }

            for (Map.Entry<Integer, List<Integer>> kvp : idByPrice.entrySet()) {
                int key = kvp.getKey();
                List<Integer> val = kvp.getValue();

                int remainder = m - key;
                List<Integer> ids = idByPrice.get(remainder);
                if (ids != null) {
                    if (val == ids) {
                        int id1 = Math.min(val.get(0), ids.get(1));
                        int id2 = Math.max(val.get(0), ids.get(1));
                        System.out.println(id1 + " " + id2);
                    } else {
                        int id1 = Math.min(val.get(0), ids.get(0));
                        int id2 = Math.max(val.get(0), ids.get(0));
                        System.out.println(id1 + " " + id2);
                    }
                    break;
                }
            }
        }
    }
}
