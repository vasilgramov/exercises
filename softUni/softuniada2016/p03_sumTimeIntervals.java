package softUni.softuniada2016;

import java.util.Scanner;

public class p03_sumTimeIntervals {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] firstDateArgs = in.nextLine().split(":");
        String[] secondDateArgs = in.nextLine().split(":");

        int fD = 0;
        int fH = 0;
        int fM = 0;
        int sD = 0;
        int sH = 0;
        int sM = 0;

        if (firstDateArgs.length == 4) {
            fD = Integer.parseInt(firstDateArgs[0]);
            fH = Integer.parseInt(firstDateArgs[2]);
            fM = Integer.parseInt(firstDateArgs[3]);
        } else {
            fH = Integer.parseInt(firstDateArgs[0]);
            fM = Integer.parseInt(firstDateArgs[1]);
        }

        if (secondDateArgs.length == 4) {
            sD = Integer.parseInt(secondDateArgs[0]);
            sH = Integer.parseInt(secondDateArgs[2]);
            sM = Integer.parseInt(secondDateArgs[3]);
        } else {
            sH = Integer.parseInt(secondDateArgs[0]);
            sM = Integer.parseInt(secondDateArgs[1]);
        }

        int sumOfMins = fM + sM;
        int mins = sumOfMins % 60;
        int sumOfHours = fH + sH + sumOfMins / 60;
        int hours = sumOfHours % 24;
        int days = fD + sD + sumOfHours / 24;

        if (days == 0) {
            if (mins > 9)
                System.out.println(hours + ":" + mins);
            else
                System.out.println(hours + ":0" + mins);
        } else  {
            System.out.print(days + "::");
            if (mins > 9)
                System.out.println(hours + ":" + mins);
            else
                System.out.println(hours + ":0" + mins);
        }
    }
}
