package softUni.problems;// https://judge.softuni.bg/Contests/Practice/Index/181#4

import java.util.Scanner;

public class su_stopSign {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        System.out.println(newString(".", n + 1) + newString("_", n * 2 + 1) + newString(".", n + 1));

        int help = 0;
        int slashCounter = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(newString(".", n - i) + "//" + newString("_", n * 2 - 1 + help) + "\\\\" + newString(".", n - i));
            help += 2;

            slashCounter = n * 2 - 1 + help;
        }

        slashCounter -= 5;
        System.out.println("//" + newString("_", slashCounter / 2) + "STOP!" + newString("_", slashCounter / 2) + "\\\\");

        System.out.println(newString(".", n - 1) + "\\\\" + newString("_", n * 2 + 1) + "//" + newString(".", n - 1));
    }

    public static String newString(String text, int repeatCount) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < repeatCount; i++) {
            builder.append(text);
        }

        return builder.toString();
    }
}


