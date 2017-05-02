package hackerRank.contests.contest_30DaysOfCode;

/**
 * Created by vladix on 5/2/17.
 */
public class p13_inheritance {
    private class Student /*extends Person*/ {
        private int[] testScores;

        /*
        *   Class Constructor
        *
        *   @param firstName - A string denoting the Person's first name.
        *   @param lastName - A string denoting the Person's last name.
        *   @param id - An integer denoting the Person's ID number.
        *   @param scores - An array of integers denoting the Person's test scores.
        */
        // Write your constructor here
        public Student (String firstName, String lastName, int id, int[] scores) {
            /*super(firstName, lastName, id);*/
            this.testScores = scores;
        }

        /*
        *   Method Name: calculate
        *   @return A character denoting the grade.
        */
        public char calculate() {
            int sum = 0;
            for (int i = 0; i < this.testScores.length; i++) {
                sum += this.testScores[i];
            }

            sum = sum / this.testScores.length;

            if (sum >= 90 && sum <= 100) {
                return 'O';
            } else if (sum >= 80 && sum < 90) {
                return 'E';
            } else if (sum >= 70 && sum < 80) {
                return 'A';
            } else if (sum >= 55 && sum < 70) {
                return 'P';
            } else if (sum >= 40 && sum <55) {
                return 'D';
            } else {
                return 'T';
            }
        }
    }
}
