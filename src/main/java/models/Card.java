package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Assignment 1: No changes are needed in this file, but it is good to be aware of for future assignments.
 */

public class Card implements Serializable {
    public final int value;
    public final Suit suit;

    @JsonCreator
    public Card(@JsonProperty("value") int value, @JsonProperty("suit") Suit suit) {
        this.value = value;
        this.suit = suit;

    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

  /*  public String toString() {
        return this.value + this.suit.toString();
    }
    */
  public String toString() {

      if(this.suit.toString() == "Diamonds") {
          //this.suit = "&diams";
          return this.value + "&diams";
      }
      if(this.suit.toString() == "Hearts") {
          //this.suit = "&hearts";
          return this.value + "&hearts";
      }
      if(this.suit.toString() == "Spades") {
          //this.suit = "&spades";
          return this.value + "&spades";
      }
      if(this.suit.toString() == "Clubs") {
          //this.suit = "&clubs";
          return this.value + "&clubs";
      }
      return this.value + this.suit.toString();
  }

}

