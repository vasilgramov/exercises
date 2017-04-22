package codeWars;

import java.util.*;
class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int p = in.nextInt();
        float d = in.nextFloat();
        double n = (s + p) * (1 - d);
        while (s != (int)n) {
            s = (int)n;
            n = (s + p) * (1 - d);
        }
        System.out.println(s);
    }
}