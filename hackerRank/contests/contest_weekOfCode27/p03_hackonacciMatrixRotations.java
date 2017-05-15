package hackerRank.contests.contest_weekOfCode27;

import java.util.*;

/**
 * Created by vladix on 5/15/17.
 */
public class p03_hackonacciMatrixRotations {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        StringBuilder result = new StringBuilder();

        int[] evens_odds = new int[7];
        fill_even_odds(evens_odds);

        int n = in.nextInt();
        int t = in.nextInt();
        char[][] matrix = new char[n][n];

        fill_matrix(matrix, evens_odds);

        Map<Integer, Integer> countByRotation = new HashMap<>();

        for (int i = 0; i < t; i++) {
            int angle = in.nextInt() % 360;

            if (countByRotation.containsKey(angle)) {
                result.append(countByRotation.get(angle)).append(System.lineSeparator());
                continue;
            }

            int diff = 0;
            if (angle == 0) {
                diff = 0;
            } else if (angle == 90) {
                int original_row_index = 0;

                for (int col = 0; col < n; col++) {
                    int original_col_index = 0;
                    for (int row = n - 1; row >= 0; row--) {
                        int original_char = matrix[original_row_index][original_col_index];
                        int current_char = matrix[row][col];

                        if (original_char != current_char) {
                            diff++;
                        }

                        original_col_index++;
                    }

                    original_row_index++;
                }
            } else if (angle == 180) {
                int original_row_index = 0;

                for (int row = n - 1; row >= 0; row--) {
                    int original_col_index = 0;
                    for (int col = n - 1; col >= 0; col--) {
                        int original_char = matrix[original_row_index][original_col_index];
                        int current_char = matrix[row][col];

                        if (current_char != original_char) {
                            diff++;
                        }

                        original_col_index++;
                    }

                    original_row_index++;
                }
            } else if (angle == 270) {
                int original_row_index = 0;

                for (int col = n - 1; col >= 0; col--) {
                    int original_col_index = 0;
                    for (int row = 0; row < n; row++) {
                        int original_char = matrix[original_row_index][original_col_index];
                        int current_char = matrix[row][col];

                        if (current_char != original_char) {
                            diff++;
                        }

                        original_col_index++;
                    }

                    original_row_index++;
                }
            }

            result.append(diff).append(System.lineSeparator());
            countByRotation.put(angle, diff);
        }

        System.out.println(result);
    }

    private static void print_hackonacci() {
        List<Long> hackonacci = new ArrayList<>();
        hackonacci.add(1L);
        hackonacci.add(2L);
        hackonacci.add(3L);

        for (int i = 0; i < 32; i++) {
            int size = hackonacci.size();

            hackonacci.add(hackonacci.get(size - 1) +
                hackonacci.get(size - 2) * 2 +
                hackonacci.get(size - 3) * 3);
        }

        for (int i = 0; i < hackonacci.size(); i++) {
            System.out.println(hackonacci.get(i) % 2);
        }
    }

    private static void print_matrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }

    private static void fill_even_odds(int[] evens_odds) {
        evens_odds[0] = 1;
        evens_odds[1] = 0;
        evens_odds[2] = 1;
        evens_odds[3] = 0;
        evens_odds[4] = 0;
        evens_odds[5] = 1;
        evens_odds[6] = 1;
    }

    private static void fill_matrix(char[][] matrix, int[] evens_odds) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                int current_row = row + 1;
                int current_col = col + 1;

                long current_index =
                        (long)Math.pow(current_row * current_col, 2) % 7;

                if (current_index == 0) {
                    current_index = 6;
                } else {
                    current_index--;
                }

                if (current_index < 0 || current_index >= 7) {
                    System.out.println("DEBUG");
                }

                boolean isEven = evens_odds[(int)current_index] == 0;
                matrix[row][col] = isEven ? 'X' : 'Y';
            }
        }
    }
}
