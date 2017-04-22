package hackerRank.challenges;

import java.util.Arrays;
import java.util.Scanner;

public class hr_priyankaAndToys {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = in.nextInt();
        }

        Arrays.sort(weights);
        int units = 1;
        int maxWeight = weights[0] + 4;
        for (int i = 1; i < weights.length; i++) {
            if (weights[i] > maxWeight) {
                maxWeight = weights[i] + 4;
                units++;
            }
        }

        System.out.println(units);
    }
}
