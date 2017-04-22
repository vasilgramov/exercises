package hackerRank.challenges;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/*
Given N integers, count the number of pairs of integers whose difference is K.
 */

public class hr_pairs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] inputArgs = in.nextLine().split("\\s+");
        int n = Integer.parseInt(inputArgs[0]);
        long k = Long.parseLong(inputArgs[1]);

        HashSet<Long> searchingSet = new HashSet<>();
        TreeSet<Long> numbers = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            long currentNum = in.nextLong();
            numbers.add(currentNum);
            searchingSet.add(currentNum);
        }

        long count = 0;
        for (int i = 0; i < n - 1; i++) {
            long firstNum = numbers.pollFirst();
            long searchedNum = firstNum + k;

            if (searchingSet.contains(searchedNum)) count++;
        }

        System.out.println(count);
    }
}
