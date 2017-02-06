package hackerRank.contests.contest_hourRank17;

import java.util.*;

public class p02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int tests = Integer.parseInt(in.nextLine());
        for (int i = 0; i < tests; i++) {
            int n = Integer.parseInt(in.nextLine());

            int[] balls = new int[n];
            Map<Integer, Integer> sizeByContainer = new HashMap<>();
            for (int j = 0; j < n; j++) {
                sizeByContainer.put(j, 0);
                String[] currentLine = in.nextLine().split("\\s+");
                for (int k = 0; k < n; k++) {
                    int ballsByType = Integer.parseInt(currentLine[k]);
                    balls[k] += ballsByType;
                    sizeByContainer.put(j, sizeByContainer.get(j) + ballsByType);
                }
            }

            boolean isPossible = true;
            boolean[] takenContainers = new boolean[n];

            Map<Integer, Integer> sortedByValue = new LinkedHashMap<>();
            sizeByContainer.entrySet().stream()
                    .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                    .forEachOrdered(x -> sortedByValue.put(x.getKey(), x.getValue()));

            for (int j = 0; j < balls.length; j++) {
                int ballsCountByType = balls[j];

                for (Map.Entry<Integer, Integer> integerIntegerEntry : sortedByValue.entrySet()) {
                    int container = integerIntegerEntry.getKey();
                    int size = integerIntegerEntry.getValue();

                    if (!takenContainers[container] && size <= ballsCountByType) {
                        takenContainers[container] = true;
                        ballsCountByType -= size;

                        if (ballsCountByType == 0)
                            break;
                    }
                }

                if (ballsCountByType > 0) {
                    System.out.println("Impossible");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible)
                System.out.println("Possible");
        }
    }
}
