package hackerRank.contests.contest_weekOfCode35;

import java.util.Scanner;

/**
 * Created by vladix on 11/26/17.
 */
public class p03_3DSurfaceArea {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int height = in.nextInt();
        int width = in.nextInt();

        int[][] matrix = new int[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                matrix[row][col] = in.nextInt();
            }
        }

        int surface_area = 0;
        // upper
        surface_area += width * height;

        // lower
        surface_area += width * height;

        // front
        surface_area = getFrontSurfaceArea(height, width, matrix, surface_area);

        // back
        surface_area = getBackSurfaceArea(height, width, matrix, surface_area);

        // left
        surface_area = getLeftSurfaceArea(height, width, matrix, surface_area);

        // right
        surface_area = getRightSurfaceArea(height, width, matrix, surface_area);

        System.out.println(surface_area);
    }

    private static int getRightSurfaceArea(int height, int width, int[][] matrix, int surface_area) {
        for (int row = 0; row < height; row++) {
            for (int col = width - 1; col >= 0; col--) {

                if (col == width - 1) surface_area = add_to_surface_area(surface_area, matrix[row][col]);
                else surface_area = add_to_surface_area(surface_area, matrix[row][col] - matrix[row][col + 1]);
            }
        }
        return surface_area;
    }

    private static int getLeftSurfaceArea(int height, int width, int[][] matrix, int surface_area) {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {

                if (col == 0) surface_area = add_to_surface_area(surface_area, matrix[row][col]);
                else surface_area = add_to_surface_area(surface_area, matrix[row][col] - matrix[row][col - 1]);
            }
        }
        return surface_area;
    }

    private static int getBackSurfaceArea(int height, int width, int[][] matrix, int surface_area) {
        for (int col = 0; col < width; col++) {
            for (int row = height - 1; row >= 0; row--) {

                if (row == height - 1) surface_area = add_to_surface_area(surface_area, matrix[row][col]);
                else surface_area = add_to_surface_area(surface_area, matrix[row][col] - matrix[row + 1][col]);
            }
        }
        return surface_area;
    }

    private static int getFrontSurfaceArea(int height, int width, int[][] matrix, int surface_area) {
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {

                if (row == 0) surface_area = add_to_surface_area(surface_area, matrix[row][col]);
                else surface_area = add_to_surface_area(surface_area, matrix[row][col] - matrix[row - 1][col]);
            }
        }
        return surface_area;
    }

    private static int add_to_surface_area(int surface_area, int to_add) {
        if (to_add > 0) {
            surface_area += to_add;
        }

        return surface_area;
    }
}
