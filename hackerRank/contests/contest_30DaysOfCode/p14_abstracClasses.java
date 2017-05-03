package hackerRank.contests.contest_30DaysOfCode;

import java.util.Scanner;

/**
 * Created by vladix on 5/3/17.
 */
public class p14_abstracClasses {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String title = in.next();
        String author = in.next();
        int price = in.nextInt();

    }

    class MyBook extends Book {

        private int price;

        public MyBook(String title, String author, int price) {
            super(title, author);
            this.price = price;
        }

        @Override
        void display() {
            System.out.println("Title: " + super.title);
            System.out.println("Author: " + super.author);
            System.out.println("Price: " + this.price);
        }
    }

    abstract class Book {
        private String title;
        private String author;

        protected Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        abstract void display();
    }
}
