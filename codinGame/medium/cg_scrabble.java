package codinGame.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by vladix on 5/12/17.
 */
public class cg_scrabble {

    private static Map<Character, Integer> pointsByCharacter = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        fillPoints();

        int n = in.nextInt();
        Word[] words = new Word[n];

        for (int i = 0; i < n; i++) {
            String chars = in.next();

            Word word = new Word(chars);
            words[i] = word;
        }

        String letters = in.next();
        Word lettersAsWord = new Word(letters);

        Word maxWord = null;
        for (Word word : words) {
            if (canCombine(lettersAsWord, word)) {
                calculateWeight(word);

                if (maxWord == null) {
                    maxWord = word;
                } else if (word.weight > maxWord.weight) {
                    maxWord = word;
                }
            }
        }

        System.out.println(maxWord.value);
    }

    private static void calculateWeight(Word word) {
        String value = word.value;
        int weight = 0;
        for (int i = 0; i < value.length(); i++) {
            weight += pointsByCharacter.get(value.charAt(i));
        }


        word.weight = weight;
    }

    private static boolean canCombine(Word lettersAsWord, Word word) {
        Map<Character, Integer> letters = lettersAsWord.countByCharacter;
        Map<Character, Integer> wordLetters = word.countByCharacter;

        for (Map.Entry<Character, Integer> countBySymbol : wordLetters.entrySet()) {
            char key = countBySymbol.getKey();
            int count = countBySymbol.getValue();

            if (letters.containsKey(key) && letters.get(key) >= count) {
                // continue
            } else {
                return false;
            }
        }

        return true;
    }

    private static class Word {
        private String value;
        private Map<Character, Integer> countByCharacter;

        private int weight;

        public Word(String value) {
            this.value = value;
            this.countByCharacter = new HashMap<>();
            char[] chars = value.toCharArray();
            for (char c : chars) {
                if (!this.countByCharacter.containsKey(c)) {
                    this.countByCharacter.put(c, 1);
                } else {
                    this.countByCharacter.put(c, this.countByCharacter.get(c) + 1);
                }
            }
        }
    }

    private static void fillPoints() {
        pointsByCharacter.put('a', 1);
        pointsByCharacter.put('e', 1);
        pointsByCharacter.put('i', 1);
        pointsByCharacter.put('o', 1);
        pointsByCharacter.put('n', 1);
        pointsByCharacter.put('r', 1);
        pointsByCharacter.put('r', 1);
        pointsByCharacter.put('t', 1);
        pointsByCharacter.put('l', 1);
        pointsByCharacter.put('s', 1);
        pointsByCharacter.put('u', 1);

        pointsByCharacter.put('d', 2);
        pointsByCharacter.put('g', 2);
        pointsByCharacter.put('b', 3);
        pointsByCharacter.put('c', 3);
        pointsByCharacter.put('m', 3);
        pointsByCharacter.put('p', 3);

        pointsByCharacter.put('f', 4);
        pointsByCharacter.put('h', 4);
        pointsByCharacter.put('v', 4);
        pointsByCharacter.put('w', 4);
        pointsByCharacter.put('y', 4);

        pointsByCharacter.put('k', 5);

        pointsByCharacter.put('j', 8);
        pointsByCharacter.put('x', 8);

        pointsByCharacter.put('q', 10);
        pointsByCharacter.put('z', 10);
    }
}
