/*team 23*/

package models;

import java.util.ArrayList;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

    public Deck gameDeck=new Deck();
    public SpanishDeck gameSpanishDeck= new SpanishDeck();
    public java.util.List<Columns> cols = new ArrayList <> ();
    public boolean error = false;

    public Game(){
        // initialize a new game such that each column can store
        //four suits
        for(int i = 1; i < 5; i++) {
            //15 cards per suit
            cols.add(new Columns(i));
        }
    }

    public void dealFour() {
        for(int i = 0; i < 4; i++) {
            cols.get(i).cards.add(gameDeck.dealCard());
        }
    }

    private int findJoker(){
        for (int i=0; i<4; i++){ //iterate through columns
            if (getTopCard(i).getValue()==0){
                return i; //return column number of col containing joker
            }
        }
        return 7; //return number signifying no joker was present
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
                this.cols.get(columnNumber).cards.remove(this.cols.get(columnNumber).cards.size() - 1);
                error=false;
            }
            else{
                error=true;
            }
        }
    }

    private boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false, otherwise return true
        if(cols.get(columnNumber).cards.size()>0) {
            return true;
        }
        return false;
    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).cards.get(this.cols.get(columnNumber).cards.size()-1);
    }

    public void move(int columnFrom, int columnTo) {
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
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        this.cols.get(columnTo).cards.add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).cards.remove(this.cols.get(colFrom).cards.size()-1);
    }
}
