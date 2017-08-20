package hackerRank.challenges;

import java.util.*;

/**
 * Created by vladix on 7/27/17.
 */
public class hr_primMST {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int vertices = in.nextInt();
        int edgesCount = in.nextInt();

        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < edgesCount; i++) {
            int uEdge = in.nextInt();
            int vEdge = in.nextInt();
            int weight = in.nextInt();

            Edge u = new Edge(uEdge, vEdge, weight);
            Edge v = new Edge(vEdge, uEdge, weight);

            updateGraph(uEdge, u, graph);
            updateGraph(vEdge, v, graph);
        }

        mstPrim(graph);
    }

    private static void updateGraph(int index, Edge edge, Map<Integer, List<Edge>> graph) {
        if (!graph.containsKey(index)) {
            List<Edge> edges = new ArrayList<>();
            edges.add(edge);
            graph.put(index, edges);
        } else {
            List<Edge> edges = graph.get(index);
            edges.add(edge);
            graph.put(index, edges);
        }
    }

    private static void mstPrim(Map<Integer, List<Edge>> graph) {
        Set<Integer> visited = new HashSet<>();
        TreeSet<Edge> enqueued = new TreeSet<>();

        Map.Entry<Integer, List<Edge>> vertex = graph.entrySet().iterator().next();
        for (Edge edge : vertex.getValue()) {
            if (visited.contains(edge.to)) {
                continue;
            }

            enqueued.add(edge);
        }

        int weight = 0;
        while (!enqueued.isEmpty()) {
            Edge smallestEdge = enqueued.pollFirst();
            if (visited.contains(smallestEdge.to)) {
                continue;
            }
            visited.add(smallestEdge.to);
            visited.add(smallestEdge.from);
            weight += smallestEdge.weight;
            for (Edge edge : graph.get(smallestEdge.to)) {
                if (visited.contains(edge.to)) {
                    continue;
                }

                enqueued.add(edge);
            }
        }

        System.out.println(weight);
    }

    private static class Edge implements Comparable<Edge> {

        private int from;
        private int to;
        private int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }

        @Override
        public String toString() {
            return String.format("%s - %s", this.from, this.to);
        }
    }
}
