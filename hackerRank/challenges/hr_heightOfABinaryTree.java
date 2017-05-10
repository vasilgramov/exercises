package hackerRank.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 5/10/17.
 */
public class hr_heightOfABinaryTree {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        Node root = null;
        while (t-- > 0) {
            int data = in.nextInt();
            root = addChild(root, data);
        }

        System.out.println("DEBUG");

        int depth = getDepth(root);
        System.out.println(depth);
    }

    private static int getDepth(Node root) {
        if (root == null) return -1;

        int leftDepth = getDepth(root.leftChild) + 1;
        int rightDepth = getDepth(root.rightChild) + 1;

        return Math.max(leftDepth, rightDepth);
    }

    private static Node addChild(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data <= root.data) {
            Node toBeAdded = addChild(root.leftChild, data);
            root.leftChild = toBeAdded;
        } else {
            Node toBeAdded = addChild(root.rightChild, data);
            root.rightChild = toBeAdded;
        }

        return root;
    }


    private static class Node {
        private int data;
        private Node leftChild;
        private Node rightChild;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data + "";
        }
    }
}
