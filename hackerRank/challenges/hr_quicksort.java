package hackerRank.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 6/4/17.
 */
public class hr_quicksort {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int size = keyboard.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = keyboard.nextInt();
        }
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int first, int last) {
        if (first >= last)
            return;
        int pivot = array[last];
        int i = first;
        for (int j = first; j < last; j++) {
            if (array[j] <= pivot) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        array[last] = array[i];
        array[i] = pivot;
        printArray(array);
        quickSort(array, first, i - 1);
        quickSort(array, i + 1, last);
    }

    private static void printArray(int[] array) {
        for (int number : array) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
