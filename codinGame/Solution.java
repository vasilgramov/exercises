package codinGame;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        String[] words = new String[] { "GA", "BU", "ZO", "MEU" };
        StringBuilder builder = new StringBuilder();
        int count = 2;
        while (N >= 0) {
            builder.append(words[N % 3]);
            N /= 4;
            N -= count;
        }

        System.out.println(builder.toString());
    }
}