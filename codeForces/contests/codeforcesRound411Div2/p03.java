package codeForces.contests.codeforcesRound411Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by vladix on 5/4/17.
 */
public class p03 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int result = n / 2;
        if (n % 2 == 0) {
            result--;
        }

        System.out.println(result);
    }
}
