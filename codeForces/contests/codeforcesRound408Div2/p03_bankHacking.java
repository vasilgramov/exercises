package codeForces.contests.codeforcesRound408Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by vladix on 4/29/17.
 */
public class p03_bankHacking {
    private static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        visited = new boolean[n + 1];
        String[] bankStrengths = in.readLine().split(" ");

        Node strongestBank = null;
        Node[] graph = new Node[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new Node(i, Long.parseLong(bankStrengths[i]));
            if (strongestBank == null ||
                    graph[i].compareTo(strongestBank) > 0) {
                strongestBank = graph[i];
            }
        }

        for (int i = 0; i < n - 1; i++) {
            String[] tokens = in.readLine().split(" ");
            int u = Integer.parseInt(tokens[0]) - 1;
            int v = Integer.parseInt(tokens[1]) - 1;

            Node uNode = graph[u];
            Node vNode = graph[v];

            uNode.neighbors.add(vNode);
            vNode.neighbors.add(uNode);
        }

        long minStrength = strongestBank.strength;
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enqueue(strongestBank);
        while (priorityQueue.size() > 0) {
            Node bank = priorityQueue.extractMax();
            visited[bank.index] = true;

            for (Node neighbor : bank.neighbors) {
                neighbor.strength++;
                if (priorityQueue.contains(neighbor)) {
                    priorityQueue.decreaseKey(neighbor);
                } else {
                    priorityQueue.enqueue(neighbor);
                }

                for (Node semi_neighbor : neighbor.neighbors) {
                    if (semi_neighbor != bank) {
                        semi_neighbor.strength++;
                        if (priorityQueue.contains(semi_neighbor)) {
                            priorityQueue.decreaseKey(semi_neighbor);
                        }
                    }
                }
            }

            if (bank.strength > minStrength) {
                minStrength = strongestBank.strength;
            }
        }

        System.out.println(minStrength);
    }

    private static class Node implements Comparable<Node> {
        private int index;
        private long strength;
        private List<Node> neighbors;

        public Node(int index, long strength) {
            this.index = index;
            this.strength = strength;
            this.neighbors = new ArrayList<>();
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

    private static class PriorityQueue {
        private Map<Node, Integer> searchCollection;
        private List<Node> heap;

        public PriorityQueue() {
            this.heap = new ArrayList<>();
            this.searchCollection = new HashMap<>();
        }

        public int size() {
            return this.heap.size();
        }

        public Node extractMax() {
            Node max = this.heap.get(0);
            Node last = this.heap.get(this.heap.size() - 1);
            this.searchCollection.put(last, 0);
            this.heap.set(0, last);
            this.heap.remove(this.heap.size() - 1);
            if (this.heap.size() > 0) {
                this.heapifyDown(0);
            }

            this.searchCollection.remove(max);

            return max;
        }

        public Node peekMax() {
            return this.heap.get(0);
        }

        public boolean contains(Node element) {
            return this.searchCollection.containsKey(element);
        }

        public void enqueue(Node element) {
            if (visited[element.index]) {
                return;
            }

            this.searchCollection.put(element, this.heap.size());
            this.heap.add(element);
            this.heapifyUp(this.heap.size() - 1);
        }

        public void decreaseKey(Node element) {
            int index = this.searchCollection.get(element);
            this.heapifyUp(index);
        }

        private void heapifyDown(int i) {
            int left = (2 * i) + 1;
            int right = (2 * i) + 2;
            int biggest = i;

            if (left < this.heap.size() && this.heap.get(left).compareTo(this.heap.get(biggest)) > 0) {
                biggest = left;
            }

            if (right < this.heap.size() && this.heap.get(right).compareTo(this.heap.get(biggest)) > 0) {
                biggest = right;
            }

            if (biggest != i) {
                Node old = this.heap.get(i);
                this.searchCollection.put(old, biggest);
                this.searchCollection.put(this.heap.get(biggest), i);
                this.heap.set(i, this.heap.get(biggest));
                this.heap.set(biggest, old);
                this.heapifyDown(biggest);
            }
        }

        private void heapifyUp(int i) {
            int parent = (i - 1) / 2;
            while (i > 0 && this.heap.get(i).compareTo(this.heap.get(parent)) > 0) {
                Node old = this.heap.get(i);
                this.searchCollection.put(old, parent);
                this.searchCollection.put(this.heap.get(parent), i);
                this.heap.set(i, this.heap.get(parent));
                this.heap.set(parent, old);

                i = parent;
                parent = (i - 1) / 2;
            }
        }
    }
}
