package codinGame.medium;

import java.util.Scanner;

public class cg_marsLanderEpisode2 {
    private static final double GRAVITY_ON_MARS = 3.711;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int surfacePoints = Integer.parseInt(in.nextLine());

        int startFlatX = 0;
        int endFlatX = 0;
        int flatY = 0;

        int[][] surface = new int[surfacePoints][2];
        for (int i = 0; i < surfacePoints; i++) {
            int currentX = in.nextInt();
            int currentY = in.nextInt();
            surface[i][0] = currentX;
            surface[i][1] = currentY;

            if (i > 0) {
                if (surface[i - 1][1] == currentY) {
                    startFlatX = surface[i - 1][0];
                    endFlatX = surface[i][0];
                    flatY = currentY;
                }
            }
        }

        double currentVSpeed = GRAVITY_ON_MARS;
        while (true) {
            int X = in.nextInt();
            int Y = in.nextInt();
            int hSpeed = in.nextInt();
            int vSpeed = in.nextInt();
            int fuel = in.nextInt();
            int rotate = in.nextInt();
            int power = in.nextInt();



        }


    }
}
