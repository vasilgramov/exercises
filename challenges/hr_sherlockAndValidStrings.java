package hackerRank.challenges;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class hr_sherlockAndValidStrings {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<Character, Integer> countByCharacter = new LinkedHashMap<>();

        char[] input = in.nextLine().toCharArray();
        for (int i = 0; i < input.length; i++) {
            if (!countByCharacter.containsKey(input[i])) {
                countByCharacter.put(input[i], 1);
            } else {
                countByCharacter.put(input[i], countByCharacter.get(input[i]) + 1);
            }
        }

        boolean hasFound = false;
        int count = countByCharacter.entrySet().iterator().next().getValue();
        for (Integer integer : countByCharacter.values()) {
            if (count != integer && hasFound) {
                System.out.println("NO");
                return;
            }

            if (count != integer) {
                hasFound = true;
            }
        }

        System.out.println("YES");
    }
}
