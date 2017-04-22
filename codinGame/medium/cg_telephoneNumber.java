package codinGame.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cg_telephoneNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = 0;

        List<Node> listOfNodes = new ArrayList<>();

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            char[] currentTelephone = in.nextLine().toCharArray();

            int firstDigit = currentTelephone[0] - '0';
            Node toAppend = null;
            boolean hasFound = false;
            for (Node node : listOfNodes) {
                if (node.value == firstDigit) {
                    hasFound = true;
                    toAppend = node;
                    break;
                }
            }

            if (hasFound) {
                Node nextNode = toAppend;

                for (int j = 1; j < currentTelephone.length; j++) {
                    int currentDigit = currentTelephone[j] - '0';
                    boolean has = false;
                    for (Node node : nextNode.nextNodes) {
                        if (node.value == currentDigit) {
                            has = true;
                            nextNode = node;
                            break;
                        }
                    }

                    if (!has) {
                        size += currentTelephone.length - j;
                        for (int k = j; k < currentTelephone.length; k++) {
                            Node node = new Node(currentTelephone[k] - '0');
                            nextNode.addNode(node);
                            nextNode = node;
                        }

                        break;
                    }
                }
            } else {
                size += currentTelephone.length;
                Node node = new Node(firstDigit);
                listOfNodes.add(node);
                for (int j = 1; j < currentTelephone.length; j++) {
                    Node current = new Node(currentTelephone[j] - '0');
                    node.addNode(current);
                    node = current;
                }
            }
        }

        System.out.println(size);
    }

    private static class Node {
        private int value;
        private List<Node> nextNodes;

        public Node(int value) {
            this.nextNodes = new ArrayList<>();
            this.value = value;
        }

        public void addNode (Node node) {
            this.nextNodes.add(node);
        }
    }
}
