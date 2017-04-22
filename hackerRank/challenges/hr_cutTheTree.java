package hackerRank.challenges;

import java.util.*;

// https://www.hackerrank.com/challenges/cut-the-tree?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
public class hr_cutTheTree {


    private static int totalSum = 0;
    private static int[] values;
    private static Set<Integer> leafNodes = new HashSet<>();
    private static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        String[] valuesAsString = in.nextLine().split("\\s+");
        values = new int[valuesAsString.length];
        for (int i = 0; i < valuesAsString.length; i++) {
            int currentValue = Integer.parseInt(valuesAsString[i]);
            totalSum += currentValue;
            values[i] = currentValue;
        }

        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n - 1; i++) {
            int[] nodes = stringsToIntegers(in.nextLine().split("\\s+"));
            int firstNode = nodes[0] - 1;
            int secondNode = nodes[1] - 1;

            updateGraph(graph, firstNode, secondNode);
            updateGraph(graph, secondNode, firstNode);
        }

        for (Integer leafNode : leafNodes) {
            int currentDifference = totalSum - values[leafNode];

            if (currentDifference < minDifference) {
                minDifference = currentDifference;
                if (minDifference == 0) {
                    System.out.println(0);
                    return;
                }
            }
        }

        int leafNode = leafNodes.iterator().next();
        int currentSum = leafNode;
        int node = graph[leafNode].get(0);
        currentSum += values[node];

        List<Integer> notLeafNodeConnections = graph[node];
        for (Integer child : notLeafNodeConnections) {
            if (child != leafNode) {
                currentSum += values[child];
            }
        }

        for (int i = 0; i < n - 1 - leafNodes.size(); i++) {

        }
    }

    private static void updateGraph(List<Integer>[] graph, int firstNode, int secondNode) {
        if (graph[firstNode] == null) {
            leafNodes.add(firstNode);

            graph[firstNode] = new ArrayList<>();
            graph[firstNode].add(secondNode);
        } else {
            leafNodes.remove(firstNode);

            graph[firstNode].add(secondNode);
        }
    }

    private static int[] stringsToIntegers(String[] numbersAsString) {
        int[] parsedNumbers = new int[numbersAsString.length];

        for (int i = 0; i < numbersAsString.length; i++) {
            parsedNumbers[i] = Integer.parseInt(numbersAsString[i]);
        }


        return parsedNumbers;
    }
}

/*
package hackerRank.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/cut-the-tree?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
public class hr_cutTheTree {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        String[] valuesAsString = in.nextLine().split("\\s+");

        int total = 0;
        int[] values = new int[valuesAsString.length];
        for (int i = 0; i < valuesAsString.length; i++) {
            int currentValue = Integer.parseInt(valuesAsString[i]);
            values[i] = currentValue;
            total += currentValue;
        }

        int[][] edges = new int[n - 1][2];

        List<Integer>[] graph = new List[n];
        for (int i = 1; i < n; i++) {
            String[] tokens = in.nextLine().split("\\s+");
            int firstNode = Integer.parseInt(tokens[0]) - 1;
            int secondNode = Integer.parseInt(tokens[1]) - 1;

            List<Integer> firstNodeConnections = graph[firstNode];
            if (firstNodeConnections == null) {
                firstNodeConnections = new ArrayList<>();
            }
            firstNodeConnections.add(secondNode);
            graph[firstNode] = firstNodeConnections;

            List<Integer> secondNodeConnections = graph[secondNode];
            if (secondNodeConnections == null) {
                secondNodeConnections = new ArrayList<>();
            }
            secondNodeConnections.add(firstNode);
            graph[secondNode] = secondNodeConnections;

            edges[i - 1][0] = firstNode;
            edges[i - 1][1] = secondNode;
        }


        int minDifference = Integer.MAX_VALUE;

        for (int i = 0; i < edges.length; i++) {
            int firstNode = edges[i][0];
            int secondNode = edges[i][1];

            int sum = 0;
            if (graph[firstNode].size() < graph[secondNode].size()) {
                sum += values[firstNode];

                for (Integer node : graph[firstNode]) {
                    if (node != secondNode) {
                        sum += values[node];
                    }
                }
            } else {
                sum += values[secondNode];

                for (Integer node : graph[secondNode]) {
                    if (node != firstNode) {
                        sum += values[node];
                    }
                }
            }

            int currentDifference = Math.abs(total - sum);
            if (currentDifference < minDifference) {
                minDifference = currentDifference;
            }
        }

        System.out.println(minDifference);
    }
}
 */
