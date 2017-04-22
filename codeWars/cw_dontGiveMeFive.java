package codeWars;// https://www.codewars.com/kata/5813d19765d81c592200001a/train/java

import java.util.Scanner;

public class cw_dontGiveMeFive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int startNum = Integer.parseInt(in.nextLine());
        int endNum = Integer.parseInt(in.nextLine());

        int counter = 0;
        for (int i = startNum; i <= endNum; i++) {
            String numAsString = Integer.toString(i);
            if (!numAsString.contains("5")) {
                counter++;
            }
        }

        System.out.println(counter);
    }
}
