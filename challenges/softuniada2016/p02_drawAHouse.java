package hackerRank.challenges.softuniada2016;

import java.util.Scanner;

public class p02_drawAHouse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        System.out.println(newString(n - 1, ".") + "*" + newString(n - 1, "."));

        int emptySpaces = 1;
        for (int i = 0; i < n - 2; i++) {
            System.out.println(newString(n - 2 - i, ".") + "*" + newString(emptySpaces, " ") + "*" + newString(n - 2 - i, "."));
            emptySpaces += 2;
        }

        for (int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        System.out.println();

        System.out.println("+" + newString(n * 2 - 3, "-") + "+");

        for (int i = 0; i < n - 2; i++) {
            System.out.println("|" + newString(n * 2 - 3, " ") + "|");
        }

        System.out.println("+" + newString(n * 2 - 3, "-") + "+");
    }

    private static String newString(int n, String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(str);
        }

        return builder.toString();
    }
}
