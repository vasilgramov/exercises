package hackerRank.challenges;

import java.util.*;

/**
 * Created by vladix on 5/8/17.
 */
public class hr_sherlockAndAnagrams {

    // algorithms -> strings
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String string = in.next();

            List<String> allSubstrings = generate(string);
            Collections.sort(allSubstrings);
            int count = getNumberOfEqualSubstrings(0, allSubstrings);

            System.out.println(count);
        }
    }

    private static int getNumberOfEqualSubstrings(int count, List<String> allSubstrings) {
        for (int j = 0; j < allSubstrings.size(); j++) {
            String one = allSubstrings.get(j);

            for (int k = j + 1; k < allSubstrings.size(); k++) {
                String two = allSubstrings.get(k);

                if (one.length() == two.length() &&
                        one.equals(two)) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    private static List<String> generate(String word) { // generates and sorts all substrings alphabetically
        List<String> substr = new ArrayList<>();

        for (int from = 0; from < word.length(); from++) {
            for (int to = from + 1; to <= word.length(); to++) {
                String substring = word.substring(from, to);
                char[] chars = substring.toCharArray();
                Arrays.sort(chars);
                substr.add(String.valueOf(chars));
            }
        }

        return substr;
    }
}
