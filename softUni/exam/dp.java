package softUni.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by vladix on 9/19/17.
 */
public class dp {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int fuel = Integer.parseInt(in.nextLine());
        List<Item> items = new ArrayList<>();

        int count = 1;
        while (true) {
            String line = in.nextLine();
            if (line.equals("End")) break;

            String[] tokens = line.split(", ");
            String name = tokens[0];
            int carDmg = Integer.parseInt(tokens[1]);
            int pokemonsCount = Integer.parseInt(tokens[2]);
            int length = Integer.parseInt(tokens[3]);

            int price = pokemonsCount * 10 - carDmg;
            Item item = new Item(count++, name, carDmg, pokemonsCount, length, price);
            items.add(item);
        }

        List<Item> itemsTaken = fillKnapsack(fuel, items);
        Collections.sort(itemsTaken);

        List<String> toPrint = new ArrayList<>();
        int totalPokemonsCount = 0;
        int carDgm = 0;
        int fuelCost = 0;
        for (Item item : itemsTaken) {
            toPrint.add(item.toString());
            totalPokemonsCount += item.pokemon;
            carDgm += item.carDmg;
            fuelCost += item.weight;
        }

        System.out.println(String.join(" -> ", toPrint));
        System.out.println("Total pokemons caught -> " + totalPokemonsCount);
        System.out.println("Total car damage -> " + carDgm);
        System.out.println("Fuel Left -> " + (fuel - fuelCost));
    }

    private static List<Item> fillKnapsack(int knapsackCapacity, List<Item> items) {
        int[][] maxPrices = new int[items.size()][knapsackCapacity + 1];
        boolean[][] isTaken = new boolean[items.size()][knapsackCapacity + 1];

        for (int c = 0; c < knapsackCapacity + 1; c++) {
            if (items.get(0).weight <= c) {
                maxPrices[0][c] = items.get(0).price;
                isTaken[0][c] = true;
            }
        }

        for (int i = 1; i < items.size(); i++) {
            for (int c = 0; c < knapsackCapacity + 1; c++) {
                Item currentItem = items.get(i);
                int price = currentItem.price;
                int weight = currentItem.weight;

                maxPrices[i][c] = maxPrices[i - 1][c];

                if (weight <= c &&
                        maxPrices[i - 1][c - weight] + price > maxPrices[i - 1][c]) {
                    maxPrices[i][c] = maxPrices[i - 1][c - weight] + price;
                    isTaken[i][c] = true;
                }
            }
        }

        List<Item> itemsTaken = new ArrayList<>();
        int row = items.size() - 1;
        int col = knapsackCapacity;
        while (row >= 0) {
            if (isTaken[row][col]) {
                itemsTaken.add(items.get(row));
                col -= items.get(row).weight;
            }

            row--;
        }

        return itemsTaken;
    }

    public static class Item implements Comparable<Item> {

        private int id;
        private String name;
        private int carDmg;
        private int pokemon;
        private int weight;
        private int price;

        public Item(int id, String name, int carDmg, int pokemon, int weight, int price) {
            this.id = id;
            this.name = name;
            this.carDmg = carDmg;
            this.pokemon = pokemon;
            this.weight = weight;
            this.price = price;
        }

        @Override
        public String toString() {
            return this.name;
        }

        @Override
        public int compareTo(Item other) {
            return Integer.compare(this.id, other.id);
        }
    }
}
