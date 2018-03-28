package hackerRank.challenges;

import java.security.MessageDigest;
import java.util.Scanner;

public class hr_sha256 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.next();
        System.out.println(sha256(input));
    }

    private static String sha256(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
