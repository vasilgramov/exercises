package hackerRank.contests.contest_weekOfCode28;

import java.util.*;

public class p03_luckyNumberEight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        char[] numsAsChar = in.nextLine().toCharArray();

        int[] nums = new int[n];
        for (int i = 0; i < numsAsChar.length; i++) {
            nums[i] = Integer.parseInt(Character.toString(numsAsChar[i]));
        }

        int[] arr = new int[n];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 || nums[i] == 2 || nums[i] == 4 || nums[i] == 6 || nums[i] == 8) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        
        int[] arr1 = new int[n];
        for (int i = 0; i < nums.length; i++) {
            
        }
    }
}