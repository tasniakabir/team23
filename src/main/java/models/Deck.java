package models;

public class Deck extends superDeck {

    public Deck() {
        buildDeck();
        shuffle();
    }

    public Deck(int test) {
        if (test == 1) {
            buildDeck();
        }
    }

    private void buildDeck() {
        for (int i = 2; i < 15; i++) {
            deck.add(new Card(i, Suit.Clubs));
            deck.add(new Card(i, Suit.Hearts));
            deck.add(new Card(i, Suit.Diamonds));
            deck.add(new Card(i, Suit.Spades));
        }
    }
}