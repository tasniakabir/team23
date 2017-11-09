/*team 23*/

package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

   // public java.util.List<Card> deck = new ArrayList<>();
    public Deck gameDeck=new Deck();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);

    public boolean error = false;


    public Game(){
        // initialize a new game such that each column can store
        //four suits
        for(int i = 0; i < 4; i++) {
            //15 cards per suit
            cols.add(new ArrayList<Card>(15));
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
            Card c = getTopCard(columnNumber);
            boolean removeCard = false;
            for (int i = 0; i < 4; i++) {
                if (i != columnNumber) {
                    if (columnHasCards(i)) {
                        Card compare = getTopCard(i);
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
        /*// remove the top card from the indicated column
        //remcard represents the card the player is asking to be removed
        Card remcard;
        //each card represent the top card in that column as indicated by the card number
        Card card1 = getTopCard(0);
        Card card2 = getTopCard(1);
        Card card3 = getTopCard(2);
        Card card4 = getTopCard(3);
        error = false;

        //if the column number is 0
        if (columnNumber == 0) {
            //check if column 0 has cards
            if (columnHasCards(0)) {
                //set the top card of column 1 to remcard
                remcard = getTopCard(0);
                //check if column 1 has cards, and if the top card in column1 and remcard have the same suit
                // and if the remcard's value is less than the top card of column1
                //this is because of according to Ace's Up rules a card can only be removed if it is in the top row and
                //has a card of the same suit that is of higher value in the top row of all 4 columns
                if (columnHasCards(1) && remcard.getSuit() == card2.getSuit() && remcard.getValue() < card2.getValue()) {
                    removeCardFromCol(0);
                }
                //check top card of column 2
                else if (columnHasCards(2) && remcard.getSuit() == card3.getSuit() && remcard.getValue() < card3.getValue()) {
                    removeCardFromCol(0);
                }
                //check top card of column 3
                else if (columnHasCards(3) && remcard.getSuit() == card4.getSuit() && remcard.getValue() < card4.getValue()) {
                    removeCardFromCol(0);
                }
                else {
                    error = true;
                }
            }
        }
        //else if column number is 1
        else if(columnNumber==1) {

            //check if column 1 has cards
            if (columnHasCards(1)) {
                //set the top card of column 1 to remcard
                remcard = getTopCard(1);

                //check if column 0 has cards, and if the top card in column 0 and remcard have the same suit
                // and if the remcard's value is less than the top card of column 0

                if (columnHasCards(0) && remcard.getSuit() == card1.getSuit() && remcard.getValue() < card1.getValue()) {
                    removeCardFromCol(1);
                }

                //check top card of column 2

                else if (columnHasCards(2) && remcard.getSuit() == card3.getSuit() && remcard.getValue() < card3.getValue()) {
                    removeCardFromCol(1);
                }

                //check top card of column 3

                else if (columnHasCards(3) && remcard.getSuit() == card4.getSuit() && remcard.getValue() < card4.getValue()) {
                    removeCardFromCol(1);
                }

                else {
                    error = true;
                }
            }
        }
        //else if column number is 2
        else if(columnNumber==2){
            //if column 2 has cards
            if (columnHasCards(2)){
                //set remcard to top card of column 2
                remcard = getTopCard(2);
                //check if column 0 has cards, and if the top card in column 0 and remcard have the same suit
                // and if the remcard's value is less than the top card of column 0
                if (columnHasCards(0) && remcard.getSuit() == card1.getSuit() && remcard.getValue() < card1.getValue()) {
                    removeCardFromCol(2);
                }
                //check top card of column 1
                else if (columnHasCards(1) && remcard.getSuit() == card2.getSuit() && remcard.getValue() < card2.getValue()) {
                    removeCardFromCol(2);
                }
                //check top card of column 3
                else if (columnHasCards(3) && remcard.getSuit() == card4.getSuit() && remcard.getValue() < card4.getValue()) {
                    removeCardFromCol(2);
                }

                else {
                    error = true;
                }
            }
        }
        //else if column number is 3
        else if(columnNumber==3){
            //if column 3 has cards
            if (columnHasCards(3)){
                //set top card of column 3
                remcard = getTopCard(3);
                //check if column 0 has cards, and if the top card in column 0 and remcard have the same suit
                // and if the remcard's value is less than the top card of column 0
                if (columnHasCards(0) && remcard.getSuit() == card1.getSuit() && remcard.getValue() < card1.getValue()) {
                    removeCardFromCol(3);
                }
                //check top card of column 1
                else if (columnHasCards(1) && remcard.getSuit() == card2.getSuit() && remcard.getValue() < card2.getValue()) {
                    removeCardFromCol(3);
                }
                //check top card of column 2
                else if (columnHasCards(2) && remcard.getSuit() == card3.getSuit() && remcard.getValue() < card3.getValue()) {
                    removeCardFromCol(3);
                }

                else {
                    error = true;
                }
            }
        }*/
    }

    private boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false, otherwise return true
        if(cols.get(columnNumber).size()>0) {
            return true;
        }
        return false;
    }

    private Card getTopCard(int columnNumber) {
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

    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }
}
