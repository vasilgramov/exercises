package hackerRank.challenges;

import java.util.*;

public class hr_balancedBrackets {

    private static final Set<Character> openingBrackets;
    private static final Set<Character> closingBrackets;

    static {
        openingBrackets = new HashSet<>();
        closingBrackets = new HashSet<>();
    }

    public static void main(String[] args) {

        fillOpeningBrackets();
        fillClosingBrackets();

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        while (n-- > 0) {

            Deque<Character> brackets = new LinkedList<>();
            String line = in.next();

            boolean isBalanced = checkIsBalanced(brackets, line);

            if (isBalanced && brackets.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static boolean checkIsBalanced(Deque<Character> brackets, String line) {
        boolean isBalanced = true;

        for (int i = 0; i < line.length(); i++) {
            char currentBracket = line.charAt(i);

            if (openingBrackets.contains(currentBracket)) {
                brackets.add(currentBracket);
            } else if (closingBrackets.contains(currentBracket)) {
                if (brackets.isEmpty()) {
                    isBalanced = false;
                    break;
                }

                char lastBracket = brackets.removeLast();
                if (!((lastBracket == '(' && currentBracket == ')') ||
                        (lastBracket == '{' && currentBracket == '}') ||
                        (lastBracket == '[' && currentBracket == ']'))) {
                    isBalanced = false;
                    break;
                }
            }
        }

        return isBalanced;
    }

    private static void fillClosingBrackets() {
        closingBrackets.add(')');
        closingBrackets.add('}');
        closingBrackets.add(']');
    }

    private static void fillOpeningBrackets() {
        openingBrackets.add('(');
        openingBrackets.add('{');
        openingBrackets.add('[');
    }
}
