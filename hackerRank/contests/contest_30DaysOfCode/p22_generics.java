package hackerRank.contests.contest_30DaysOfCode;

import java.util.Scanner;

/**
 * Created by vladix on 5/11/17.
 */
public class p22_generics {

    public static void main(String[] args) {
    }

    public static class Printer<T> {
        public void printArray(T[] array) {
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);
            }
        }
    }
}
