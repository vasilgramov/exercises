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
        String E = in.nextLine();

        int result = Integer.parseInt(E.substring(E.indexOf('=') + 1));


        int rightPart = Integer.parseInt(E.substring(E.contains("+") ? E.indexOf("+") : E.indexOf("-"), E.indexOf("=")));
//        System.out.println(rightPart);
        String leftPart = E.substring(0, E.contains("+") ? E.indexOf("+") : E.indexOf("-"));

        int leftPartNumber = 1;
        try {
            leftPartNumber = Integer.parseInt(leftPart.replace("N", ""));
        } catch (NumberFormatException e) {

        }


//        System.out.println(leftPartNumber);

//        System.out.println(result - rightPart);
        double n = (result - rightPart) / (leftPartNumber + 0.0);

        if (n != (int)n) {
            System.out.println((int)(n + 1));
        } else {
            System.out.println((int)n);
        }

//        System.out.println("SOLUTION");
    }
}