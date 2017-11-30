/*team 23*/

package models;

import java.util.ArrayList;

public class Game {

    public Deck gameDeck=new Deck();
    public SpanishDeck gameSpanishDeck= new SpanishDeck();
    public java.util.List<Columns> cols = new ArrayList <> ();
    public boolean error = false;

    public Game(){
        for(int i = 1; i < 5; i++) {
            cols.add(new Columns(i));
        }
    }

    public void dealSpanishFour() {

        for(int i = 0; i < 4; i++) {

            if(gameSpanishDeck.deck.size()!=0){

                cols.get(i).cards.add(gameSpanishDeck.dealCard());

            }

        }

    }

    public void dealFour() {
        for(int i = 0; i < 4; i++) {
            cols.get(i).cards.add(gameDeck.dealCard());
        }
    }

    //customDeal to setup game for testing purposes (i.e. shuffled cards are random and hard to test)
    public void customDeal(int c1, int c2, int c3, int c4) {
        cols.get(0).cards.add(gameDeck.deck.get(c1));
        //remove(c1);
        gameDeck.deck.remove(c1);
        cols.get(1).cards.add(gameDeck.deck.get(c2));
        gameDeck.deck.remove(c2);
        //remove(c2);
        cols.get(2).cards.add(gameDeck.deck.get(c3));
        gameDeck.deck.remove(c3);
        //remove(c3);
        cols.get(3).cards.add(gameDeck.deck.get(c4));
        gameDeck.deck.remove(c4);
        //remove(c4);
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

    public void removeSpanish(int columnNumber) { //New Remove function for spanish deck
        if(columnHasCards(columnNumber)) {
            Card c = getTopCard(columnNumber);
            boolean removeCard = false;
            boolean removeComodine =false;

            //check for comodines
            int comodineCol=findComodine();
            if (comodineCol < 4){
                removeComodine=true;
                removeCard=true;
            }
            for (int i = 0; i < 4; i++) {
                if (i != columnNumber) {
                    if (columnHasCards(i)) {
                        Card compare = getTopCard(i);
                        if (compare.getSuit() == c.getSuit()) {
                            if (compare.getValue() > c.getValue()) {
                                removeCard = true;
                                removeComodine = false; //there was a card of same suit and higher value so don't remove joker
                            }
                        }
                    }
                }
            }
            if (removeCard) {
                if (removeComodine==true){
                    this.cols.get(comodineCol).cards.remove(this.cols.get(comodineCol).cards.size()-1); //remove the comodine
                }
                this.cols.get(columnNumber).cards.remove(this.cols.get(columnNumber).cards.size() - 1); //remove card user selected
                error=false;
            }
            else{
                error=true;
            }
        }
    }
    private int findComodine(){ //function returns column number that has a comodine on top or a "garbage" val
        for (int i = 0; i < 4; i++) {
            if(getTopCard(i).getValue()==0) {
                return i;
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
