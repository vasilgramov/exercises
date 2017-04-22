// https://www.hackerrank.com/challenges/the-grid-search?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
package hackerRank.challenges;

import java.util.Scanner;

public class hr_theGridSearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int tests = Integer.parseInt(in.nextLine());
        for (int i = 0; i < tests; i++) {
            boolean hasFound = false;

            String[] gridParams = in.nextLine().split("\\s+");
            int gridRows = Integer.parseInt(gridParams[0]);

            String[] grid = new String[gridRows];
            for (int j = 0; j < gridRows; j++) {
                grid[j] = in.nextLine();
            }

            String[] patternParams = in.nextLine().split("\\s+");
            int patternRows = Integer.parseInt(patternParams[0]);

            String[] pattern = new String[patternRows];
            for (int j = 0; j < patternRows; j++) {
                pattern[j] = in.nextLine();
            }

//            pirntArray(grid);
//            pirntArray(pattern);

            int gridRow = 0;
            int patternRow = 0;
            for (int j = 0; j <= gridRows - patternRows; j++) {
                String g = grid[j + gridRow].trim();
                String p = pattern[patternRow].trim();
                if (g.contains(p)) {
                    int start = g.indexOf(p.charAt(0));
                    int end = start + p.length();

                    //System.out.println(g.substring(start, end));

                    gridRow++;
                    patternRow++;

                    while (true) {
                        String gridPeace = grid[j + gridRow].trim().substring(start, end);
                        String patternPeace = pattern[patternRow].trim();
                        if (!gridPeace.equals(patternPeace)) {
                            gridRow = 0;
                            patternRow = 0;
                            break;
                        }

                        gridRow++;
                        patternRow++;

                        if (patternRow >= patternRows) {
                            System.out.println("YES");
                            hasFound = true;
                            break;
                        }
                    }
                }

                if (hasFound) {
                    break;
                }
            }

            if (!hasFound) {
                System.out.println("NO");
            }
        }
    }
    
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void pirntArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}




//import java.util.Scanner;
//
//public class hr_theGridSearch1 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        int tests = Integer.parseInt(in.nextLine());
//        for (int i = 0; i < tests; i++) {
//            String[] gridArgs = in.nextLine().split("\\s+");
//            int gridRows = Integer.parseInt(gridArgs[0]);
//            int gridCols = Integer.parseInt(gridArgs[1]);
//
//            int[][] grid = new int[gridRows][gridCols];
//
//            for (int j = 0; j < gridRows; j++) {
//                char[] currentLine = in.nextLine().trim().toCharArray();
//                for (int k = 0; k < gridCols; k++) {
//                    grid[j][k] = Integer.parseInt(Character.toString(currentLine[k]));
//                }
//            }
//
//            String[] patternArgs = in.nextLine().split("\\s+");
//            int patternRows = Integer.parseInt(patternArgs[0]);
//            int patternCols = Integer.parseInt(patternArgs[1]);
//
//            int[][] pattern = new int[patternRows][patternCols];
//
//            for (int j = 0; j < patternRows; j++) {
//                char[] currentLine = in.nextLine().trim().toCharArray();
//                for (int k = 0; k < patternCols; k++) {
//                    pattern[j][k] = Integer.parseInt(Character.toString(currentLine[k]));
//                }
//            }
//
////            printMatrix(grid);
////            System.out.println("--------------------------");
////            printMatrix(pattern);
//
//            boolean hasFound = false;
//            outerloop:
//            for (int j = 0; j <= gridRows - patternRows; j++) {
//                for (int k = 0; k <= gridCols - patternCols; k++) {
//                    gridLoop:
//                    for (int l = 0; l < patternRows; l++) {
//                        for (int m = 0; m < patternCols; m++) {
//                            if (grid[j + l][k + m] == pattern[l][m]) {
//                                hasFound = true;
//                                if (l == patternRows - 1 && m == patternCols - 1) {
//                                    System.out.println("YES");
//                                    break outerloop;
//                                }
//                            } else {
//                                hasFound = false;
//                                break gridLoop;
//                            }
//                        }
//                    }
//                }
//            }
//
//            if (!hasFound) {
//                System.out.println("NO");
//            }
//        }
//    }
//
//    private static void printMatrix(int[][] matrix) {
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//}

