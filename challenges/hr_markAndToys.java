package hackerRank.challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class hr_markAndToys {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        long K = in.nextLong();
        in.nextLine();

        List<Long> toyPrices = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            toyPrices.add(in.nextLong());
        }

        Collections.sort(toyPrices);

        long count = 0;
        for (int i = 0; i < toyPrices.size(); i++) {
            if (K <= 0 || toyPrices.get(i) > K) {
                break;
            } else {
                K -= toyPrices.get(i);
                count++;
            }
        }

        System.out.println(count);
    }
}
