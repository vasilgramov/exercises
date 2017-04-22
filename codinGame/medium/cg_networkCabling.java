package codinGame.medium;

import java.util.*;

public class cg_networkCabling {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int averageY = 0;

        List<Node> nodes = new ArrayList<>();
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            int X = in.nextInt();
            int Y = in.nextInt();

            if (X < minX) {
                minX = X;
            }
            if (X > maxX) {
                maxX = X;
            }

            averageY += Y;

            Node node = new Node(X, Y);
            nodes.add(node);
        }

        averageY /= nodes.size();

        int optimalY = getOptimalY(averageY, nodes);

        long total = maxX - minX;
        for (Node node : nodes) {
            total += Math.abs(optimalY - node.Y);
        }

        System.out.println(total);
    }

    private static int getOptimalY(int averageY, List<Node> nodes) {
        int optimalY = 0;

        int minDifference = Integer.MAX_VALUE;

        for (Node node : nodes) {
            int difference = Math.abs(node.Y - averageY);

            if (difference < minDifference) {
                minDifference = difference;
                optimalY=  node.Y;
            }
        }

        return optimalY;
    }

    static class Node {
        private int X;
        private int Y;

        public Node(int X, int Y) {
            this.X = X;
            this.Y = Y;
        }
    }
}
