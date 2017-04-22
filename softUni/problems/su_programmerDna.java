package softUni.problems;// https://judge.softuni.bg/Contests/Practice/Index/9#2

import java.util.Scanner;

public class su_programmerDna {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        char letter = in.next().charAt(0);

        int counter = 0;
        boolean isIncreasing = true;
        for (int i = 0; i < n; i++) {
            if (counter == 0) {
                System.out.println("..." + letter + "...");

                letter++;
                if (letter == 'H') {
                    letter = 'A';
                }

                if (!isIncreasing) {
                    isIncreasing = true;
                    counter = -1;
                }
            } else if (counter == 1) {
                System.out.print("..");
                for (int j = 0; j < 3; j++) {
                    System.out.print(letter);
                    letter++;
                    if (letter == 'H') {
                        letter = 'A';
                    }
                }
                System.out.println("..");
            } else if (counter == 2) {
                System.out.print(".");
                for (int j = 0; j < 5; j++) {
                    System.out.print(letter);
                    letter++;
                    if (letter == 'H') {
                        letter = 'A';
                    }
                }
                System.out.println(".");
            } else if (counter == 3) {
                for (int j = 0; j < 7; j++) {
                    System.out.print(letter);
                    letter++;
                    if (letter == 'H') {
                        letter = 'A';
                    }
                }
                System.out.println();
                isIncreasing = false;
            }

            if (isIncreasing) {
                counter++;
            } else {
                counter--;
            }
        }
    }
}