package hackerRank.challenges;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * Created by vladix on 5/4/17.
 */
public class hr_javaMD5 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner in = new Scanner(System.in);
        String plaintext = in.next();
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(plaintext.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        StringBuilder hash_text = new StringBuilder(bigInt.toString(16));
        while(hash_text.length() < 32 ){
            hash_text.insert(0, "0");
        }

        System.out.println(hash_text);
    }
}
