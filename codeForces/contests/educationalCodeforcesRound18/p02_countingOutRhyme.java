package codeForces.contests.educationalCodeforcesRound18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class p02_countingOutRhyme {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = in.readLine().split("\\s+");
        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.addLast(i);
        }

        long[] steps = new long[k];
        String[] stepsAsStrings = in.readLine().split("\\s+");
        for (int i = 0; i < stepsAsStrings.length; i++) {
            steps[i] = Long.parseLong(stepsAsStrings[i]);
        }

        Deque<Integer> removed = new LinkedList<>();
        for (int i = 0; i < steps.length; i++) {
            long rotations = steps[i] % queue.size();

            for (int j = 0; j < rotations; j++) {
                Integer integer1 = queue.removeFirst();
                queue.addLast(integer1);
            }

            removed.addLast(queue.removeFirst());
        }

        StringBuilder builder = new StringBuilder();
        for (Integer integer : removed) {
            builder.append(integer).append(" ");
        }

        System.out.println(builder);
    }
}
