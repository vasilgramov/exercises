package hackerRank.contests.contest_30DaysOfCode;

import java.util.Scanner;

public class p25_moreLinkedList {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Node head = null;
        int t = in.nextInt();
        while (t-- > 0) {
            int data = in.nextInt();
            head = insert(head, data);
        }

        head = removeDuplicates(head);
        display(head);
    }

    public static void display(Node head) {
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static Node insert(Node head, int data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
        } else if (head.next == null) {
            head.next = node;
        } else {
            Node start = head;
            while (start.next != null) {
                start = start.next;
            }

            start.next = node;
        }

        return head;
    }

    public static Node removeDuplicates(Node head) {
        Node start = head;

        while (head != null) {
            while (head.next != null && head.data == head.next.data) {
                head.next = head.next.next;
            }

            head = head.next;
        }


        return start;
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}