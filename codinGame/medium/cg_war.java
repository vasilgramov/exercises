package codinGame.medium;

import java.util.LinkedList;
import java.util.Scanner;

public class cg_war {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        LinkedList<Character> firstPlayerCards = new LinkedList<Character>();
        LinkedList<Character> secondPlayerCards = new LinkedList<Character>();

        int n = Integer.parseInt(in.nextLine());
        createPlayerDeck(firstPlayerCards, n, in);
        int m = Integer.parseInt(in.nextLine());
        createPlayerDeck(secondPlayerCards, m, in);

        int gameRounds = 0;
        while (firstPlayerCards.size() > 0 && secondPlayerCards.size() > 0) {
            char cardFirstPlayer = firstPlayerCards.poll();
            char cardSecondPlayer = secondPlayerCards.poll();

            if (cardFirstPlayer > cardSecondPlayer) {
                firstPlayerCards.addLast(cardFirstPlayer);
                firstPlayerCards.addLast(cardSecondPlayer);
            } else if (cardSecondPlayer > cardFirstPlayer) {
                secondPlayerCards.addLast(cardFirstPlayer);
                secondPlayerCards.addLast(cardSecondPlayer);
            } else {
                LinkedList<Character> cardsF = new LinkedList<>();
                LinkedList<Character> cardsS = new LinkedList<>();

                Character f01 = firstPlayerCards.poll();
                Character f02 = firstPlayerCards.poll();
                Character f03 = firstPlayerCards.poll();

                Character s01 = secondPlayerCards.poll();
                Character s02 = secondPlayerCards.poll();
                Character s03 = secondPlayerCards.poll();

                if (firstPlayerCards.size() == 0 || secondPlayerCards.size() == 0) {
                    System.out.println("PAT");
                    return;
                }

                cardsF.addLast(cardFirstPlayer);
                cardsF.addLast(f01);
                cardsF.addLast(f02);
                cardsF.addLast(f03);

                cardsS.addLast(cardSecondPlayer);
                cardsS.addLast(s01);
                cardsS.addLast(s02);
                cardsS.addLast(s03);

                if (war(firstPlayerCards, secondPlayerCards, cardsF, cardsS)) {
                    System.out.println("PAT");
                    return;
                }
            }

            gameRounds++;
        }

        if (firstPlayerCards.size() == 0) {
            System.out.println("2 " + gameRounds);
        } else {
            System.out.println("1 " + gameRounds);
        }
    }

    private static boolean war(LinkedList<Character> firstPlayerCards, LinkedList<Character> secondPlayerCards, LinkedList<Character> cardsF, LinkedList<Character> cardsS) {
        char cardFirstPlayer = firstPlayerCards.poll();
        char cardSecondPlayer = secondPlayerCards.poll();

        if (cardFirstPlayer > cardSecondPlayer) {
            for (Character card : cardsF) {
                firstPlayerCards.addLast(card);
            }

            firstPlayerCards.add(cardFirstPlayer);
            for (Character card : cardsS) {
                firstPlayerCards.addLast(card);
            }

            firstPlayerCards.addLast(cardSecondPlayer);
        } else if(cardSecondPlayer > cardFirstPlayer) {
            for (Character card : cardsF) {
                secondPlayerCards.add(card);
            }

            secondPlayerCards.addLast(cardFirstPlayer);
            for (Character card : cardsS) {
                secondPlayerCards.add(card);
            }

            secondPlayerCards.addLast(cardSecondPlayer);
        } else {
            Character f01 = firstPlayerCards.poll();
            Character f02 = firstPlayerCards.poll();
            Character f03 = firstPlayerCards.poll();

            Character s01 = secondPlayerCards.poll();
            Character s02 = secondPlayerCards.poll();
            Character s03 = secondPlayerCards.poll();

            if (firstPlayerCards.size() == 0 || secondPlayerCards.size() == 0) {
                return true;
            }

            cardsF.addLast(cardFirstPlayer);
            cardsF.addLast(f01);
            cardsF.addLast(f02);
            cardsF.addLast(f03);

            cardsS.addLast(cardSecondPlayer);
            cardsS.addLast(s01);
            cardsS.addLast(s02);
            cardsS.addLast(s03);

            return war(firstPlayerCards, secondPlayerCards, cardsF, cardsS);
        }

        return false;
    }


    private static void createPlayerDeck(LinkedList<Character> playerDeck, int numberOfCards, Scanner in) {
        for (int i = 0; i < numberOfCards; i++) {
            String currentCard = in.nextLine();
            maskCardsStrength(playerDeck, currentCard);
        }
    }

    private static void maskCardsStrength(LinkedList<Character> playerDeck, String currentCard) {
        if (currentCard.startsWith("10")) {
            playerDeck.addLast('j');
        } else if (currentCard.startsWith("2")) {
            playerDeck.addLast('b');
        } else if (currentCard.startsWith("3")) {
            playerDeck.addLast('c');
        } else if (currentCard.startsWith("4")) {
            playerDeck.addLast('d');
        } else if (currentCard.startsWith("5")) {
            playerDeck.addLast('e');
        } else if (currentCard.startsWith("6")) {
            playerDeck.addLast('f');
        } else if (currentCard.startsWith("7")) {
            playerDeck.addLast('g');
        } else if (currentCard.startsWith("8")) {
            playerDeck.addLast('h');
        } else if (currentCard.startsWith("9")) {
            playerDeck.addLast('i');
        } else if (currentCard.startsWith("1")) {
            playerDeck.addLast('a');
        } else if (currentCard.startsWith("J")) {
            playerDeck.addLast('k');
        } else if (currentCard.startsWith("Q")) {
            playerDeck.addLast('l');
        } else if (currentCard.startsWith("K")) {
            playerDeck.addLast('m');
        } else if (currentCard.startsWith("A")) {
            playerDeck.addLast('n');
        }
    }
}
