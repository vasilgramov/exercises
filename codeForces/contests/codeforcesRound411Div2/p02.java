//package codeForces.contests.codeforcesRound411Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by vladix on 5/4/17.
 */
public class p02 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        StringBuilder builder = new StringBuilder();
        while (n >= 4) {
            builder.append("abba");
            n -= 4;
        }

        String[] arr = { "a", "b", "b" };
        for (int i = 0; i < n; i++) {
            builder.append(arr[i]);
        }

        System.out.println(builder);
    }
}
