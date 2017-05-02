package hackerRank.contests.contest_hourRank20;

import java.util.Scanner;

/**
 * Created by vladix on 5/2/17.
 */
public class p03 {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("r = ");
        double r = Double.parseDouble(console.nextLine());
        double area = Math.PI * r * r;
        System.out.println("Circle = " + area);
        double perimeter = 2 * Math.PI * r;
        System.out.println("Circle = " + perimeter);
    }
}

