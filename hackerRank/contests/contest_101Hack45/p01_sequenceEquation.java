package hackerRank.contests.contest_101Hack45;

import java.util.Scanner;

public class p01_sequenceEquation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int arraySize = Integer.parseInt(in.nextLine());

        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = in.nextInt();
        }

        for (int i = 0; i < arraySize; i++) {
            int x = i + 1;

            int pIndex = 0;
            for (int j = 0; j < arraySize; j++) {
                if (array[j] == x) {
                    pIndex = j;
                    break;
                }
            }

            pIndex++;
            for (int j = 0; j < arraySize; j++) {
                if (array[j] == pIndex) {
                    System.out.println(j + 1);
                }
            }
        }
    }
}
