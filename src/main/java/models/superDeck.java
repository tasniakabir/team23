package models;

import java.util.ArrayList;
import java.util.Random;

public class superDeck {

    public java.util.List<Card> deck = new ArrayList<>();
    public superDeck(){}
    public void shuffle() {
        // shuffles the Deck so that it is random
        Random generator = new Random();
        int sz= deck.size();
        for (int i = 0; i < sz; i++) {
            //mod by 50 so that we don't leave scope of ArrayList
            int random = Math.abs(generator.nextInt() % sz);
            //swap locations
            Card temp = deck.get(i);
            deck.set(i, deck.get(random));
            deck.set(random, temp);
        }
    }

    public Card dealCard() {
        Card tmp = deck.get(deck.size() - 1);
        deck.remove(deck.size() - 1);
        return tmp;

    }
}


