package hackerRank.challenges;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by vladix on 8/26/17.
 */
public class hr_flatlandSpaceStations1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        TreeSet<Integer> stations = readStations(in, m);
        int maxDistance = getMaxDistance(n, stations);
        System.out.println(maxDistance);
    }

    private static int getMaxDistance(int n, TreeSet<Integer> stations) {
        int max = Integer.MIN_VALUE;
        for (Integer s : stations) {
            int current = Integer.MIN_VALUE;

            Integer f = stations.floor(s - 1);
            Integer c = stations.ceiling(s + 1);

            if (f != null && (s - f) / 2 > current) {
                current = (s - f) / 2;
            }

            if (c != null && (c - s) / 2 > current) {
                current = (c - s) / 2;
            }

            max = current > max ? current : max;
        }

        int f = stations.first();
        int l = stations.last();

        if (f > max) max = f;
        if ((n - 1) - l > max) max = n - 1 - l;

        return max;
    }

    private static TreeSet<Integer> readStations(Scanner in, int m) {
        TreeSet<Integer> stations = new TreeSet<>();
        for (int i = 0; i < m; i++) {
            stations.add(in.nextInt());
        }

        return stations;
    }
}
