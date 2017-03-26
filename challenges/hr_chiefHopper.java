package hackerRank.challenges;

import java.util.Scanner;

public class hr_chiefHopper {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        double[] buildings = new double[n];

        double minEnergy = Double.MIN_VALUE;
        String[] buildingsAsStrings = in.nextLine().split("\\s+");
        for (int i = 0; i < buildings.length; i++) {
            double building = Double.parseDouble(buildingsAsStrings[i]);
            if (building > minEnergy) {
                minEnergy = building;
            }

            buildings[i] = building;
        }

        double at_least_needed = 0;
        double energy = 0;
        for (int i = n - 1; i >= 0; i--) {
            energy = Math.ceil((at_least_needed + buildings[i]) / 2.0);
            at_least_needed = energy;
        }

        System.out.println((int) energy);
    }
}