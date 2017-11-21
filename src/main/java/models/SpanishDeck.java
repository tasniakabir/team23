package models;

import java.util.ArrayList;
import java.util.Random;

public class SpanishDeck {

    public java.util.List<Card> deck = new ArrayList<>();

    public SpanishDeck(){
        buildDeck();
        shuffle();
    }

    private void buildDeck() {
        for(int i = 2; i < 15; i++){
            deck.add(new SpanishCard(i,Suit.Bastos));
            deck.add(new SpanishCard(i,Suit.Oros));
            deck.add(new SpanishCard(i,Suit.Copas));
            deck.add(new SpanishCard(i,Suit.Espadas));
        }
    }

    private void shuffle() {
        // shuffles the Deck so that it is random
        Random generator = new Random();
        for(int i = 0; i < 52; i++){
            //mod by 52 so that we don't leave scope of ArrayList
            int random = Math.abs(generator.nextInt() % 52);
            //swap locations
            SpanishCard temp = deck.get(i);
            deck.set(i, deck.get(random));
            deck.set(random, temp);
        }
    }

    //this function returns the top card form the deck and removes said card from deck
    public SpanishCard dealCard(){
        SpanishCard tmp= deck.get(deck.size()-1);
        deck.remove(deck.size() - 1);
        return tmp;
    }
