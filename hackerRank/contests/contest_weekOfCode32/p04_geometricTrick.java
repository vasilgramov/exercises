package hackerRank.contests.contest_weekOfCode32;

import java.util.*;

/**
 * Created by vladix on 5/18/17.
 */
public class p04_geometricTrick {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        String input = in.next();

        Deque<Integer> aIndexes = new LinkedList<>();
        Deque<Integer> bIndexes = new LinkedList<>();
        Deque<Integer> cIndexes = new LinkedList<>();

        boolean[] aExists = new boolean[input.length()];
        boolean[] cExists = new boolean[input.length()];

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a') {
                aExists[i] = true;
                aIndexes.add(i);
            } else if (input.charAt(i) == 'b') {
                bIndexes.add(i);
            } else if (input.charAt(i) == 'c') {
                cExists[i] = true;
                cIndexes.addLast(i);
            }
        }

        long count = 0L;

        // ((b + 1) * (b + 1)) = (a + 1) * (c + 1);

        // (a + 1) = ((b + 1) * (b + 1)) / (c + 1);

        // (c + 1) = ((b + 1) * (b + 1)) / (a + 1);

        if (bIndexes.size() < aIndexes.size() && bIndexes.size() < cExists.length) {
            for (Integer bIndex : bIndexes) {
                long needed = (bIndex + 1) * (bIndex + 1);

                if (aIndexes.element() < cIndexes.element()) {
                    for (Integer aIndex : aIndexes) {
                        int a = aIndex + 1;
                        if (needed % a == 0) {
                            int c = (int)(needed / a) - 1;
                            if (c < cExists.length && cExists[c]) {
                                count++;
                            }
                        }
                    }
                } else {
                    for (Integer cIndex : cIndexes) {
                        int c = cIndex + 1;
                        if (needed % c == 0) {
                            int a = (int)(needed / c) - 1;
                            if (a < aExists.length && aExists[a]) {
                                count++;
                            }
                        }
                    }
                }
            }
        } else if (aIndexes.size() < bIndexes.size() && aIndexes.size() < cIndexes.size()) {
            for (Integer aIndex : aIndexes) {
                long needed =  aIndex + 1;

                if (bIndexes.size() < cIndexes.size()) {
                    for (Integer bIndex : bIndexes) {
                        long b = (bIndex + 1) * (bIndex + 1);
                        if (b - needed > 0) {
                            int c = (int)(b - needed);
                            if (c < cExists.length && cExists[c]) {
                                count++;
                            }
                        }
                    }
                } else {
                    for (Integer cIndex : cIndexes) {
                        int c = cIndex + 1;

//                        long needed = c *
                    }
                }
            }
        }


        System.out.println(count);
    }
}

