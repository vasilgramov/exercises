package hackerRank.challenges;

import java.util.Arrays;
import java.util.Scanner;

public class hr_equal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numberOfTests = Integer.parseInt(in.nextLine());
        for (int i = 0; i < numberOfTests; i++) {
            int numberOfInterns = Integer.parseInt(in.nextLine());

            int[] sortedNumbers = new int[numberOfInterns];
            String[] numbersAsString = in.nextLine().split("\\s+");
            for (int j = 0; j < numberOfInterns; j++) {
                sortedNumbers[j] = (Integer.parseInt(numbersAsString[j]));
            }

            Arrays.sort(sortedNumbers);

            int numberOfOperations = 0;
            int toIncrease = 0;
            int currentFMin = sortedNumbers[0];
            int index = 1;
            while (index < numberOfInterns) {
                int copy = currentFMin;
                int copyToIncrease = toIncrease;
                int currentSMin = sortedNumbers[index] + toIncrease;

                int currentOperations = 0;
                while (currentSMin - currentFMin >= 5) {
                    int currentFOperations = (currentSMin - currentFMin) / 5;
                    currentOperations += currentFOperations;
                    toIncrease += 5 * currentFOperations;

                    currentFMin += 5 * currentFOperations;
                }
                while (currentSMin - currentFMin >= 2) {
                    int currentFOperations = (currentSMin - currentFMin) / 2;
                    currentOperations += currentFOperations;
                    toIncrease += 2 * currentFOperations;

                    currentFMin += 2 * currentFOperations;
                }
                while (currentSMin - currentFMin >= 1) {
                    int currentFOperations = (currentSMin - currentFMin) / 1;
                    currentOperations += currentFOperations;
                    toIncrease += 1 * currentFOperations;

                    currentFMin += 1 * currentFOperations;
                }

//                if ((index + 1 < sortedNumbers.length) && (currentSMin == (sortedNumbers[index + 1]))) {
//                    int difference = currentSMin - copy;
//                    if (difference % 5 != 0) {
//                        if ((difference + 1) % 5 == 0 && difference >= 4) {
//                            if ((difference + 1) / 5 < currentOperations) {
//                                for (int j = index; j < sortedNumbers.length; j++) {
//                                    sortedNumbers[j] += 1;
//                                }
//
//                                currentOperations = (difference + 1) / 5;
//                                index--;
//                                toIncrease = copyToIncrease;
//                                currentFMin = copy;
//                            }
//                        } else if ((difference + 2) % 5 == 0 && difference >= 3) {
//                            if ((difference + 2) / 5 < currentOperations) {
//                                for (int j = index; j < sortedNumbers.length; j++) {
//                                    sortedNumbers[j] += 2;
//                                }
//
//                                currentOperations = (difference + 2) / 5;
//                                index--;
//                                toIncrease = copyToIncrease;
//                                currentFMin = copy;
//                            }
//                        }
//                    }
//                }

                numberOfOperations += currentOperations;
                index++;
            }

            System.out.println(numberOfOperations);
        }
    }
}