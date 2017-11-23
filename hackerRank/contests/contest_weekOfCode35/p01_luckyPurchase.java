import java.util.Scanner;

public class p03 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        String result = "-1";
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String name = in.next();
            String priceAsString = in.next();

            int fours = 0;
            int sevens = 0;
            boolean isValid = true;
            for (int j = 0; j < priceAsString.length(); j++) {
                if (priceAsString.charAt(j) == '4') fours++;
                else if (priceAsString.charAt(j) == '7') sevens++;
                else {
                    isValid = false;
                    break;
                }
            }

            if (fours == sevens &&
                    isValid &&
                    Integer.parseInt(priceAsString) < minPrice) {
                result = name;
                minPrice = Integer.parseInt(priceAsString);
            }
        }


        if (result.equals("-1")) System.out.println(-1);
        else System.out.println(result);
    }
}
