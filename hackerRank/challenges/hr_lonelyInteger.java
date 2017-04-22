// https://www.hackerrank.com/challenges/lonely-integer?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
package hackerRank.challenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hr_lonelyInteger {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        HashMap<Integer, Integer> appearanceByInteger = new HashMap<>();

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            int currentNumber = in.nextInt();
            if (!appearanceByInteger.containsKey(currentNumber)) {
                appearanceByInteger.put(currentNumber, 0);
            }

            appearanceByInteger.put(currentNumber, appearanceByInteger.get(currentNumber) + 1);
        }

        System.out.println(findTheLonlyInteger(appearanceByInteger));
    }

    public static Integer findTheLonlyInteger(HashMap<Integer, Integer> appearanceByInteger) {
        for (Map.Entry<Integer, Integer> entry : appearanceByInteger.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            if (value == 1) {
                return key;
            }
        }

        return 0;
    }
}
