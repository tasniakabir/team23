package models;

public class SpanishDeck extends superDeck {

    public SpanishDeck() {
        buildSpanishDeck();
        shuffle();
    }

    public SpanishDeck(int test) {
        if (test == 1) {
            buildSpanishDeck();
        }
    }

    private void buildSpanishDeck() {
        for (int i = 1; i < 13; i++) {  //14 because 9 number cards and 3 face cards, starts at 2
            if (i==1){
                deck.add(new Card(14, Suit.Bastos));
                deck.add(new Card(14, Suit.Oros));
                deck.add(new Card(14, Suit.Copas));
                deck.add(new Card(14, Suit.Espadas));
            }
            else {
                deck.add(new Card(i, Suit.Bastos));
                deck.add(new Card(i, Suit.Oros));
                deck.add(new Card(i, Suit.Copas));
                deck.add(new Card(i, Suit.Espadas));
            }
        }
        //two jokers
        int j = 0;
        deck.add(new Card(j, Suit.Comodines));
        deck.add(new Card(j, Suit.Comodines));
    }
}