package codinGame.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by vladix on 5/3/17.
 */
public class cg_conwaySequence {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int startNumber = in.nextInt();
        int desiredLine = in.nextInt();

        List<Integer> line = new ArrayList<>();
        line.add(startNumber);

        for (int i = 1; i < desiredLine; i++) {
            List<Integer> nextLine = new ArrayList<>();
            for (int j = 0; j < line.size(); j++) {
                int count = 0;
                int currentNum = line.get(j);
                while (j < line.size() && currentNum == line.get(j)) {
                    j++;
                    count++;
                }

                nextLine.add(count);
                nextLine.add(currentNum);
                j--;
            }

            line = nextLine;
        }

        System.out.println(line.toString().replace(",", "")
                .replace("[", "")
                .replace("]", ""));
    }
}
