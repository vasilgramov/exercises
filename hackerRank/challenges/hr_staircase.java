package hackerRank.challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hr_staircase {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        for (int i = 1; i <= n; i++) {
            System.out.println(newString(n - i, " ") + newString(i, "#"));
        }
    }

    private static String newString(int n, String str) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            builder.append(str);
        }

        return builder.toString();
    }
}
