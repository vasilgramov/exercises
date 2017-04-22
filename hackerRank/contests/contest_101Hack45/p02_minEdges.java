package hackerRank.contests.contest_101Hack45;

import java.util.Scanner;

public class p02_minEdges {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int graphs = in.nextInt();
        int layers = in.nextInt();

        if (layers > graphs || (graphs > 2 && layers == 2)) {
            System.out.println(-1);
            return;
        }

        int toBeConnected = (graphs - 2);
        int min = toBeConnected / (layers - 2);

        int edges = 2 * min;
        edges += min * (layers - 3);

        System.out.println(edges);
    }
}
