
/*team 23*/

package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class SpanishGame {

    // public java.util.List<Card> deck = new ArrayList<>();
    public SpanishDeck gameDeck=new SpanishDeck();

    public java.util.List<java.util.List<SpanishCard>> cols = new ArrayList<>(4);

    public boolean error = false;


    public SpanishGame(){
        // initialize a new game such that each column can store
        //four suits
        for(int i = 0; i < 4; i++) {
            //15 cards per suit
            cols.add(new ArrayList<SpanishCard>(15));
        }
    }

    /*   public void buildDeck() {
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
   */
    public void dealFour() {
        for(int i = 0; i < 4; i++) {
            //cols.get(i).add(deck.get(deck.size() - 1));
            //deck.remove(deck.size() - 1);
            cols.get(i).add(gameDeck.dealCard());
        }
    }

    public void remove(int columnNumber) {
        if(columnHasCards(columnNumber)) {
            SpanishCard c = getTopCard(columnNumber);
            boolean removeCard = false;
            for (int i = 0; i < 4; i++) {
                if (i != columnNumber) {
                    if (columnHasCards(i)) {
                        SpanishCard compare = getTopCard(i);
                        if (compare.getSuit() == c.getSuit()) {
                            if (compare.getValue() > c.getValue()) {
                                removeCard = true;
                            }
                        }
                    }
                }
            }
            if (removeCard) {
                this.cols.get(columnNumber).remove(this.cols.get(columnNumber).size() - 1);
                error=false;
            }
            else{
                error=true;
            }
        }
    }

    private boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false, otherwise return true
        if(cols.get(columnNumber).size()>0) {
            return true;
        }
        return false;
    }

    private SpanishCard getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }

    //issue #39
    public void move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column

        //check if fine

        // if the column is empty, then move any card
        if(getTopCard(columnFrom).getValue() == 14) {
            if (columnHasCards(columnTo) == false) {
                addCardToCol(columnTo, getTopCard(columnFrom));
                removeCardFromCol(columnFrom);
                error = false;
            } else {
                error = true;
            }
        }
        else{
            error = true;
        }

        //if the column is not empty, display error message

        //else
    }

    private void addCardToCol(int columnTo, SpanishCard cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }
}
