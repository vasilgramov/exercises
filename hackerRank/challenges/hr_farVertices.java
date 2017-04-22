package hackerRank.challenges;

import java.util.Scanner;

public class hr_farVertices {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int infinity = Integer.MAX_VALUE / 2 - 2017;

        String[] input = in.nextLine().split("\\s+");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[][] graph = new int[N][N];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (i != j) {
                    graph[i][j] = infinity;
                }
            }
        }

        for (int i = 0; i < N - 1; i++) {
            String[] currentEdge = in.nextLine().split("\\s+");
            int startNode = Integer.parseInt(currentEdge[0]) - 1;
            int endNode = Integer.parseInt(currentEdge[1]) - 1;

            graph[endNode][startNode] = 1;
            graph[startNode][endNode] = 1;
        }

        for (int k = 0; k < graph.length; k++) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }


    }

    private static void printGraph(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print(graph[i][j] + " ");
            }

            System.out.println();
        }
    }
}
