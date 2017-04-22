package hackerRank.challenges;

import java.util.Scanner;

public class hr_veryBigSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long sum = 0L;
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            sum += in.nextLong();
        }

        System.out.println(sum);
    }
}
