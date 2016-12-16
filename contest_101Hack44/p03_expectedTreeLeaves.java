package hackerRank.contest_101Hack44;

import java.util.Scanner;

public class p03_expectedTreeLeaves {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long ans = n;
        for (int i = 3; i <= n; i++)
            ans = (ans * n) % 1000000007;
        System.out.println(ans);
    }
}
