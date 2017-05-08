package hackerRank.contests.contest_30DaysOfCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by vladix on 5/8/17.
 */
public class p19_stackAndQueue {

    public class Solution {
        private Deque<Character> stack;
        private Deque<Character> queue;

        public Solution() {
            this.stack = new LinkedList();
            this.queue = new LinkedList();
        }

        public void pushCharacter(char c) {
            this.stack.addFirst(c);
        }

        public void enqueueCharacter(char c) {
            this.queue.addLast(c);
        }

        public char popCharacter() {
            return this.stack.removeFirst();
        }

        public char dequeueCharacter() {
            return this.queue.removeFirst();
        }
    }

}
