package hackerRank.challenges;

import java.util.*;

/**
 * Created by vladix on 5/2/17.
 */
public class hr_synchronousShopping {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numberOfShoppingCenters = in.nextInt();
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
            int uIndex = in.nextInt();
            int vIndex = in.nextInt();
            int weight = in.nextInt();

            Shop uShop = shops[uIndex];
            Shop vShop = shops[vIndex];

            uShop.connections.add(vIndex);
            vShop.connections.add(uIndex);
        }


        Set<Integer> takenFish = new HashSet<>();
        int bigCatTime = 0;


    }

    private static class Shop {
        private int index;
        private Set<Integer> sellingFishTypes;

        List<Integer> connections;

        public Shop(int index, Set<Integer> sellingFishTypes) {
            this.index = index;
            this.sellingFishTypes = sellingFishTypes;

            this.connections = new ArrayList<>();
        }


    }

    public static class PriorityQueue<T extends Comparable<T>> {
        private Map<T, Integer> searchCollection;
        private List<T> heap;

        public PriorityQueue() {
            this.heap = new ArrayList<>();
            this.searchCollection = new HashMap<T, Integer>();
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
