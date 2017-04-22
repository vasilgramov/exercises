package codinGame.medium;

import java.util.*;

// https://www.codingame.com/ide/puzzle/the-last-crusade-episode-1
public class cg_theLastCrusadeEpisode1 {

    static Scanner in = new Scanner(System.in);
    static Map<Integer, String[][]> entrancesExitsByType = new HashMap<>();

    public static void main(String[] args) {

        fill();

        int width = in.nextInt();
        int height = in.nextInt();
        in.nextLine();
        int[][] grid = new int[height][width];

        fillGrid(width, height, grid);

        int exitCoordinates = in.nextInt(); // the coordinate along the X axis of the exit

        // logic
        while (true) {
            int xPos = in.nextInt();
            int yPos = in.nextInt();
            String fromDirection = in.next().toLowerCase();

            int roomType = grid[yPos][xPos];
            String[][] roomData = entrancesExitsByType.get(roomType);

            if (roomData[1].length == 1 && roomData[1][0].equals("left")) // moving down
                System.out.println((xPos - 1) + " " + yPos);
            else if (roomData[1].length == 1 && roomData[1][0].equals("right"))
                System.out.println((xPos + 1) + " " + yPos);
            else if (roomData[1].length == 1 && roomData[1][0].equals("down"))
                System.out.println(xPos + " " + (yPos + 1));
            else {
                int index = -1;
                for (int i = 0; i < roomData[0].length; i++) {
                    if (roomData[0][i].equals(fromDirection)) {
                        index = i;
                        break;
                    }
                }

                String toDirection = roomData[1][index];
                switch (toDirection) {
                    case "left":
                        System.out.println((xPos - 1) + " " + yPos);
                        break;
                    case "right":
                        System.out.println((xPos + 1)+ " " + yPos);
                        break;
                    case "down":
                        System.out.println(xPos  + " " + (yPos + 1));
                        break;
                }
            }
        }
    }

    private static void fillGrid(int width, int height, int[][] grid) {
        for (int row = 0; row < height; row++) {
            String[] line = in.nextLine().split("\\s+");
            for (int col = 0; col < width; col++) {
                grid[row][col] = Integer.parseInt(line[col]);
            }
        }
    }

    private static void fill() {
        entrancesExitsByType.put(0, new String[0][0]);
        entrancesExitsByType.put(1, new String[][]{{"left", "top", "right"}, {"down"}});
        entrancesExitsByType.put(2, new String[][]{{"left", "right"}, {"right", "left"}});
        entrancesExitsByType.put(3, new String[][]{{"top"}, {"down"}});
        entrancesExitsByType.put(4, new String[][]{{"top", "right"}, {"left", "down"}});
        entrancesExitsByType.put(5, new String[][]{{"top", "left"}, {"right", "down"}});
        entrancesExitsByType.put(6, new String[][]{{"left", "right"}, {"right", "left"}}); // to check TOP
        entrancesExitsByType.put(7, new String[][]{{"top", "right"}, {"down"}});
        entrancesExitsByType.put(8, new String[][]{{"left", "right"}, {"down"}});
        entrancesExitsByType.put(9, new String[][]{{"left", "top"}, {"down"}});
        entrancesExitsByType.put(10, new String[][]{{"top"}, {"left"}});
        entrancesExitsByType.put(11, new String[][]{{"top"}, {"right"}});
        entrancesExitsByType.put(12, new String[][]{{"right"}, {"down"}});
        entrancesExitsByType.put(13, new String[][]{{"left"}, {"down"}});
    }
}
