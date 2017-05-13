package hackerRank.contests.contest_weekOfCode27;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by vladix on 5/13/17.
 */
public class p02_tailorShop {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int priceForOne = in.nextInt();

        TreeSet<Integer> used = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int desired = in.nextInt();

            int price = (desired / priceForOne) + 1;
            if (!used.contains(price)) {
                used.add(price);
            } else {
                Integer ceiling = used.ceiling(price);
                if (ceiling == null) {
                    used.add(price + 1);
                } else {
                    while (ceiling != null && ceiling - 1 <= price) {
                        price = ceiling;
                        ceiling = used.ceiling(ceiling + 1);
                    }
                    
                    used.add(price);
                }
            }
        }


    }
}
