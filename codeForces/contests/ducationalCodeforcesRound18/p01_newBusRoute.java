package codeForces.contests.ducationalCodeforcesRound18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class p01_newBusRoute {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        TreeSet<Long> routes = new TreeSet<>();
        String[] input = in.readLine().split("\\s+");

        long count = 0L;

        long minDiff = Long.MAX_VALUE;
        for (int i = 0; i < input.length; i++) {
            long route = Long.parseLong(input[i]);
            routes.add(route);

            Long floor = routes.floor(route - 1);
            Long ceiling = routes.ceiling(route + 1);


            if (floor != null && floor != route) {
                long current = route - floor;

                if (current < minDiff) {
                    minDiff = current;
                    count = 0L;
                }

                if (current == minDiff) {
                    count++;
                }
            }

            if (ceiling != null && ceiling != route) {
                long current = ceiling - route;
                if (current < minDiff) {
                    minDiff = current;
                    count = 0;
                }

                if (current == minDiff) {
                    count++;
                }
            }
        }


        System.out.println(minDiff + " " + count);
    }
}
