package hackerRank.contests.contest_30DaysOfCode;

import java.util.Scanner;

/**
 * Created by vladix on 5/5/17.
 */
public class p16_linkedList {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Node head = null;
        int n = in.nextInt();
        while (n-- > 0) {
            head = insert(head, in.nextInt());
        }

        System.out.println("DEBUG");
    }

    public static Node insert(Node head,int data) {
        if (head == null) {
            head = new Node(data);
            return head;
        }

        Node headHead = head;

        while (head.next != null) {
            head = head.next;
        }

        head.next = new Node(data);
        return headHead;
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
