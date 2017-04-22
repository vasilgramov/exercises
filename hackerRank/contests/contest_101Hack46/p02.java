package hackerRank.contests.contest_101Hack46;

import java.util.ArrayList;
import java.util.Scanner;

public class p02 {
    static int[] array;
    static int[] elements;
    static long count;
    static long neededComparisons;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int tests = Integer.parseInt(in.nextLine());
        for (int i = 0; i < tests; i++) {
            String[] commandArgs = in.nextLine().split("\\s+");
            int arraySize = Integer.parseInt(commandArgs[0]);
            long comparisons = Long.parseLong(commandArgs[1]);

            int[] numbers = new int[arraySize];
            for (int j = 1; j <= numbers.length; j++) {
                numbers[j - 1] = j;
            }

            long maxComparisons = arraySize * (arraySize + 1) / 2;
            if (maxComparisons < comparisons) {
                System.out.println(-1);
                continue;
            }

            array = new int[arraySize];
            elements = numbers;
            neededComparisons = comparisons;

            if (!variations(0))
                System.out.println(-1);
        }
    }

    private static boolean variations(int index) {  // with swap
        if (index == array.length) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < array.length; i++) {
                arrayList.add(array[i]);
            }

            if (lenaSort(arrayList) != null && count == neededComparisons) {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    result.append(arrayList.get(i) + " ");
                }

                System.out.println(result);
                return true;
            } else
                count = 0;

            return false;
        }

        for (int i = index; i < array.length; i++) {
            int temp = elements[i];
            elements[i] = elements[index];
            elements[index] = elements[i];

            array[index] = temp;
            if (variations(index + 1))
                return true;

            elements[index] = elements[i];
            elements[i] = temp;
        }

        return false;
    }

    private static ArrayList<Integer> lenaSort(ArrayList<Integer> nums) {
        if (nums == null)
            return null;

        if (nums.size() == 1 || nums.size() == 0) {
            return nums;
        }

        int pivot = nums.get(0);
        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> more = new ArrayList<>();
        for (int i = 1; i < nums.size(); ++i) {
            // Comparison
            if (nums.get(i) < pivot) {
                less.add(nums.get(i));
            }
            else {
                more.add(nums.get(i));
            }

            count++;
            if (count > neededComparisons)
                return null;
        }

        lenaSort(less);
        lenaSort(more);

        return nums;
    }
}