package hackerRank.contests.contest_hourRank19;

import java.util.Scanner;

public class p01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] file = new int[n];
        for(int file_i=0; file_i < n; file_i++){
            file[file_i] = in.nextInt();
        }

        int count = 0;
        for (int i = 0; i < file.length; i++) {
            int num = file[i];
            i += num;
            count++;
        }

        System.out.println(count);
    }
}
