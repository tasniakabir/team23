/*team 23*/

package models;

import java.util.ArrayList;

public class Game {

    public Deck gameDeck=new Deck();
    public Deck testDeck=new Deck(1);
    public SpanishDeck gameSpanishDeck= new SpanishDeck();
    public SpanishDeck testSpanishDeck= new SpanishDeck(1);
    public java.util.List<Columns> cols = new ArrayList <> ();
    public boolean error = false;

    public Game(){
        for(int i = 1; i < 5; i++) {
            cols.add(new Columns(i));
        }
    }

    public void dealFour(int d) {
        for(int i = 0; i < 4; i++) {
            if(d==0){
                cols.get(i).cards.add(gameDeck.dealCard());
            }
            else {
                if (gameSpanishDeck.deck.size() != 0) {
                    cols.get(i).cards.add(gameSpanishDeck.dealCard());
                }
            }
        }
    }

    //customDeal to setup game for testing purposes (i.e. shuffled cards are random and hard to test)
    public void customDeal(int c1, int c2, int c3, int c4) {
        cols.get(0).cards.add(testDeck.deck.get(c1));
        testDeck.deck.remove(c1);
        cols.get(1).cards.add(testDeck.deck.get(c2));
        testDeck.deck.remove(c2);
        cols.get(2).cards.add(testDeck.deck.get(c3));
        testDeck.deck.remove(c3);
        cols.get(3).cards.add(testDeck.deck.get(c4));
        testDeck.deck.remove(c4);
    }

    //customSpanishDeal to setup game for testing purposes (i.e. shuffled cards are random and hard to test)
    public void customSpanishDeal(int c1, int c2, int c3, int c4) {
        cols.get(0).cards.add(testSpanishDeck.deck.get(c1));
        testSpanishDeck.deck.remove(c1);
        cols.get(1).cards.add(testSpanishDeck.deck.get(c2));
        testSpanishDeck.deck.remove(c2);
        cols.get(2).cards.add(testSpanishDeck.deck.get(c3));
        testSpanishDeck.deck.remove(c3);
        cols.get(3).cards.add(testSpanishDeck.deck.get(c4));
        testSpanishDeck.deck.remove(c4);
    }

    public void remove(int columnNumber) { //New Remove function for spanish deck
        if(columnHasCards(columnNumber)) {
            boolean removeCard = canRemove(columnNumber);
            int removeViaComodine = findComodine();
            boolean removeComodine = isComodine(columnNumber);

            if (removeComodine){ //remove the comodine (cus that is what was clicked)
                this.cols.get(columnNumber).cards.remove(this.cols.get(columnNumber).cards.size()-1);
                error=false;
            }
            else if (removeCard) { //there is a card of same suit, higher val
                this.cols.get(columnNumber).cards.remove(this.cols.get(columnNumber).cards.size() - 1); //remove card user selected
                error=false;
            }
            else if(removeViaComodine<4){ //remove using wild card rule
                if(getTopCard(columnNumber).getValue()==14){
                    error=true;
                }
                else {
                    this.cols.get(removeViaComodine).cards.remove(this.cols.get(removeViaComodine).cards.size() - 1); //remove the comodine
                    this.cols.get(columnNumber).cards.remove(this.cols.get(columnNumber).cards.size() - 1); //remove card user selected
                    error = false;
                }
            }
            else{ //cant remove
                error=true;
            }
        }
    }
    //this fn iterates through cols, ret true if there is a card of same suit && higher val than column passed in as parameter
    private boolean canRemove(int columnNumber){
        Card c = getTopCard(columnNumber);
        for (int i = 0; i < 4; i++) {
            if (i != columnNumber) {
                if (columnHasCards(i)) {
                    Card compare = getTopCard(i);
                    if (compare.getSuit() == c.getSuit()) {
                        if (compare.getValue() > c.getValue()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    //Fn to check if card user wants to remove is a comodine, ret true if card is comodine
    private boolean isComodine(int columnNumber){
        if (getTopCard(columnNumber).getValue()==0){
            return true;
        }
        return false;
    }

    //function returns column number that has a comodine on top or a "garbage" val
    private int findComodine(){
        for (int i = 0; i < 4; i++) {
            if(columnHasCards(i)){
                if(getTopCard(i).getValue()==0) {
                    return i;
                }
            }
        }
        return 7;
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
