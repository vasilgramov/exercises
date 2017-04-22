package softUni.preparation.march18th;

import java.util.Scanner;

public class sum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long sum = Long.parseLong(in.nextLine());
        StringBuilder builder = new StringBuilder(sum + "");

        for (int i = 0; i < builder.length(); i++) {
            char currentDigit = builder.charAt(i);
            builder.setCharAt(i, '0');
            sum += Long.parseLong(builder.toString());

            builder.setCharAt(i, currentDigit);
        }

        System.out.println(sum);
    }
}
