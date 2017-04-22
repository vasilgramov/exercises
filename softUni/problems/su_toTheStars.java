// TODO:
//package softUni.problems;
//
//import java.util.Scanner;
//
//public class su_toTheStars {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        String[] firstStarArgs = in.nextLine().split("\\s+");
//        String[] secondStarArgs = in.nextLine().split("\\s+");
//        String[] thirdStarArgs = in.nextLine().split("\\s+");
//
//        int firstStarRow = Integer.parseInt(firstStarArgs[1]);
//        int firstStarCol = Integer.parseInt(firstStarArgs[2]);
//
//        int secondStarRow = Integer.parseInt(secondStarArgs[1]);
//        int secondStarCol = Integer.parseInt(secondStarArgs[2]);
//
//        int thirdStarRow = Integer.parseInt(thirdStarArgs[1]);
//        int thirdStarCol = Integer.parseInt(thirdStarArgs[2]);
//
//        int maxRow = 0;
//        int maxCol = 0;
//
//        if (firstStarRow >= secondStarRow && firstStarRow >= thirdStarRow)
//            maxRow = firstStarRow;
//        else if (secondStarRow >= firstStarRow && secondStarRow >= thirdStarRow)
//            maxRow = secondStarRow;
//        else
//            maxRow = thirdStarRow;
//
//        if (firstStarCol >= secondStarCol && firstStarCol >= thirdStarCol)
//            maxCol = firstStarCol;
//        else if (secondStarCol >= firstStarCol && secondStarCol >= thirdStarCol)
//            maxCol = secondStarCol;
//        else
//            maxCol = thirdStarCol;
//
//        char[][] field = new char[maxRow][maxCol];
//        field[firstStarRow][firstStarCol] = '@';
//        field[firstStarRow + 1][firstStarCol] = '@';
//        field[firstStarRow][firstStarCol + 1] = '@';
//
//        String[] playerArgs = in.nextLine().split("\\s+");
//
//        int turns = Integer.parseInt(in.nextLine());
//        for (int i = 0; i < turns; i++) {
//            if ()
//        }
//    }
//}
