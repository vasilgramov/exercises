package softUni.preparation.april2th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class earth {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

//        int t = Integer.parseInt(in.readLine());
//        for (int i = 0; i < t; i++) {


            int n = Integer.parseInt(in.readLine());
            int copy = n;

            int counter = 0;
            while (n > 0) {
                int c = (int)Math.sqrt(n);

                System.out.println("Number: " + n);
                System.out.println("Multiplier: " + c);

                n -= c * c;
            }

            n = copy;



//        }


    }
}
