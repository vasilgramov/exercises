package codeWars;// https://www.codewars.com/kata/56b5afb4ed1f6d5fb0000991/train/java

import java.util.Arrays;
import java.util.Scanner;

public class cw_reveseOrRotate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String strng = in.nextLine();
        int sz = Integer.parseInt(in.nextLine());

        revRot(strng, sz);
    }

    private static String revRot(String strng, int sz) {
        if (sz <= 0 || strng.equals("") || sz > strng.length()) {
            return "";
        }
        String[] chunks = strng.split(String.format("(?<=\\G.{%d})", sz));
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chunks.length; i++) {
            if (chunks[i].length() == sz) {
                long sum = 0L;
                for (int j = 0; j < chunks[i].length(); j++) {
                    sum += Math.pow(Double.parseDouble(Character.toString(chunks[i].charAt(j))), 3);
                }

                if (sum % 2 == 0) {
                    builder.append(new StringBuilder(chunks[i]).reverse().toString());
                } else {
                    char[] currentChunk = chunks[i].toCharArray();
                    char[] slicedChunk = Arrays.copyOfRange(currentChunk, 1, currentChunk.length);
                    builder.append(new String(slicedChunk) + currentChunk[0]);
                }
            }
        }

        return builder.toString();
    }
}
