package hackerRank.contests.contest_weekOfCode31;

import java.util.*;

public class p04_spanningTreeFraction {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Edge> edges = new ArrayList<>();

        int n = in.nextInt();
        int m = in.nextInt();
        for(int a0 = 0; a0 < m; a0++){
            int u = in.nextInt();
            int w = in.nextInt();
            int p = in.nextInt();
            int q = in.nextInt();

            edges.add(new Edge(u, w, p, q));
        }

//        System.out.println(Integer.compare(1, 10));
        System.out.println(kruskalAlgorithm(n, edges));
    }

    private static String kruskalAlgorithm(int numberOfVertices, List<Edge> graphEdges) {
        int p = 0;
        int q = 0;

        Collections.sort(graphEdges);

        int[] parent = new int[numberOfVertices];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = graphEdges.size() - 1; i >= 0; i--) {
            int startNode = graphEdges.get(i).startNode;
            int endNode = graphEdges.get(i).endNode;

            int rootStartNode = findParent(startNode, parent);
            int rootEndNode = findParent(endNode, parent);

            if (rootStartNode != rootEndNode) {
                p += graphEdges.get(i).weightP;
                q += graphEdges.get(i).weightQ;

                int realParent = rootStartNode;
                if (endNode != rootEndNode) {
                    realParent = rootEndNode;
                }

                parent[startNode] = realParent;
                parent[endNode] = realParent;
            }
        }

        return asFraction(p, q);
    }

    private static String asFraction(long a, long b) {
        long gcm = gcm(a, b);
        return (a / gcm) + "/" + (b / gcm);
    }

    private static long gcm(long a, long b) {
        return b == 0 ? a : gcm(b, a % b); // Not bad for one line of code :)
    }


    private static int findParent(int node, int[] parent) {
        int root = node;

        while (root != parent[root]) {
            root = parent[root];
        }

        return root;
    }

    static class Edge implements Comparable<Edge> {
        private int startNode;
        private int endNode;
        private int weightP;
        private int weightQ;

        private double weight;

        public Edge(int startNode, int endNode, int weightP, int weightQ) {
           this.startNode = startNode;
           this.endNode = endNode;
           this.weightP = weightP;
           this.weightQ = weightQ;

           this.weight = (double)weightP / (double)weightQ;
        }

        @Override
        public int compareTo(Edge other) {
            if (this.weightP == this.weightQ && other.weightP < other.weightQ) {
                return 1;
            } else if (other.weightQ == other.weightP && this.weightP < this.weightQ) {
                return -1;
            } else if (this.weight > other.weight) {
                return 1;
            } else if (this.weight < other.weight) {
                return -1;
            }

            return Integer.compare(this.weightP + this.weightQ, other.weightP + other.weightQ);
        }

//        @Override
//        public int hashCode() {
//            return String.format("%d%d%d%d", this.startNode, this.endNode, this.weightP, this.weightP).hashCode();
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            Edge edge = (Edge) obj;
//            return this.hashCode() == edge.hashCode();
//        }
//
//        @Override
//        public String toString() {
//            return String.format("(%d %d) -> %d", this.getStartNode(), this.getEndNode(), this.getWeight());
//        }
    }
}
