package codeForces.contests.educationalCodeforcesRound36;

import java.util.Scanner;

public class p03_permuteDigits {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String a = in.next();
        String b = in.next();

        int[] aDigits = new int[10];

        fillDigitsArray(a, aDigits);

        if (b.length() > a.length()) {
            System.out.println(sortArrayDescending(aDigits));
        } else {
            System.out.println(getLargestPossibleNumber(aDigits, b));
        }

    }

    private static String getLargestPossibleNumber(int[] aDigits, String b) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < b.length(); i++) {
            int digit = Integer.parseInt(b.charAt(i) + "");

            if (aDigits[digit] > 0) {
                result.append(digit);
                aDigits[digit]--;
            } else {
                int nextLargestNumber = getNextLargestNumber(aDigits, digit - 1);
                if (nextLargestNumber != -1) {  // if we have next largest number just append it to the StringBuilder
                    result.append(nextLargestNumber);
                    result.append(sortArrayDescending(aDigits));
                } else {
                    backTrack(aDigits, result);
                }

                break;
            }
        }

        return result.toString();
    }

    private static void backTrack(int[] aDigits, StringBuilder result) {
        int digit;
        int nextLargestNumber;
        while (true) {
            // removing the last appended digit from the StringBuilder
            // - if we found smaller one -> append and sort array descending
            // - else loop again

            digit = Integer.parseInt(result.charAt(result.length() - 1) + "");
            result.deleteCharAt(result.length() - 1);
            aDigits[digit]++;

            nextLargestNumber = getNextLargestNumber(aDigits, digit - 1);
            if (nextLargestNumber != - 1) {
                result.append(nextLargestNumber);
                result.append(sortArrayDescending(aDigits));

                break;
            }
        }
    }

    private static int getNextLargestNumber(int[] aDigits, int index) {
        for (int i = index; i >= 0; i--) {
            int digit = aDigits[i];

            if (digit > 0) {
                aDigits[i]--;
                return i;
            }
        }

        return -1;
    }

    private static String sortArrayDescending(int[] digits) {
        StringBuilder result = new StringBuilder();
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];

            if (digit > 0) {
                result.append(newString(i, digit));
            }
        }

        return result.toString();
    }

    private static String newString(int digit, int reps) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < reps; i++) {
            sb.append(digit);
        }

        return sb.toString();
    }

    private static void fillDigitsArray(String digits, int[] array) {
        for (int i = 0; i < digits.length(); i++) {
            int digit = Integer.parseInt(digits.charAt(i) + "");

            array[digit]++;
        }
    }
}
