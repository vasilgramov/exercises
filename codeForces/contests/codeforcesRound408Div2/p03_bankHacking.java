package codeForces.contests.codeforcesRound408Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by vladix on 4/29/17.
 */
public class p03_bankHacking {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        String[] bankStrengths = in.readLine().split(" ");

        Node strongestBank = null;
        Node[] banks = new Node[n];
        for (int i = 0; i < n; i++) {
            banks[i] = new Node(Integer.parseInt(bankStrengths[i]));
            if (strongestBank == null ||
                    banks[i].compareTo(strongestBank) > 0) {
                strongestBank = banks[i];
            }
        }

        for (int i = 0; i < n - 1; i++) {
            String[] tokens = in.readLine().split(" ");
            int u = Integer.parseInt(tokens[0]) - 1;
            int v = Integer.parseInt(tokens[1]) - 1;

            Node uNode = banks[u];
            Node vNode = banks[v];

            uNode.neighbors.add(vNode);
            vNode.neighbors.add(uNode);
        }

        long minStrength = strongestBank.strength;
        int count = 0;
        while (count < n) {
            for (Node neighbor : strongestBank.neighbors) {
                neighbor.strength++;
                for (Node node : neighbor.neighbors) {
                    node.strength++;
                }
            }

            Node node = strongestBank.neighbors.pollLast();
            node.neighbors.remove(strongestBank);
            strongestBank = node;
            if (strongestBank.strength > minStrength) {
                minStrength = strongestBank.strength;
            }

            count++;
        }

        System.out.println(minStrength);
    }

    private static class Node implements Comparable<Node> {
        private long strength;
        private TreeSet<Node> neighbors;

        public Node(long strength) {
            this.strength = strength;
            this.neighbors = new TreeSet<>();
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.strength, o.strength);
        }

        @Override
        public String toString() {
            return strength + "";
        }
    }
}
