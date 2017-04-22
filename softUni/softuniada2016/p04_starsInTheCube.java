package softUni.softuniada2016;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p04_starsInTheCube {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        String[][][] cube = new String[n][n][n];
        for (int i = 0; i < n; i++) {
            String[] line = in.nextLine().split("\\s+|\\|+");

            int index = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (line[index].equals("")) {
                        index++;
                        k--;
                        continue;
                    }
                    cube[j][i][k] = line[index];
                    index++;
                }
            }
        }

//        printCube(cube, n);

        int numberOfStars = 0;
        char[] starsCountsByLetter = new char['z' - 'a' + 1];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 1; j < n - 1; j++) {
                for (int k = 1; k < n - 1; k++) {
                    if (cube[i][j][k].equals(cube[i + 1][j][k]) &&
                            cube[i][j][k].equals(cube[i + 1][j - 1][k]) &&
                            cube[i][j][k].equals(cube[i + 1][j + 1][k]) &&
                            cube[i][j][k].equals(cube[i + 1][j][k + 1]) &&
                            cube[i][j][k].equals(cube[i + 1][j][k - 1]) &&
                            cube[i][j][k].equals(cube[i + 2][j][k])) {
                        numberOfStars++;
                        starsCountsByLetter[cube[i][j][k].charAt(0) - 'a']++;
                    }
                }
            }
        }

        System.out.println(numberOfStars);
        for (char letter = 'a'; letter <= 'z'; letter++)
        {
            int count = starsCountsByLetter[letter - 'a'];
            if (count > 0)
            {
                System.out.println(letter + " -> " + count);
            }
        }
    }

    private static void printCube(String[][][] cube, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.print(cube[i][j][k]);
                }
                System.out.println();
            }

            System.out.println("---------------------------------");
        }
    }
}
