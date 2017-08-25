package hackerRank.challenges;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by vladix on 8/25/17.
 */
public class hr_flatlandSpaceStations {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(solution(arr, n));
    }

    private static int solution(int[] arr, int n){
        Arrays.sort(arr);
        int maxDistance = arr[0];
        for(int i = 1; i < arr.length; i++){
            int distance = (arr[i] - arr[i-1]) / 2;
            if(maxDistance < distance) maxDistance = distance;
        }
        int lastGap = (n-1) - arr[arr.length - 1];
        return (lastGap < maxDistance) ? maxDistance : lastGap;
    }
}
