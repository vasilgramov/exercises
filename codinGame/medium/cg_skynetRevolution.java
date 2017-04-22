package codinGame.medium;// https://www.codingame.com/ide/puzzle/skynet-revolution-episode-1

import java.util.Scanner;

public class cg_skynetRevolution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // input
        String[] inputArgs = in.nextLine().split("\\s+");
        int numberOfNodes = Integer.parseInt(inputArgs[0]);
        int numberOfLinks = Integer.parseInt(inputArgs[1]);
        int numberOfExits = Integer.parseInt(inputArgs[2]);

        int[][] linkedNodes = new int[numberOfLinks][2];

        for (int i = 0; i < numberOfLinks; i++) {
            String[] currentLinkedNodes = in.nextLine().split("\\s+");
            int firstNode = Integer.parseInt(currentLinkedNodes[0]);
            int secondNode = Integer.parseInt(currentLinkedNodes[1]);

            linkedNodes[i][0] = firstNode;
            linkedNodes[i][1] = secondNode;
        }

        int[] exitsIndexes = new int[numberOfExits];
        for (int i = 0; i < numberOfExits; i++) {
            int currentExit = Integer.parseInt(in.nextLine());
            exitsIndexes[i] = currentExit;
        }
        //------------------------------------------------------------------------------

        // getting size of the linked nodes with exits
        int size = 0;
        for (int i = 0; i < linkedNodes.length; i++) {
            for (int j = 0; j < exitsIndexes.length; j++) {
                if (linkedNodes[i][0] == exitsIndexes[j] || linkedNodes[i][1] == exitsIndexes[j]) {
                    size++;
                    break;
                }
            }
        }
        //--------------------------------------------------------------------------------

        // filtering linked nodes with exits
        int[][] linkedWithExits = new int[size][2];
        // maybe Set<String> ???
        int index = 0;
        for (int i = 0; i < exitsIndexes.length; i++) {
            for (int j = 0; j < linkedNodes.length; j++) {

                if (exitsIndexes[i] == linkedNodes[j][0] || exitsIndexes[i] == linkedNodes[j][1]) {

                    linkedWithExits[index][1] = exitsIndexes[i];
                    linkedWithExits[index][0] = exitsIndexes[i] == linkedNodes[j][0] ? linkedNodes[j][1] : linkedNodes[j][0];
                    index++;
                }
            }
        }
        //----------------------------------------------------

        // logic
        while (1 != 0) {
            int agentIndex = Integer.parseInt(in.nextLine());
            boolean hasFound = false;
            for (int i = 0; i < linkedWithExits.length; i++) {
                if (agentIndex == linkedWithExits[i][0] || agentIndex == linkedWithExits[i][1]) {
                    hasFound = true;
                    System.out.println(linkedWithExits[i][0] + " " + linkedWithExits[i][1]);
                    if (linkedWithExits.length == 1) {
                        return;
                    }
                    int[][] copyArray = new int[linkedWithExits.length - 1][2];

                    int newIndex = 0;
                    for (int j = 0; j < linkedWithExits.length; j++) {
                        if (j == i) {
                            continue;
                        }
                        copyArray[newIndex][0] = linkedWithExits[j][0];
                        copyArray[newIndex][1] = linkedWithExits[j][1];
                        newIndex++;
                    }

                    linkedWithExits = copyArray;

                    break;
                }
            }

            if (hasFound) {
                continue;
            }

            // if hasn't found remove first element
            System.out.println(linkedWithExits[0][0] + " " + linkedWithExits[0][1]);

            int newIndex = 0;
            int[][] copyArray = new int[linkedWithExits.length - 1][2];
            for (int i = 1; i < linkedWithExits.length; i++) {
                copyArray[newIndex][0] = linkedWithExits[i][0];
                copyArray[newIndex][1] = linkedWithExits[i][1];
                newIndex++;
            }

            linkedWithExits = copyArray;
        }
    }
}