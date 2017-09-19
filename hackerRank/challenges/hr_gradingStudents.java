package hackerRank.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 9/19/17.
 */
public class hr_gradingStudents {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int note = in.nextInt();
            if (note < 38) {
                System.out.println(note);
                continue;
            }

            if (note % 5 >= 3) {
                System.out.println(note + 5 - (note % 5));
            } else {
                System.out.println(note);
            }
        }
    }
}
