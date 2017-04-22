package hackerRank.contests.contest_101Hack44;

import java.util.ArrayList;
import java.util.Scanner;

public class p02_sillyGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 1; i <= 1000000; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        
        int numberOfGames = Integer.parseInt(in.nextLine());
        for (int i = 0; i < numberOfGames; i++) {
            int numberOfElements = Integer.parseInt(in.nextLine());

            int thePRIME = 0;
            for (int j = numberOfElements; j >= 1 ; j--) {
                if (isPrime(j)) {
                    thePRIME = j;
                    break;
                }
            }

            int indexOf = primes.indexOf(thePRIME);
            if (indexOf % 2 == 1 || indexOf < 0) {
                System.out.println("Bob");
            } else {
                System.out.println("Alice");
            }
        }
    }

    public static boolean isPrime(int number)
    {
        if (number < 2) return false;
        if (number % 2 == 0) return (number == 2);
        int root = (int)Math.sqrt((double)number);
        for (int i = 3; i <= root; i += 2)
        {
            if (number % i == 0) return false;
        }

        return true;
    }
}
