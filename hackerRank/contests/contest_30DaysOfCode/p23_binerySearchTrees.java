package hackerRank.contests.contest_30DaysOfCode;

import java.util.Scanner;

/**
 * Created by vladix on 5/12/17.
 */
public class p23_binerySearchTrees {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    }

    private static int getHeight(Node root){
        if (root == null) return -1;

        int leftDepth = getHeight(root.left) + 1;
        int rightDepth = getHeight(root.right) + 1;

        return Math.max(leftDepth, rightDepth);
    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
