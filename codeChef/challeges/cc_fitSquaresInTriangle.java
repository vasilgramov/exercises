package codeChef.challeges;

import java.util.Scanner;

/**
 * Created by vladix on 5/5/17.
 */
public class cc_fitSquaresInTriangle {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] result = new int[10002];
        result[0] = 0;
        result[1] = 0;
        int current_result = 0;
        int to_add = 1;
        int added_count = 2;
        for (int i = 2; i < result.length - 1; i += 2) {
            result[i] = current_result;
            result[i + 1] = current_result;
            current_result = to_add;
            to_add += added_count;
            added_count++;
        }

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            int base = in.nextInt();

            System.out.println(result[base]);
        }
    }
}
