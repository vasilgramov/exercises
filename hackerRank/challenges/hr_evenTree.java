package hackerRank.challenges;

import java.util.*;

public class hr_evenTree {

    private static Set<Integer> visited = new HashSet<>();
    private static Map<Integer, Node> graph = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        int vertices = in.nextInt();
        int connections = in.nextInt();

        for (int i = 0; i < connections; i++) {
            int u = in.nextInt();
            int v = in.nextInt();

            updateGraph(graph, u, v);
            updateGraph(graph, v, u);
        }


        Node root = graph.get(1);
        traverseGraph(root);

        visited = new HashSet<>();
        int count = 0;
        for (Node node : graph.values()) {
            visited.add(node.index);
            List<Integer> children = node.connections;
            for (Integer child : children) {
                Node childNode = graph.get(child);

                if (childNode.numberOfChildren % 2 == 0 && !visited.contains(childNode.index)) {
                    node.numberOfChildren -= childNode.numberOfChildren;
                    visited.add(childNode.index);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static void traverseGraph(Node node) {
        visited.add(node.index);

        List<Integer> connections = node.connections;
        if (connections.size() == 1) {
            node.numberOfChildren = 1;
            return;
        }

        for (Integer connection : connections) {
            Node toTraverse = graph.get(connection);
            if (!visited.contains(toTraverse.index)) {
                traverseGraph(toTraverse);
                node.numberOfChildren += toTraverse.numberOfChildren;
            }
        }

        node.numberOfChildren++;
    }

    private static void updateGraph(Map<Integer, Node> nodeByIndex, int u, int v) {
        if (!nodeByIndex.containsKey(u)) {
            Node node = new Node();
            node.index = u;
            node.connections.add(v);
            nodeByIndex.put(u, node);
        } else {
            Node node = nodeByIndex.get(u);
            node.connections.add(v);
        }
    }

    public static class Node {
        private int index;
        private List<Integer> connections;
        private int numberOfChildren;

        public Node() {
            this.connections = new ArrayList<>();
        }

        @Override
        public String toString() {
            return this.index + "";
        }
    }
}
