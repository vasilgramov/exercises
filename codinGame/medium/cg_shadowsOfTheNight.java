package codinGame.medium;// https://www.codingame.com/ide/puzzle/shadows-of-the-knight-episode-1

import java.util.Scanner;

public class cg_shadowsOfTheNight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // input
        String[] matrixArgs = in.nextLine().split("\\s+");
        int width = Integer.parseInt(matrixArgs[0]);
        int height = Integer.parseInt(matrixArgs[1]);

        int numberOfJumps = Integer.parseInt(in.nextLine());

        String[] batmanArgs = in.nextLine().split("\\s+");
        int batmanX = Integer.parseInt(batmanArgs[0]);
        int batmanY = Integer.parseInt(batmanArgs[1]);
        //-------------------------------------------------------------------------------------------

        boolean[][] grid = new boolean[width][height];
        grid[batmanX][batmanY] = true;

        int startWidth = 0;
        int endWidth = width;
        int starHeight = 0;
        int endHeight = height;

        // logic
        while (true) {
            String direction = in.nextLine();

            switch (direction) {
                case "U":
                    endHeight = batmanY;
                    batmanY = starHeight + ((endHeight - starHeight) / 2);
                    break;
                case "UR":
                    startWidth = batmanX;
                    endHeight = batmanY;
                    batmanX = startWidth + ((endWidth - startWidth) / 2);
                    batmanY = starHeight + ((endHeight - starHeight) / 2);
                    break;
                case "R":
                    startWidth = batmanX;
                    batmanX = startWidth + ((endWidth - startWidth) / 2);
                    break;
                case "DR":
                    startWidth = batmanX;
                    starHeight = batmanY;
                    batmanX = startWidth + ((endWidth - startWidth) / 2);
                    batmanY = starHeight + ((endHeight - starHeight) / 2);
                    break;
                case "D":
                    starHeight = batmanY;
                    batmanY = starHeight + ((endHeight - starHeight) / 2);
                    break;
                case "DL":
                    endWidth = batmanX;
                    starHeight = batmanY;
                    batmanX = startWidth + ((endWidth - startWidth) / 2);
                    batmanY = starHeight + ((endHeight - starHeight) / 2);
                    break;
                case "L":
                    endWidth = batmanX;
                    batmanX = startWidth + ((endWidth - startWidth) / 2);
                    break;
                case "UL":
                    endWidth = batmanX;
                    endHeight = batmanY;
                    batmanX = startWidth + ((endWidth - startWidth) / 2);
                    batmanY = starHeight + ((endHeight - starHeight) / 2);
                    break;
            }

            System.out.println(batmanX + " " + batmanY);
        }
        //----------------------------------------------------------------------
    }
}
