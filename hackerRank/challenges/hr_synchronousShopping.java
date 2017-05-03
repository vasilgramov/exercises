package hackerRank.challenges;

import java.util.*;

/**
 * Created by vladix on 5/2/17.
 */
public class hr_synchronousShopping {

//    private static final int INFINITY = Integer.MAX_VALUE / 2 - 2017;
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        int shoppingCentersCount = in.nextInt();
//        int roadsCount = in.nextInt();
//        int fishTypesCount = in.nextInt();
//
//        int[][] distances = new int[shoppingCentersCount][shoppingCentersCount];
//        for (int row = 0; row < shoppingCentersCount; row++) {
//            for (int col = 0; col < shoppingCentersCount; col++) {
//                if (row != col) {
//                    distances[row][col] = INFINITY;
//                }
//            }
//        }
//
//        Shop[] shops = new Shop[shoppingCentersCount];
//
//        for (int i = 0; i < shoppingCentersCount; i++) {
//            int n = in.nextInt();
//            Set<Integer> fishTypes = new HashSet<>();
//            for (int j = 0; j < n; j++) {
//                fishTypes.add(in.nextInt());
//            }
//
//            Shop shop = new Shop(i, fishTypes);
//            shops[i] = shop;
//        }
//
//        for (int i = 0; i < roadsCount; i++) {
//            int u = in.nextInt() - 1;
//            int v = in.nextInt() - 1;
//
//            int weight = in.nextInt();
//            distances[u][v] = weight;
//            distances[v][u] = weight;
//
//            Shop uShop = shops[u];
//            Shop vShop = shops[v];
//
//            uShop.connections.add(vShop);
//            vShop.connections.add(uShop);
//        }
//
//        for (int k = 0; k < shoppingCentersCount; k++) {
//            for (int i = 0; i < shoppingCentersCount; i++) {
//                for (int j = 0; j < shoppingCentersCount; j++) {
//                    if (distances[i][k] + distances[k][j] < distances[i][j])
//                        distances[i][j] = distances[i][k] + distances[k][j];
//                }
//            }
//        }
//
//
//    }
//
//    private static class Shop {
//        private int index;
//        private List<Shop> connections;
//        private Set<Integer> sellingFishTypes;
//
//        private int weight;
//
//        public Shop(int index, Set<Integer> sellingFishTypes) {
//            this.index = index;
//            this.sellingFishTypes = sellingFishTypes;
//
//            this.connections = new ArrayList<>();
//        }
//    }
//
//    private static class Edge {
//        private int u;
//        private int v;
//        private int weight;
//
//
//    }


    private static final int INFINITY = Integer.MAX_VALUE / 2 - 2017;

    private static int numberOfShoppingCenters;

    private static PriorityQueue<Shop> priorityQueue;
    private static int[] bestPathToCell;
    private static int[][] distances;
    private static Shop startShop;

    private static Set<Integer> takenFishes = new HashSet<>();
    private static Set<Integer> visitedShops = new HashSet<>();

    private static int allDistance = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        numberOfShoppingCenters = in.nextInt();
        distances = new int[numberOfShoppingCenters][numberOfShoppingCenters];
        bestPathToCell = new int[numberOfShoppingCenters];

        int numberOfRoads = in.nextInt();
        int numberOfFishTypes = in.nextInt();

        Shop[] shops = new Shop[numberOfShoppingCenters];
        for (int i = 0; i < numberOfShoppingCenters; i++) {
            int n = in.nextInt();
            Set<Integer> sellingFishTypes = new HashSet<>();
            for (int j = 0; j < n; j++) {
                sellingFishTypes.add(in.nextInt());
            }

            Shop shop = new Shop(i, sellingFishTypes);
            shops[i] = shop;
        }

        for (int i = 0; i < numberOfRoads; i++) {
            int uIndex = in.nextInt() - 1;
            int vIndex = in.nextInt() - 1;
            int weight = in.nextInt();

            Shop uShop = shops[uIndex];
            Shop vShop = shops[vIndex];

            if (uIndex == 0) {
                startShop = uShop;
            } else if (vIndex == 0) {
                startShop = vShop;
            }

            distances[uIndex][vIndex] = weight;
            distances[vIndex][uIndex] = weight;

            uShop.connection.add(vShop);
            vShop.connection.add(uShop);
        }


        int bigCatTime = 0;

        dijkstra();
        if (takenFishes.size() == numberOfFishTypes) {
            System.out.println(allDistance);
            return;
        }

        dijkstra();
        System.out.println(allDistance);
    }

    private static void dijkstra() {
        PriorityQueue<Shop> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < bestPathToCell.length; i++) {
            bestPathToCell[i] = INFINITY;
        }

        startShop.weight = 0;
        priorityQueue.enqueue(startShop);
        while (priorityQueue.size() > 0) {
            Shop shop = priorityQueue.extractMin();
            if (shop.index == numberOfShoppingCenters - 1) {
                allDistance = shop.weight;

                while (shop.index != 0) {
                    visitedShops.add(shop.index);
                    takenFishes.addAll(shop.sellingFishTypes);
                    shop = shop.prevShop;
                }

                visitedShops.remove(numberOfShoppingCenters - 1);
                visitedShops.add(shop.index);
                takenFishes.addAll(shop.sellingFishTypes);
                break;
            }

            List<Shop> neighbors = shop.connection;
            for (Shop neighbor : neighbors) {
                int distanceToCurrent = shop.weight + distances[shop.index][neighbor.index];

                if (bestPathToCell[neighbor.index] >= distanceToCurrent &&
                        !visitedShops.contains(neighbor.index)) {
                    neighbor.weight = distanceToCurrent;

                    neighbor.prevShop = shop;

                    bestPathToCell[neighbor.index] = distanceToCurrent;

                    if (priorityQueue.contains(neighbor)) {
                        priorityQueue.decreaseKey(neighbor);
                    } else {
                        priorityQueue.enqueue(neighbor);
                    }
                }
            }
        }
    }

    private static class Shop implements Comparable<Shop> {
        private int index;
        private List<Shop> connection;
        private Set<Integer> sellingFishTypes;
        private int weight;

        private Shop prevShop;

        public Shop(int index, Set<Integer> sellingFishTypes) {
            this.index = index;
            this.sellingFishTypes = sellingFishTypes;

            this.connection = new ArrayList<>();
        }

        @Override
        public int compareTo(Shop o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static class PriorityQueue<T extends Comparable<T>> {
        private Map<T, Integer> searchCollection;
        private List<T> heap;

        public PriorityQueue() {
            this.heap = new ArrayList<>();
            this.searchCollection = new HashMap<>();
        }

        public int size() {
            return this.heap.size();
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

        public void decreaseKey(T element) {
            int index = this.searchCollection.get(element);
            this.heapifyUp(index);
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
    }
}
