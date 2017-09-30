package examples.basic.arrays;

public class DeckOfCardsTest {
    public static void main(String[] args) {
        DeckOfCards myDeck = new DeckOfCards();
        myDeck.shuffle();
        for (int i = 1; i <= 52; i++) {
            System.out.printf("%-19s", myDeck.dealCard());
            if (i % 4 == 0) {
                System.out.println();
            }
        }
    }
}
