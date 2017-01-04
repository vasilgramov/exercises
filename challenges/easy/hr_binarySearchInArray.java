// https://www.hackerrank.com/challenges/tutorial-intro?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
package hackerRank.challenges.easy;

import java.util.Scanner;

public class hr_binarySearchInArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int searchedNumber = Integer.parseInt(in.nextLine());
        int arraySize = Integer.parseInt(in.nextLine());
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = in.nextInt();
        }

        int currentIndex = arraySize / 2;
        int currentNumber = array[arraySize / 2];
        int prevIndex = 0;
        while (currentNumber != searchedNumber) {
            if (currentNumber > searchedNumber) { // on the left -> go right
                currentIndex = prevIndex + (currentIndex - prevIndex) / 2;
                currentNumber = array[currentIndex];
            } else {                             // on the right -> go left
                prevIndex = currentIndex;
                currentIndex = currentIndex + (arraySize - currentIndex) / 2;
                currentNumber = array[currentIndex];
            }
        }

        System.out.println(currentIndex);
    }
}
