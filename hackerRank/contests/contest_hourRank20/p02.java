package hackerRank.contests.contest_hourRank20;

import java.util.*;

/**
 * Created by vladix on 5/2/17.
 */
public class p02 {

//    public static void combinations(String suffix, String prefix) {
//        if (prefix.length() < 0) return;
//
//        if (suffix.length() >= 2 && suffix.length() % 2 == 0) {
//            char[] chars = suffix.toCharArray();
//            if (chars.length >= 2) {
//                Set<Character> characters = new HashSet<>();
//                for (char aChar : chars) {
//                    characters.add(aChar);
//                }
//
//                if ((characters.contains('a') && characters.contains('b')) &&
//                        !characters.contains('c') && !characters.contains('d')) {
//                    int aCount = 0;
//                    int bCount = 0;
//                    for (int i = 0; i < chars.length; i++) {
//                        if (chars[i] == 'a') {
//                            aCount++;
//                        } else {
//                            bCount++;
//                        }
//                    }
//
//                    if (aCount == bCount) {
//                        count++;
//                    }
//                } else if ((characters.contains('c') && characters.contains('d')) &&
//                        !characters.contains('a') && !characters.contains('b')) {
//                    int aCount = 0;
//                    int bCount = 0;
//                    for (int i = 0; i < chars.length; i++) {
//                        if (chars[i] == 'c') {
//                            aCount++;
//                        } else {
//                            bCount++;
//                        }
//                    }
//
//                    if (aCount == bCount) {
//                        count++;
//                    }
//                } else if ((characters.contains('c') && characters.contains('d')) &&
//                        (characters.contains('a') && characters.contains('b'))) {
//                    int aCount = 0;
//                    int bCount = 0;
//                    int cCount = 0;
//                    int dCount = 0;
//                    for (int i = 0; i < chars.length; i++) {
//                        if (chars[i] == 'a') {
//                            aCount++;
//                        } else if (chars[i] == 'b') {
//                            bCount++;
//                        } else if (chars[i] == 'c') {
//                            cCount++;
//                        } else {
//                            dCount++;
//                        }
//                    }
//
//                    if (aCount == bCount && cCount == dCount) {
//                        count++;
//                    }
//                }
//            }
//        }
//
//        for (int i = 0; i < prefix.length(); i++)
//            combinations(suffix + prefix.charAt(i), prefix.substring(i + 1, prefix.length()));
//    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String str = in.next();
            Map<Character, Integer> countByChar = new HashMap<>();
            countByChar.put('a', 0);
            countByChar.put('b', 0);
            countByChar.put('c', 0);
            countByChar.put('d', 0);
            for (int j = 0; j < str.length(); j++) {
                char currentChar = str.charAt(j);

                if (currentChar == 'a' || currentChar == 'b' || currentChar == 'c' || currentChar == 'd') {
                    countByChar.put(currentChar, countByChar.get(currentChar) + 1);
                }
            }

            int aCount = countByChar.get('a');
            int bCount = countByChar.get('b');
            int cCount = countByChar.get('c');
            int dCount = countByChar.get('d');
            long count = (countByChar.get('a') * countByChar.get('b')) +
                    (countByChar.get('c') * countByChar.get('d')) +
                    Math.min((Math.min(aCount, bCount)), (Math.min(cCount, dCount)));

            System.out.println(count % 1000000007);
        }
    }
}
