/*package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Assignment 1: No changes are needed in this file, but it is good to be aware of for future assignments.
 */

/*public class SpanishCard implements Serializable {
    public final int value;
    public final SpanishSuit suit;

    @JsonCreator
    public SpanishCard(@JsonProperty("value") int value, @JsonProperty("suit") SpanishSuit suit) {
        this.value = value;
        this.suit = suit;
        /*do I need to change "suit" to "spanishsuit"? Seems okay?
    }

    public SpanishSuit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    /*need to change the html symbols*/
  /*  public String toString() {

        if(this.suit.toString() == "Bastos") {
            //this.suit = "&diams";
            return this.value + "Bastos";
        }
        if(this.suit.toString() == "Oros") {
            //this.suit = "&hearts";
            return this.value + "Oros";
        }
        if(this.suit.toString() == "Copas") {
            //this.suit = "&spades";
            return this.value + "Copas";
        }
        if(this.suit.toString() == "Espadas") {
            //this.suit = "&clubs";
            return this.value + "Espadas";
        }
        return this.value + this.suit.toString();
    }

}*
