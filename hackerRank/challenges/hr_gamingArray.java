package hackerRank.challenges;

import java.util.*;

public class hr_gamingArray {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            int length = Integer.parseInt(in.nextLine());
            String line = in.nextLine();

            int[] numbers = fillArray(line);
            Map<Integer, Integer> numberByIndex = fillNumbersByIndex(numbers);

            int toIndex = Integer.MAX_VALUE;
            int moves = 0;
            moves = getGameMoves(numberByIndex, toIndex, moves);

            System.out.println(moves % 2 == 0 ? "ANDY" : "BOB");
        }
    }

    private static int getGameMoves(Map<Integer, Integer> numberByIndex, int toIndex, int moves) {
        for (Map.Entry<Integer, Integer> kvp : numberByIndex.entrySet()) {
            int index = kvp.getValue();
            if (toIndex < index) continue;

            moves++;
            toIndex = index;
            if (index == 0) break;
        }
        return moves;
    }

    private static Map<Integer, Integer> fillNumbersByIndex(int[] numbers) {
       Map<Integer, Integer> numbersByIndex = new TreeMap<>(Collections.reverseOrder());

        for (int i = 0; i < numbers.length; i++) {
            numbersByIndex.put(numbers[i], i);
        }

        return numbersByIndex;
    }

    private static int[] fillArray(String line) {
        String[] tokens = line.split(" ");
        int[] numbers = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = Integer.parseInt(tokens[i]);
        }

        return numbers;
    }
}
