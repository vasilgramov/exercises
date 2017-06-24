package hackerRank.challenges;

import java.util.*;

public class hr_twoCharacters {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        String string = in.next();

        Map<Character, Integer> countByCharacter = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);

            if (!countByCharacter.containsKey(c)) {
                countByCharacter.put(c, 0);
            }

            countByCharacter.put(c, countByCharacter.get(c) + 1);
        }

        List<Map.Entry<Character, Integer>> sorted = new ArrayList<>();
        countByCharacter.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .forEach(sorted::add);

        for (int i = 0; i < sorted.size(); i++) {
            char f = sorted.get(i).getKey();
            for (int j = i + 1; j < sorted.size(); j++) {
                char s = sorted.get(j).getKey();

                char last = '0';
                boolean isValid = true;
                for (int k = 0; k < string.length(); k++) {
                    if (string.charAt(k) == f || string.charAt(k) == s) {
                        if (string.charAt(k) == f && last == f) {
                            isValid = false;
                            break;
                        }

                        if (string.charAt(k) == s && last == s) {
                            isValid = false;
                            break;
                        }

                        last = string.charAt(k);
                    }
                }

                if (isValid) {
                    System.out.println(sorted.get(i).getValue() + sorted.get(j).getValue());
                    return;
                }
            }
        }

        System.out.println(0);
    }
}
