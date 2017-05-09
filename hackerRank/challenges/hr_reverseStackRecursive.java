package hackerRank.challenges;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by vladix on 5/8/17.
 */
public class hr_reverseStackRecursive {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(1);
        stack.addFirst(2);
        stack.addFirst(3);
        stack.addFirst(4);

        printStack(stack);

        System.out.println();
        reverse(stack);

        printStack(stack);
    }

    private static void printStack(Deque<Integer> stack) {
        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }

    private static void reverse(Deque<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        Integer number = stack.removeFirst();
        reverse(stack);
        stack.addLast(number);
    }
}
