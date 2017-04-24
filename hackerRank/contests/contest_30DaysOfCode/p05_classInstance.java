package hackerRank.contests.contest_30DaysOfCode;

import java.util.Scanner;

/**
 * Created by vladix on 4/24/17.
 */
public class p05_classInstance {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = Integer.parseInt(in.nextLine());
        for (int i = 0; i < t; i++) {
            int age = Integer.parseInt(in.nextLine());
            Person p = new Person(age);
            p.amIOld();
            for (int j = 0; j < 3; j++) {
                p.yearPasses();
            }
            p.amIOld();
        }
    }

    private static class Person {
        private int age;

        public Person(int age) {
            this.setAge(age);
        }

        public int getAge() {
            return this.age;
        }

        private void setAge(int age) {
            if (age < 0) {
                System.out.println("Age is not valid, setting age to 0.");
                this.age = 0;
            } else {
                this.age = age;
            }
        }

        public void amIOld() {
            if (this.getAge() < 13) {
                System.out.println("You are young.");
            } else if (this.getAge() >= 13 && this.getAge() < 18) {
                System.out.println("You are a teenager.");
            } else {
                System.out.println("You are old.");
            }
        }

        public void yearPasses() {
            this.setAge(this.getAge() + 1);
        }
    }
}


