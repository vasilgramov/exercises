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
        String DNA = in.next();

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        Map<Character, Character> characterCharacterMap = new HashMap<>();
        characterCharacterMap.put('A', 'T');
        characterCharacterMap.put('T', 'A');
        characterCharacterMap.put('C', 'G');
        characterCharacterMap.put('G', 'C');


        StringBuilder result = new StringBuilder();
        for (int i = 0; i < DNA.length(); i++) {
            result.append(characterCharacterMap.get(DNA.charAt(i)));
        }

        System.out.println(result);
    }
}