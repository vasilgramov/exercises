package softUni.exam;

import java.util.*;

public class graphv1 {

    private static Set<Integer> visited = new HashSet<>();
    private static Map<Integer, Node> graph = new HashMap<>();

    private static int max = Integer.MIN_VALUE;
    private static int sum = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int vertices = in.nextInt();
        int connections = in.nextInt();
        int startingPoint = in.nextInt();

        readGraph(in, connections);

        Node root = graph.get(startingPoint);
        traverseGraph(root);

        visited = new HashSet<>();
        List<Edge> edges = getRemovedEdges();

        splitGraph(edges);

        visited = new HashSet<>();
        getMaxComponentSum();

        System.out.println(max);
    }

    private static void getMaxComponentSum() {
        for (Map.Entry<Integer, Node> kvp : graph.entrySet()) {

            sum = 0;
            dfs(kvp.getKey());

            if (sum > max) max = sum;
        }
    }

    private static void readGraph(Scanner in, int connections) {
        for (int i = 0; i < connections; i++) {
            int u = in.nextInt();
            int v = in.nextInt();

            updateGraph(graph, u, v);
            updateGraph(graph, v, u);
        }
    }

    private static void splitGraph(List<Edge> edges) {
        for (Edge edge : edges) {
            graph.get(edge.u).connections.remove((Object) edge.v);
            graph.get(edge.v).connections.remove((Object) edge.u);
        }
    }

    private static List<Edge> getRemovedEdges() {
        List<Edge> edges = new ArrayList<>();
        for (Node node : graph.values()) {
            visited.add(node.index);
            List<Integer> children = node.connections;

            for (Integer child : children) {
                Node childNode = graph.get(child);

                if (childNode.numberOfChildren % 2 == 0 && !visited.contains(childNode.index)) {
                    node.numberOfChildren -= childNode.numberOfChildren;

                    edges.add(new Edge(childNode.index, node.index));

                    visited.add(childNode.index);
                }
            }
        }
        return edges;
    }

    private static void dfs(int idx) {
        if (visited.contains(idx)) return;

        visited.add(idx);

        Node node = graph.get(idx);
        sum += node.index;

        List<Integer> connections = node.connections;
        for (Integer c : connections) {
            dfs(c);
        }
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

    private static class Edge {
        private int u;
        private int v;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }

        @Override
        public String toString() {
            return this.u + " " + this.v;
        }
    }

    private static class Node {
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