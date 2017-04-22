package hackerRank.challenges;

import java.util.Scanner;

// Algorithms > Recursion > The Power Sum
public class hr_thePowerSum {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int total = scan.nextInt();
        int power = scan.nextInt();

        int result = powerSum(total, power, 1, 0);
        System.out.println(result);
    }

    private static int powerSum(int total, int power, int base, int sum) {
        int cur = (int) Math.pow(base, power);

        if ((sum + cur) == total) {
            return 1;
        } else if (sum > total || cur > total) {
            return 0;
        } else {
            return powerSum(total, power, base + 1, (sum + cur)) +
                    powerSum(total, power, base + 1, sum);
        }
    }
}