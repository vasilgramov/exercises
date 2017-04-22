package hackerRank.contests.contest_weekOfCode30;

import java.util.Scanner;

public class p03_melodiousPassword {

    private static char[] password;

    private static char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
    private static char[] consonants = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z' };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        password = new char[n];

        genVowelsConsonants(n, "V");
        genConsonantsVowels(n, "C");
    }

    private static void genConsonantsVowels(int n, String type) {

    }

    private static void genVowelsConsonants(int n, String type) {

    }
}
