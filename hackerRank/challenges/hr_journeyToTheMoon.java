package hackerRank.challenges;

import java.util.*;

/**
 * Created by vladix on 4/24/17.
 */
public class hr_journeyToTheMoon {

    private static List<Integer>[] graph;
    private static Set<Integer> visited = new HashSet<>();

    private static int count;
    private static List<Integer> numberOfSets = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int p = in.nextInt();

        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < p; i++) {
            int n1 = in.nextInt();
            int n2 = in.nextInt();

            graph[n1].add(n2);
            graph[n2].add(n1);
        }


        for (int i = 0; i < graph.length; i++) {
            count = 0;
            dfs(i);

            if (count != 0) {
                numberOfSets.add(count);
            }
        }


        long result = 0L;
        for (int i = 0; i < numberOfSets.size(); i++) {
            for (int j = i + 1; j < numberOfSets.size(); j++) {
                result += numberOfSets.get(i) * numberOfSets.get(j);
            }
        }

        System.out.println(result);
    }

    private static void dfs(int node) {
        if (visited.contains(node)) {
            return;
        }

        count++;
        visited.add(node);

        List<Integer> children = graph[node];
        for (Integer child : children) {
            dfs(child);
        }
    }
}
