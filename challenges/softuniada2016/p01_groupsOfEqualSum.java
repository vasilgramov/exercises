package hackerRank.challenges.softuniada2016;

import java.util.Scanner;

public class p01_groupsOfEqualSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n1 = Integer.parseInt(in.nextLine());
        int n2 = Integer.parseInt(in.nextLine());
        int n3 = Integer.parseInt(in.nextLine());
        int n4 = Integer.parseInt(in.nextLine());

        if (n1 == n2 + n3 + n4) {
            System.out.println("Yes");
            System.out.println(n1);
        } else if (n2 == n1 + n3 + n4) {
            System.out.println("Yes");
            System.out.println(n2);
        } else if (n3 == n1 + n2 + n4) {
            System.out.println("Yes");
            System.out.println(n3);
        } else if (n4 == n1 + n2 + n3) {
            System.out.println("Yes");
            System.out.println(n4);
        } else if (n1 + n2 == n3 + n4) {
            System.out.println("Yes");
            System.out.println(n1 + n2);
        } else if (n1 + n3 == n2 + n4) {
            System.out.println("Yes");
            System.out.println(n1 + n3);
        } else if (n1 + n4 == n2 + n3) {
            System.out.println("Yes");
            System.out.println(n1 + n4);
        } else if (n2 + n3 == n1 + n4) {
            System.out.println("Yes");
            System.out.println(n2 + n3);
        } else if (n2 + n4 == n1 + n3) {
            System.out.println("Yes");
            System.out.println(n2 + n4);
        } else if (n3 + n4 == n1 + n2) {
            System.out.println("Yes");
            System.out.println(n3 + n4);
        } else {
            System.out.println("No");
        }
    }
}
