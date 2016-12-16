package hackerRank.challenges.easy;// https://www.hackerrank.com/challenges/library-fine?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class hr_libraryFine {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Calendar cal = Calendar.getInstance();

        Date actualDate = parseDate(in.nextLine());
        Date expectedDate = parseDate(in.nextLine());

        int fine = 0;

        if (actualDate.before(expectedDate) || actualDate.equals(expectedDate)) {
            fine = 0;
        } else {
            cal.setTime(actualDate);
            int aYear = cal.get(Calendar.YEAR);
            cal.setTime(expectedDate);
            int eYear = cal.get(Calendar.YEAR);

            if (aYear == eYear) {
                cal.setTime(actualDate);
                int aMonth = cal.get(Calendar.MONTH) + 1;
                cal.setTime(expectedDate);
                int eMonth = cal.get(Calendar.MONTH) + 1;

                if (aMonth == eMonth) {
                    cal.setTime(actualDate);
                    int aDay = cal.get(Calendar.DAY_OF_MONTH);
                    cal.setTime(expectedDate);
                    int eDay = cal.get(Calendar.DAY_OF_MONTH);

                    fine = 15 * (aDay - eDay);
                } else {
                    fine = 500 * (aMonth - eMonth);
                }
            } else {
                fine = 10000;
            }
        }

        System.out.println(fine);
    }

    private static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("d M yyyy").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
