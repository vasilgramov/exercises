package hackerRank.challenges;

import java.util.Scanner;

// Algorithms > Recursion > The Power Sum
public class hr_thePowerSum {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int total = scan.nextInt();
        int power = scan.nextInt();

        int result = count(total, power, 1);
        System.out.println(result);
    }

    private static int count(int total, int power, int currentNumber) {
        int value = total - (int)Math.pow(currentNumber, power);

        if (value < 0) return  0;
        else if (value == 0) return 1;
        else return count(value, power, currentNumber + 1) +
                    count(total, power, currentNumber + 1);
    }
}