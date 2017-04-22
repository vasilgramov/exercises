package softUni.preparation.march18th;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class palindromes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<Long, Integer> countByNumber = new TreeMap<>();
        countByNumber.put(0L, 1);
        countByNumber.put(1L, 2);
        countByNumber.put(3L, 3);
        countByNumber.put(5L, 4);
        countByNumber.put(7L, 5);
        countByNumber.put(9L, 6);
        countByNumber.put(33L, 7);
        countByNumber.put(99L, 8);
        countByNumber.put(313L, 9);
        countByNumber.put(585L, 10);
        countByNumber.put(717L, 11);
        countByNumber.put(7447L, 12);
        countByNumber.put(9009L, 13);
        countByNumber.put(15351L, 14);
        countByNumber.put(32223L, 15);
        countByNumber.put(39993L, 16);
        countByNumber.put(53235L, 17);
        countByNumber.put(53835L, 18);
        countByNumber.put(73737L, 19);
        countByNumber.put(585585L, 20);
        countByNumber.put(1758571L, 21);
        countByNumber.put(1934391L, 22);
        countByNumber.put(1979791L, 23);
        countByNumber.put(3129213L, 24);
        countByNumber.put(5071705L, 25);
        countByNumber.put(5259525L, 26);
        countByNumber.put(5841485L, 27);
        countByNumber.put(13500531L, 28);
        countByNumber.put(719848917L, 29);
        countByNumber.put(910373019L, 30);
        countByNumber.put(939474939L, 31);
        countByNumber.put(1290880921L, 32);
        countByNumber.put(7451111547L, 33);
        countByNumber.put(10050905001L, 34);
        countByNumber.put(1846212648L, 35);
        countByNumber.put(32479297423L, 36);
        countByNumber.put(75015151057L, 37);
        countByNumber.put(110948849011L, 38);
        countByNumber.put(136525525631L, 39);
        countByNumber.put(1234104014321L, 40);
        countByNumber.put(1413899983141L, 41);
        countByNumber.put(1474922294741L, 42);
        countByNumber.put(1792704072971L, 43);

        long start = in.nextLong();
        long end = in.nextLong();

        int countStart = 0;
        int countEnd = 0;


        for (Map.Entry<Long, Integer> longIntegerEntry : countByNumber.entrySet()) {
            long num = longIntegerEntry.getKey();
            if (num - start >= 0) {
                countStart = longIntegerEntry.getValue();
                break;
            }
        }

        if (countByNumber.containsKey(end)) {
            countEnd = countByNumber.get(end) + 1;
        } else {
            for (Map.Entry<Long, Integer> longIntegerEntry : countByNumber.entrySet()) {
                long num = longIntegerEntry.getKey();
                if (end - num <= 0) {
                    countEnd = longIntegerEntry.getValue();
                    break;
                }
            }
        }


        System.out.println(countEnd - countStart);
    }
}
