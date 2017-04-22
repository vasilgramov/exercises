package codinGame.medium;

import java.util.*;

public class cg_teadsSponsoredContest {

    private static Map<Integer, List<Integer>> connectionsByNode = new HashMap<>();
    private static Set<Integer> visited = new HashSet<>();

    private static Set<Integer> leafNodes = new HashSet<>();

    private static int maxDepth = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] currentNodes = in.nextLine().split("\\s+");

            int firstNode = Integer.parseInt(currentNodes[0]);
            int secondNode = Integer.parseInt(currentNodes[1]);

            update(firstNode, secondNode);
            update(secondNode, firstNode);
        }

        int leafNode = leafNodes.iterator().next();
        dfs(leafNode, 0);

        if (maxDepth % 2 == 1) {
            maxDepth++;
        }

        System.out.println(maxDepth / 2);
    }

    private static void dfs(int node, int depth) {
        if (!visited.contains(node)) {
            if (depth > maxDepth) {
                maxDepth = depth;
            }

            visited.add(node);

            List<Integer> children = connectionsByNode.get(node);
            for (Integer child : children) {
                dfs(child, depth + 1);
            }
        }
    }


    private static void update(int firstNode, int secondNode) {
        if (!connectionsByNode.containsKey(firstNode)) {
            leafNodes.add(firstNode);

            List<Integer> connections = new ArrayList<>();
            connections.add(secondNode);

            connectionsByNode.put(firstNode, connections);
        } else {
            if (leafNodes.contains(firstNode)) {
                leafNodes.remove(firstNode);
            }

            List<Integer> connections = connectionsByNode.get(firstNode);
            connections.add(secondNode);

            connectionsByNode.put(firstNode, connections);
        }
    }
}
