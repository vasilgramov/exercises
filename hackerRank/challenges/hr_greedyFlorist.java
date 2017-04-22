package hackerRank.challenges;

import java.util.Scanner;
import java.util.TreeSet;

public class hr_greedyFlorist {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        in.nextLine();

        int sumOfAllFlowers = 0;
        TreeSet<Integer> flowers = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int currentFlower = in.nextInt();
            sumOfAllFlowers += currentFlower;

            if (flowers.contains(currentFlower))
                throw new Exception();

            flowers.add(currentFlower);
        }

        if (n == k) {
            System.out.println(sumOfAllFlowers);
            return;
        }

        int result = 0;

        int toBeAdded = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int mostExpensive = flowers.pollLast();

            result += (toBeAdded + 1) * mostExpensive;

            count++;
            if (count == k) {
                toBeAdded++;
                count = 0;
            }
        }

        System.out.println(result);
    }
}
