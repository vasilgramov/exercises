package hackerRank.challenges;

import java.util.*;

// Algorithms -> Strings -> Richie Rich
public class hr_richieRich {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        char[] digits = in.next().toCharArray();

        Set<Integer> swappedIndeces = new HashSet<>();
        for (int i = 0; i < digits.length / 2; i++) {
            char front = digits[i];
            char end = digits[digits.length - 1 - i];

            if (front != end) {
                if (m <= 0) {
                    System.out.println(-1);
                    return;
                }

                if (front > end) {
                    digits[digits.length - 1 - i] = front;
                } else {
                    digits[i] = end;
                }

                swappedIndeces.add(i);

                m -= 1;
            }
        }

        for (int i = 0; i < digits.length / 2; i++) {
            if (m <= 0) {
                break;
            }

            if (digits[i] != '9'&& swappedIndeces.contains(i) && m >= 1) {
                m -= 1;
                digits[i] = '9';
                digits[digits.length - 1 - i] = '9';
            } else if (digits[i] != '9' && !swappedIndeces.contains(i) && m >= 2) {
                m -= 2;
                digits[i] = '9';
                digits[digits.length - 1 - i] = '9';
            }
        }

        if (m > 0 && digits.length % 2 != 0) {
            digits[digits .length / 2] = '9';
        }

        System.out.println(new String(digits));
    }
}
