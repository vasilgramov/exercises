package hackerRank.challenges;

import java.util.HashSet;
import java.util.Scanner;

public class hr_gemStones {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        HashSet<Character> gems = new HashSet<>();
        int n = Integer.parseInt(in.nextLine());

        String firstInput = in.nextLine();
        for (int i = 0; i < firstInput.length(); i++) {
            gems.add(firstInput.charAt(i));
        }

        for (int i = 1; i < n; i++) {
            char[] currentInput = in.nextLine().toCharArray();
            HashSet<Character> newSet = new HashSet<>();
            for (int j = 0; j < currentInput.length; j++) {
                newSet.add(currentInput[j]);
            }

            gems.retainAll(newSet);
        }

        System.out.println(gems.size());
    }
}
