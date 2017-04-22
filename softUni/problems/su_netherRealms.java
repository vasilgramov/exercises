package softUni.problems;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class su_netherRealms {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String demonsDmgPattern = "((?:-|\\+|)\\d+(?:\\.*?\\d+)*)";
        Pattern regex = Pattern.compile(demonsDmgPattern);

        String[] demonsNames = console.nextLine().split(",");

        TreeMap<String, double[]> statsByDemon = new TreeMap<>();
        for (int i = 0; i < demonsNames.length; i++) {
            double dmg = 0;
            double hp = 0;
            String currentDemon = demonsNames[i].replaceAll(" ", "");

            dmg = getDmg(regex, dmg, currentDemon);
            hp = getHp(hp, currentDemon);

            statsByDemon.put(currentDemon, new double[] {hp, dmg});
        }

        for ( Map.Entry<String, double[]> entry : statsByDemon.entrySet() ) {
            String demon = entry.getKey();
            double[] value = entry.getValue();
            int hp = (int)(value[0]);
            double dmg = value[1];

            System.out.format("%s - %d health, %.2f damage", demon, hp, dmg);
            System.out.println();
        }
    }

    private static double getHp(double hp, String currentDemon) {
        for (int j = 0; j < currentDemon.length(); j++) {
            char c = currentDemon.charAt(j);
            if (c != '+' && c != '-' && c != '*' && c != '/' && c != '.' && !Character.isDigit(c)) {
                hp += c;
            }
        }
        return hp;
    }

    private static double getDmg(Pattern regex, double dmg, String currentDemon) {
        Matcher matcher = regex.matcher(currentDemon);
        LinkedList<String> numbersAsString = new LinkedList<>();
        while (matcher.find()) {
            numbersAsString.add(matcher.group(0));
        }

        for (int j = 0; j < numbersAsString.size(); j++) {
            dmg += Double.parseDouble(numbersAsString.get(j));
        }

        int multipliersCount = currentDemon.replaceAll("[^*]", "").length();
        int divisorSCount = currentDemon.replaceAll("[^/]", "").length();

        if (multipliersCount > divisorSCount) {
            for (int j = 0; j < multipliersCount - divisorSCount; j++) {
                dmg *= 2;
            }
        } else {
            for (int j = 0; j < divisorSCount - multipliersCount; j++) {
                dmg /= 2;
            }
        }

        return dmg;
    }
}