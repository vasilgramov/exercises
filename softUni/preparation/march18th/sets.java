package softUni.preparation.march18th;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class sets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> setByVertices = new HashMap<>();
            int vertices = Integer.parseInt(in.nextLine());
            String set = in.nextLine();
            for (int j = 1; j < set.length() + 1; j++) {
                char currentSet = set.charAt(j - 1);
                if (currentSet == 'A') {
                    setByVertices.put(j, 1);
                } else {
                    setByVertices.put(j, 2);
                }
            }

            int edges = Integer.parseInt(in.nextLine());
        }
    }
}
