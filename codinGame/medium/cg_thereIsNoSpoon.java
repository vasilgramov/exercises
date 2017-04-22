package codinGame.medium;// https://www.codingame.com/ide/puzzle/there-is-no-spoon-episode-1

import java.util.Scanner;

public class cg_thereIsNoSpoon {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int x = Integer.parseInt(in.nextLine());
        int y = Integer.parseInt(in.nextLine());


        char[][] grid = new char[y][x];

        for (int i = 0; i < y; i++) {
            char[] currentLine = in.nextLine().toCharArray();
            for (int j = 0; j < x; j++) {
                grid[i][j] = currentLine[j];
            }
        }

        //printMatrix(grid);


        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (grid[i][j] == '0') {
                    System.out.print(j + " " + i + " ");

                    boolean hasFound = false;
                    for (int k = j + 1; k < x; k++) {
                        if (grid[i][k] == '0') {
                            hasFound = true;
                            System.out.print(k + " " + i + " ");
                            break;
                        }
                    }

                    if (!hasFound) {
                        System.out.print("-1 -1 ");
                    }

                    hasFound = false;
                    for (int k = i + 1; k < y; k++) {
                        if (grid[k][j] == '0') {
                            hasFound = true;
                            System.out.println(j + " " + k);
                            break;
                        }
                    }

                    if (!hasFound) {
                        System.out.println("-1 -1");
                    }
                }
            }
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
