package hackerRank.justProblems;// https://www.hackerrank.com/challenges/bigger-is-greater

import java.util.Arrays;
import java.util.Scanner;

public class hr_biggerIsGreater {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //int n = Integer.parseInt(in.nextLine());
        //for (int i = 0; i < n; i++) {
        while (true) {
            char[] word = in.nextLine().toCharArray();
            char[] copyWord =word.clone();
            boolean hasBroke = false;
            for (int j = word.length - 1; j >= 2 ; j--) {
                if (word[j] > word[j - 1]) {
                    hasBroke = true;
                    char temp = word[j];
                    word[j] = word[j - 1];
                    word[j - 1] = temp;
                    System.out.println(new String(word));
                    break;
                } else if (copyWord[j] > copyWord[j - 1]) {
                    hasBroke = true;
                    word = copyWord;
                    char temp = word[j];
                    word[j] = word[j - 1];
                    word[j - 1] = temp;

                    StringBuilder builder1 = new StringBuilder();
                    for (int k = 0; k < j; k++) {
                        builder1.append(copyWord[k]);
                    }

                    char[] newChArr = Arrays.copyOfRange(word, j, word.length);
                    Arrays.sort(newChArr);
                    for (int k = 0; k < newChArr.length; k++) {
                        builder1.append(newChArr[k]);
                    }
                    System.out.println(builder1.toString());
                    break;
                }else {
                    char temp = word[j];
                    word[j] = word[j - 1];
                    word[j - 1] = temp;
                }
            }

            if (hasBroke) {
                continue;
            }

            if (copyWord.length > 1 && copyWord[0] == copyWord[1]) {
                System.out.println("no answer");
                continue;
            }

            char firstChar = word[0];
            Arrays.sort(word);
            int index = new String(word).indexOf(firstChar) + 1;
            if (index < word.length && word.length > 1 && word[0] != word[1]) {
                char newFirstChar = word[index];
                StringBuilder builder = new StringBuilder();
                builder.append(newFirstChar);
                for (int j = 0; j < word.length; j++) {
                    if (j != index) {
                        builder.append(word[j]);
                    }
                }

                System.out.println(builder.toString());
            } else {
                System.out.println("no answer");
            }
        }
    }
}