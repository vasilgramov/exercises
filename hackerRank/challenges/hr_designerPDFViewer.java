package hackerRank.challenges;

import java.util.Scanner;

/**
 * Created by vladix on 9/19/17.
 */
public class hr_designerPDFViewer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] wordsHeight = new int[26];
        for (int i = 0; i < wordsHeight.length; i++) {
            wordsHeight[i] = in.nextInt();
        }

        String word = in.next();
        int highestChar = -1;
        for (int i = 0; i < word.length(); i++) {
            int height = wordsHeight[word.charAt(i) - 97];
            if (height > highestChar) {
                highestChar = height;
            }
        }

        System.out.println(highestChar * word.length());
    }
}
