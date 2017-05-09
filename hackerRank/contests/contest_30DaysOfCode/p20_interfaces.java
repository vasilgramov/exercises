package hackerRank.contests.contest_30DaysOfCode;

/**
 * Created by vladix on 5/9/17.
 */
public class p20_interfaces {

    class Calculator implements AdvancedArithmetic {

        public int divisorSum(int n) {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    sum += i;
                }
            }

            return sum;
        }

    }

    interface AdvancedArithmetic {
        int divisorSum(int n);
    }

}
