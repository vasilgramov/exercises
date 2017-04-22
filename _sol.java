import java.io.*;

public class _sol {

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("diagonalsum.in");
        FileWriter fw = new FileWriter("diagonalsum.out");

        BufferedReader br = new BufferedReader(fr);
        BufferedWriter bw = new BufferedWriter(fw);

        int n = Integer.parseInt(br.readLine());
        long[] main1 = new long[2 * n - 1];
        long[] main2 = new long[2 * n - 1];

        int[][] matrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            String[] rowTokes = br.readLine().split("\\s+");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = Integer.parseInt(rowTokes[col]);
            }
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            String[] cellArgs = br.readLine().split("\\s+");
            int cellRow = Integer.parseInt(cellArgs[0]) - 1;
            int cellCol = Integer.parseInt(cellArgs[1]) - 1;

            long sum = 0L;

            int main1Search = cellRow - cellCol + n - 1;
            int main2Search = cellCol + cellRow;

            long currentSum = 0L;
            int shiftRow = 0;
            int shiftCol = 0;

            if (main1[main1Search] == 0) {
                while (cellRow - shiftRow >= 0 && cellCol - shiftCol >= 0) {
                    currentSum += matrix[cellRow - shiftRow][cellCol - shiftCol];
                    shiftRow++;
                    shiftCol++;
                }

                shiftRow = 1;
                shiftCol = 1;
                while (cellRow + shiftRow < n && cellCol + shiftCol < n) {
                    currentSum += matrix[cellRow + shiftRow][cellCol + shiftCol];
                    shiftRow++;
                    shiftCol++;
                }

                main1[main1Search] = currentSum;
                sum += currentSum;
            } else {
                sum += main1[main1Search];
            }

            if (main2[main2Search] == 0) {
                currentSum = 0L;
                shiftRow = 0;
                shiftCol = 0;

                while (cellRow - shiftRow >= 0 && cellCol + shiftCol < n) {
                    currentSum += matrix[cellRow - shiftRow][cellCol + shiftCol];
                    shiftRow++;
                    shiftCol++;
                }


                shiftRow = 1;
                shiftCol = 1;
                while (cellRow + shiftRow < n && cellCol - shiftCol >= 0) {
                    currentSum += matrix[cellRow + shiftRow][cellCol - shiftCol];
                    shiftRow++;
                    shiftCol++;
                }

                main2[main2Search] = currentSum;
                sum += currentSum;
            } else {
                sum += main2[main2Search];
            }

            bw.write((sum - matrix[cellRow][cellCol]) + "\n");
        }

        bw.flush();
    }
}
