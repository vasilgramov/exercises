package hackerRank.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 7/24/17.
 */
public class hr_stringConstruction {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String string = in.next();
            System.out.println(stringConstruction(string));
        }
    }

    private static long stringConstruction(String s){
        return s.chars().distinct().count();
    }
}
