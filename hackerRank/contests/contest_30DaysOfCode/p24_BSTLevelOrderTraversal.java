package hackerRank.contests.contest_30DaysOfCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by vladix on 5/13/17.
 */
public class p24_BSTLevelOrderTraversal {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    }

    static void levelOrder(Node root) {
        Deque<Node> nodes = new LinkedList();
        nodes.addLast(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.removeFirst();
            System.out.print(node.data + " ");

            if (node.left != null) {
                nodes.addLast(node.left);
            }

            if (node.right != null) {
                nodes.addLast(node.right);
            }
        }
    }

    public class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
