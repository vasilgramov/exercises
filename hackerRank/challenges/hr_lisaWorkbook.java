package hackerRank.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 8/24/17.
 */
public class hr_lisaWorkbook {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        int counter = 0;
        int pages = 1;

        int multiplier = 1;
        for (int i = 0; i < n; i++) {
            int problems = in.nextInt();

            for (int j = 1; j <= problems; j++) {
                if (j > k * multiplier) {
                    pages++;
                    multiplier++;
                }

                if (j == pages) {
                    counter++;
                }
            }

            pages++;
            multiplier = 1;
        }

        System.out.println(counter);
    }
}
