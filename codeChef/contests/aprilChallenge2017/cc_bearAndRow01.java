package codeChef.contests.aprilChallenge2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cc_bearAndRow01 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());
        for (int i = 0; i < t; i++) {
            char[] soldiers = in.readLine().toCharArray();

            long total = 0;
            int soldiersCount = 0;
            for (int j = 0; j < soldiers.length; j++) {
                if (soldiers[j] == '0') {
                    int zerosCount = 0;
                    while (j < soldiers.length && soldiers[j] != '1') {
                        zerosCount++;
                        j++;
                    }

                    total += (zerosCount + 1 )* soldiersCount;
                }

                soldiersCount++;
            }

            System.out.println(total);
        }
    }
}
