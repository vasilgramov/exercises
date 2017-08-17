package softUni.exam;

import java.util.*;

public class graph {

    private static Map<Integer, Set<Integer>> graph;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int vertices = Integer.parseInt(in.nextLine());
        int edges = Integer.parseInt(in.nextLine());

        int start = Integer.parseInt(in.nextLine());

        readGraph(in, edges);

        bfs(start);
    }

    private static class Node {

        int index;
        int depth;

        public Node(int index, int depth) {
            this.index = index;
            this.depth = depth;
        }

        @Override
        public String toString() {
            return this.index + "";
        }
    }

    private static void bfs(int start) {

        Deque<Node> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        q.addLast(new Node(start, 1));

        int counter = 0;

        while (!q.isEmpty()) {
            Node n = q.removeFirst();
            counter++;

            Set<Integer> connections = graph.get(n.index);
            if (connections == null) continue;
            for (Integer c : connections) {

                if (c == start) {
                    System.out.println(n.depth);
                    return;
                }

                if (!visited.contains(c)) {
                    visited.add(c);
                    q.addLast(new Node(c, n.depth + 1));
                }
            }
        }

        System.out.println(counter);
    }

    private static void readGraph(Scanner in, int edges) {
        graph = new HashMap<>();

        for (int i = 0; i < edges; i++) {
            String[] tokens = in.nextLine().split(" ");
            int u = Integer.parseInt(tokens[0]);
            int v = Integer.parseInt(tokens[1]);

            updateGraph(u, v);
        }
    }

    private static void updateGraph(int u, int v) {
        if (!graph.containsKey(u)) {
            Set<Integer> connections = new HashSet<>();
            connections.add(v);

            graph.put(u, connections);
        } else {
            Set<Integer> connections = graph.get(u);
            connections.add(v);

            graph.put(u, connections);
        }
    }
}
