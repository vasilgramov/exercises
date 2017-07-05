package hackerRank.contests.contest_hourRank22;

import java.util.*;

/**
 * Created by vladix on 7/2/17.
 */
public class p02 {

    private static final long INFINITY = Long.MAX_VALUE - 2017;

    private static Map<Integer, Node> graph = new HashMap<>();
    private static long[][] memo;
    private static long[][] bestPathToCell;

    private long sum = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        bestPathToCell = new long[n][n];
        memo = new long[n][n];

        for (int i = 0; i < m; i++) {
            int v = in.nextInt();
            int k = in.nextInt();
            int w = in.nextInt();

            memo[k - 1][v - 1] = w;
            memo[v - 1][k - 1] = w;

            Node vNode = new Node(v, k, 0);
            Node kNode = new Node(k, v, 0);

            updateGraph(v, vNode, kNode);
            updateGraph(k, kNode, vNode);
        }

        System.out.println();

        System.out.println();
    }

    private static void updateGraph(int v, Node from, Node to) {
        if (!graph.containsKey(v)) {
            from.connections.add(to);
            graph.put(v, from);
        } else {
            Node node = graph.get(v);
            node.connections.add(to);

            graph.put(v, node);
        }
    }

    private static void dijkstra() {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();


        for (int row = 0; row < bestPathToCell.length; row++) {
            for (int col = 0; col < bestPathToCell[row].length; col++) {
                bestPathToCell[row][col] = INFINITY;
            }
        }

        Node node = graph.get(1);
        for (Node currentNode : node.connections) {
            node.setValue(node.getValue() + memo[node.from - 1][node.to - 1]);
            priorityQueue.enqueue(node);
            bestPathToCell[node.from - 1][node.to - 1] = node.getValue();
        }

        while (priorityQueue.size() > 0) {
//            Node node = priorityQueue.extractMin();

//            if (cell.getFrom() == rows - 1 && cell.getTo() == cols - 1) {
//                endCell = cell;
//                break;
//            }

//            List<Node> neighbors = graph.get(cell);
//            for (Node neighbor : neighbors) {
//                int distanceToCurrent = neighbor.getValue() + cell.getValue();
//
//                if (bestPathToCell[neighbor.getFrom()][neighbor.getTo()] > distanceToCurrent) {
//                    neighbor.setValue(distanceToCurrent);
//                    neighbor.setPreviousCell(cell);
//
//                    bestPathToCell[neighbor.getFrom()][neighbor.getTo()] = distanceToCurrent;
//
//                    if (priorityQueue.contains(neighbor)) {
//                        priorityQueue.decreaseKey(neighbor);
//                    } else {
//                        priorityQueue.enqueue(neighbor);
//                    }
//                }
//            }
        }
    }

    private static class Node implements Comparable<Node> {
        private int from;
        private int to;
        private long value;

        public List<Node> connections;

        private Node previousCell;

        public Node(int row, int col, long value) {
            this.setFrom(row);
            this.setTo(col);
            this.setValue(value);

            this.connections = new ArrayList<>();
        }

        public int getFrom() {
            return this.from;
        }

        private void setFrom(int from) {
            this.from = from;
        }

        public int getTo() {
            return this.to;
        }

        private void setTo(int to) {
            this.to = to;
        }

        public long getValue() {
            return this.value;
        }

        private void setValue(long value) {
            this.value = value;
        }

        public void setPreviousCell(Node cell) {
            this.previousCell = cell;
        }

        @Override
        public boolean equals(Object obj) {
            Node node = (Node) obj;

            return this.getFrom() == node.getFrom() && this.getTo() == node.getTo();
        }

        @Override
        public int hashCode() {
            String hash = this.getFrom() + "" + this.getTo();
            return hash.hashCode();
        }

        @Override
        public int compareTo(Node other) {
            return Long.compare(this.getValue(), other.getValue());
        }

        @Override
        public String toString() {
            return String.format("%d %d", this.getFrom(), this.getTo());
        }
    }

    private static class PriorityQueue<T extends Comparable<T>> {
        private Map<T, Integer> searchCollection;
        private List<T> heap;


        public PriorityQueue() {
            this.heap = new ArrayList<>();
            this.searchCollection = new HashMap<T, Integer>();
        }

        public int size() {
            return this.heap.size();
        }

        public T extractMin() {
            T min = this.heap.get(0);
            T last = this.heap.get(this.heap.size() - 1);
            this.searchCollection.put(last, 0);
            this.heap.set(0, last);
            this.heap.remove(this.heap.size() - 1);
            if (this.heap.size() > 0) {
                this.heapifyDown(0);
            }

            this.searchCollection.remove(min);

            return min;
        }

        public T peekMin() {
            return this.heap.get(0);
        }

        public boolean contains(T element) {
            return this.searchCollection.containsKey(element);
        }

        public void enqueue(T element) {
            this.searchCollection.put(element, this.heap.size());
            this.heap.add(element);
            this.heapifyUp(this.heap.size() - 1);
        }

        private void heapifyDown(int i) {
            int left = (2 * i) + 1;
            int right = (2 * i) + 2;
            int smallest = i;

            if (left < this.heap.size() && this.heap.get(left).compareTo(this.heap.get(smallest)) < 0) {
                smallest = left;
            }

            if (right < this.heap.size() && this.heap.get(right).compareTo(this.heap.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest != i) {
                T old = this.heap.get(i);
                this.searchCollection.put(old, smallest);
                this.searchCollection.put(this.heap.get(smallest), i);
                this.heap.set(i, this.heap.get(smallest));
                this.heap.set(smallest, old);
                this.heapifyDown(smallest);
            }
        }

        private void heapifyUp(int i) {
            int parent = (i - 1) / 2;
            while (i > 0 && this.heap.get(i).compareTo(this.heap.get(parent)) < 0) {
                T old = this.heap.get(i);
                this.searchCollection.put(old, parent);
                this.searchCollection.put(this.heap.get(parent), i);
                this.heap.set(i, this.heap.get(parent));
                this.heap.set(parent, old);

                i = parent;
                parent = (i - 1) / 2;
            }
        }

        public void decreaseKey(T element)
        {
            int index = this.searchCollection.get(element);
            this.heapifyUp(index);
        }
    }
}
