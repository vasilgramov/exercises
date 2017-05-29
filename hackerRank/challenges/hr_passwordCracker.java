package hackerRank.challenges;

import java.util.*;

/**
 * Created by vladix on 5/22/17.
 */
public class hr_passwordCracker {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();

            String[] words = new String[n];
            for (int j = 0; j < n; j++) {
                words[j] = in.next();
            }

            StringBuilder password = new StringBuilder(in.next());

            System.out.println(determineValidPass(words, password));
        }
    }

    private static String determineValidPass(String [] words, StringBuilder search){
        StringBuilder guess =
                new StringBuilder(search.toString());
        Arrays.sort(words, Collections.reverseOrder());

        for(int i = 0; i < words.length; ++i){
            int index1 = guess.indexOf(words[i]);
            int index2 = search.indexOf(words[i]);
            while(index1 >= 0){
                guess.delete(index1, (words[i].length() + index1));
                search.insert((words[i].length() +    index2), " ");

                index1 = guess.indexOf(words[i]);
                index2 = search.indexOf(words[i],
                        index2 + words[i].length());
            }
        }

        if(guess.length() > 0){
            search.setLength(0);
            search.append("WRONG PASSWORD");
        }

        return search.toString();
    }
}