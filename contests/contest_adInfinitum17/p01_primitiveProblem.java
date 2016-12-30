package hackerRank.contests.contest_adInfinitum17;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;

public class p01_primitiveProblem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long p = Long.parseLong(in.nextLine());
        long originalP = p;
        if (isPrime(p)) {
            p -= 1;
        }

        HashSet<Integer> primeFactors = getPrimeFactors(p);

        long leastPrimitiveRoot = findLeastPrimitiveRoot(primeFactors, originalP, p);

        long numberOfPrimitiveRoots = eulerTotientFunction(p);

        System.out.print(leastPrimitiveRoot + " " + numberOfPrimitiveRoots);
    }

    private static long findLeastPrimitiveRoot(HashSet<Integer> primeFactors, long originalP, long fakeP) {
        for (long i = 2; i <= fakeP; i++) {
            boolean hasFound = true;
            for (Integer q : primeFactors) {
                BigInteger bi1 = new BigInteger(Long.toString(i));
                BigInteger bi2 = new BigInteger(Long.toString(fakeP / q));

                BigInteger bi3 = bi1.pow(Integer.parseInt(bi2.toString()));
                BigInteger bi4 = new BigInteger(Long.toString(originalP));

                if (bi3.mod(bi4).toString().equals("1")) {
                    hasFound = false;
                    break;
                }
            }

            if (hasFound) {
                return i;
            }
        }


        return -1;
    }

    private static long eulerTotientFunction(long n) {
        long result = n;
        for (long i = 2; i <= n / i; i++) {
            if (n % i == 0)
                result -= result / i;
            while (n % i == 0)
                n /= i;
        }
        if (n > 1)
            result -= result / n;

        return result;
    }

    private static HashSet<Integer> getPrimeFactors(long p) {
        HashSet<Integer> primeFactors = new HashSet<>();

        long copy = p;
        int n = 2;
        while (copy > 1) {
            if (copy % n == 0) {
                primeFactors.add(n);
                copy /= n;
            } else {
                if (isPrime(n) && copy < n) {
                    primeFactors.add(n);
                    return primeFactors;
                }
                n++;
            }
        }

        return primeFactors;
    }

    private static boolean isPrime(long number) {
        if (number == 1) return false;
        if (number == 2) return true;

        for (int i = 2; i <= Math.ceil(Math.sqrt(number)); ++i) {
            if (number % i == 0) return false;
        }

        return true;
    }
}