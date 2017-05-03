package codinGame.medium;

import java.util.*;

/**
 * Created by vladix on 5/3/17.
 */
public class cg_dwarfs {

    private static int max = 0;

    private static Set<Integer> visited = new HashSet<>();

    private static Map<Integer, List<Integer>> childrenByNode = new HashMap<>();
    private static Map<Integer, List<Integer>> parentsByNode = new HashMap<>();


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        readGraph(in, n);

        for (Map.Entry<Integer, List<Integer>> integerListEntry : childrenByNode.entrySet()) {
            visited = new HashSet<>();
            bfs(integerListEntry.getKey(), 0);
        }

        System.out.println(max + 1);
    }

    private static void bfs(Integer integerListEntry, int count) {
        if (visited.contains(integerListEntry)) {
            return;
        }

        if (count > max) {
            max = count;
        }

        if (childrenByNode.containsKey(integerListEntry)) {
            List<Integer> children = childrenByNode.get(integerListEntry);
            for (Integer child : children) {
                bfs(child, count + 1);
            }
        }
    }

    private static void readGraph(Scanner in, int n) {
        for (int i = 0; i < n; i++) {
            int from = in.nextInt();
            int to = in.nextInt();

            if (!childrenByNode.containsKey(from)) {
                List<Integer> connections = new ArrayList<>();
                connections.add(to);
                childrenByNode.put(from, connections);
            } else {
                List<Integer> connections = childrenByNode.get(from);
                connections.add(to);
                childrenByNode.put(from, connections);
            }
        }
    }
}
