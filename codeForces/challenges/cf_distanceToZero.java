package codeForces.challenges;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by vladix on 5/6/17.
 */
public class cf_distanceToZero {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        TreeSet<Integer> zeroIndeces = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            long num = in.nextLong();
            if (num == 0) {
                zeroIndeces.add(i);
            }
        }


        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            Integer floor = zeroIndeces.floor(i);
            Integer ceiling = zeroIndeces.ceiling(i);

            if (floor != null && ceiling != null) {
                int distanceFloor = Math.abs(i - floor);
                int distanceCeil = Math.abs(i - ceiling);

                if (distanceFloor < distanceCeil) {
                    builder.append(distanceFloor + " ");
                } else {
                    builder.append(distanceCeil +  " ");
                }
            } else if (floor == null) {
                int distanceCeil = Math.abs(i - ceiling);
                builder.append(distanceCeil + " ");
            } else if (ceiling == null) {
                int distanceFloor = Math.abs(i - floor);
                builder.append(distanceFloor + " ");
            }
        }

        System.out.println(builder);
    }
}
