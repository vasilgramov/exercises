package hackerRank.contests.contest_30DaysOfCode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by vladix on 5/4/17.
 */
public class p15_scope {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    }

    public static class Difference {
        private int[] elements;
        private int maximumAbsDiff;

        public Difference(int[] elements) {
            this.elements = elements;
        }

        public void computeDiff() {
            Arrays.sort(this.elements);

            int first = this.elements[0];
            int last = this.elements[this.elements.length - 1];
            this.maximumAbsDiff = last - first;
        }
    }
}
