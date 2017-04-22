package hackerRank.challenges;

import java.util.*;

public class hr_sherlockAndMiniMax {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        TreeSet<Long> numbers = new TreeSet<>();

        int n = Integer.parseInt(in.nextLine());
        String[] input = in.nextLine().split("\\s+");
        for (int i = 0; i < n; i++) {
            numbers.add(Long.parseLong(input[i]));
        }

        String[] PQ = in.nextLine().split("\\s+");
        long p = Long.parseLong(PQ[0]);
        long q = Long.parseLong(PQ[1]);

        TreeSet<Long> numsBetweenPQ = new TreeSet<>(numbers.subSet(p, q));
        Long lowerBound = numbers.floor(p);
        if (lowerBound != null) {
            numsBetweenPQ.add(lowerBound);
        }

        Long upperBound = numbers.ceiling(q);
        if (upperBound != null) {
            numsBetweenPQ.add(upperBound);
        }

        long minN = p;
        long diff = Math.abs(p - numsBetweenPQ.first());
        for (Long num : numsBetweenPQ) {
            Long ceil = numsBetweenPQ.ceiling(num + 1);
            if (ceil != null) {
                Long currentDiff = (ceil - num) / 2;
                if (currentDiff > diff) {
                    if (num + currentDiff >= p && num + currentDiff <= q) {
                        minN = num + currentDiff;
                        diff = currentDiff;
                    }
                }
            }
        }

        // edge case
        Long last = numsBetweenPQ.last();
        Long prev = numsBetweenPQ.floor(last - 1);
        Long diffFloor = Math.abs(q - prev);
        Long ceil = Math.abs(q - last);
        Long current = diffFloor <= ceil ? diffFloor : ceil;

        if (current > diff) {
            minN = q;
        }
        //---------------

        System.out.println(minN);
    }
}

