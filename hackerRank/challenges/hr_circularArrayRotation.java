package hackerRank.challenges;

import java.util.Scanner;

public class hr_circularArrayRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();   // size of array
        int k = in.nextInt();   // rotations
        int q = in.nextInt();   // queries

        int[] numbers = new int[n];
        for(int i = 0; i < n; i++)
        {
            numbers[(i + k) % n] = in.nextInt();
        }

        for (int i = 0; i < q; i++) {
            System.out.println(numbers[in.nextInt()]);
        }
    }
}