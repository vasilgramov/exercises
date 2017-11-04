package hackerRank.contests.contest_hourRank24;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by vladix on 11/4/17.
 */
public class p01_strongPassword {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        String password = in.next();
        int length = password.length();

        int need = 0;
        if (!hasNumber(password)) need++;
        if (!hasLoweCase(password)) need++;
        if (!hasUpperCase(password)) need++;
        if (!hasSpecialCharacter(password)) need++;

        if (password.length() + need < 6) {
            need += 6 - (password.length() + need);
        }


        System.out.println(need);
    }

    private static boolean hasNumber(String pwd) {
        for (int i = 0; i < pwd.length(); i++) {
            if (pwd.charAt(i) >= 48 && pwd.charAt(i) <= 57) {
                return true;
            }
        }

        return false;
    }

    private static boolean hasLoweCase(String pwd) {
        for (int i = 0; i < pwd.length(); i++) {
            if (pwd.charAt(i) >= 97 && pwd.charAt(i) <= 122) {
                return true;
            }
        }

        return false;
    }

    private static boolean hasUpperCase(String pwd) {
        for (int i = 0; i < pwd.length(); i++) {
            if (pwd.charAt(i) >= 65 && pwd.charAt(i) <= 90) {
                return true;
            }
        }

        return false;
    }

    private static boolean hasSpecialCharacter(String pwd) {
        Set<Character> sc = new HashSet<>();
        String s = "!@#$%^&*()-+";
        char[] chars = s.toCharArray();
        for (char c : chars) {
            sc.add(c);
        }

        for (int i = 0; i < pwd.length(); i++) {
            if (sc.contains(pwd.charAt(i))) {
                return true;
            }
        }

        return false;
    }
}
