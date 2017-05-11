package softUni.problems;

import java.util.*;

/**
 * Created by vladix on 5/10/17.
 */
public class su_sequenceOfLimitedSum {

    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int targetSum = Integer.parseInt(in.nextLine());
        Deque<Integer> numbers = new LinkedList<>();

        generateSequences(numbers, 0, targetSum);
        System.out.println(result);
    }

    public static void generateSequences(Deque<Integer> numbers, int currentSum, int targetSum) {
        if (!numbers.isEmpty()) {
            for (Integer integer : numbers) {
                result.append(integer + " ");
            }
            result.append(System.lineSeparator());
        }

        for (int i = 1; i <= targetSum; i++) {
            if (currentSum + i <= targetSum) {
                numbers.addLast(i);
                currentSum += i;

                generateSequences(numbers, currentSum, targetSum);

                numbers.removeLast();
                currentSum -= i;
            } else {
                break;
            }
        }

    }
}
