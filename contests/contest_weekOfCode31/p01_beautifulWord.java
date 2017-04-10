package hackerRank.contests.contest_weekOfCode31;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class p01_beautifulWord {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String word = in.nextLine();
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('y');

        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) == word.charAt(i + 1) ||
                    vowels.contains(word.charAt(i)) && vowels.contains(word.charAt(i + 1))) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}
