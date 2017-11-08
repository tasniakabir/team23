package models;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    public java.util.List<Card> deck = new ArrayList<>();

    public Deck(){}

    public void buildDeck() {
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
    }

    public void shuffle() {
        // shuffles the Deck so that it is random
        Random generator = new Random();
        for(int i = 0; i < 52; i++){
            //mod by 52 so that we don't leave scope of ArrayList
            int random = Math.abs(generator.nextInt() % 52);
            //swap locations
            Card temp = deck.get(i);
            deck.set(i, deck.get(random));
            deck.set(random, temp);
        }
    }

    public void decreaseDeck() {
        for(int i = 0; i < 4; i++) {
            deck.remove(deck.size() - 1);
        }
    }
}
