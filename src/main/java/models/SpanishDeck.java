/*package models;

import java.util.ArrayList;
import java.util.Random;*/

/*public class SpanishDeck {

    public java.util.List<SpanishCard> deck = new ArrayList<>();

    public SpanishDeck() {
        buildDeck();
        shuffle();
    }

    private void buildDeck() {
        for (int i = 1; i < 13; i++) {  //14 because 9 number cards and 3 face cards, starts at 2
            deck.add(new SpanishCard(i, SpanishSuit.Bastos));
            deck.add(new SpanishCard(i, SpanishSuit.Oros));
            deck.add(new SpanishCard(i, SpanishSuit.Copas));
            deck.add(new SpanishCard(i, SpanishSuit.Espadas));
        }
        //two jokers
        int j = 0;
        deck.add(new SpanishCard(j, SpanishSuit.Comodines));
        deck.add(new SpanishCard(j, SpanishSuit.Comodines));
    }

    private void shuffle() {
        // shuffles the Deck so that it is random
        Random generator = new Random();
        for (int i = 0; i < 50; i++) {
            //mod by 50 so that we don't leave scope of ArrayList
            int random = Math.abs(generator.nextInt() % 50);
            //swap locations
            SpanishCard temp = deck.get(i);
            deck.set(i, deck.get(random));
            deck.set(random, temp);
        }
    }

    //this function returns the top card form the deck and removes said card from deck
    public SpanishCard dealCard() {
        SpanishCard tmp = deck.get(deck.size() - 1);
        deck.remove(deck.size() - 1);
        return tmp;
    }
}*/
