package hackerRank.challenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hr_gameOfThronesI {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        HashMap<Character, Integer> appearanceByCharacter = new HashMap<>();
        String input = in.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (!appearanceByCharacter.containsKey(currentChar)) {
                appearanceByCharacter.put(currentChar, 0);
            }

            appearanceByCharacter.put(currentChar, appearanceByCharacter.get(currentChar) + 1);
        }

        if (isPalindrome(appearanceByCharacter, input)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean isPalindrome(HashMap<Character, Integer> appearanceByCharacter, String input) {
        if (input.length() % 2 == 0) {  // every appearance should be even
            for (Map.Entry<Character, Integer> entry : appearanceByCharacter.entrySet()) {
                Integer value = entry.getValue();
                if (value % 2 == 1) {
                    return false;
                }
            }

            return true;
        } else {
            boolean hasFound = false;
            for (Map.Entry<Character, Integer> entry : appearanceByCharacter.entrySet()) {
                Integer value = entry.getValue();
                if (value % 2 == 1 && !hasFound) {
                    hasFound = true;
                    continue;
                }

                if (hasFound && value % 2 == 1) {
                    return false;
                }
            }

            return true;
        }
    }
}
