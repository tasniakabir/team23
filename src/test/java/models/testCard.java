package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testCard {
    @Test
    public void testGetSuit(){
        Card c = new Card(5,Suit.Clubs);
        assertEquals(Suit.Clubs,c.getSuit());
    }

    @Test
    public void testToString(){
        Card c = new Card(5,Suit.Clubs);
        assertEquals("5&clubs",c.toString());
    }

    @Test
    public void testMoveCard(){
        Game g = new Game();
        g.customDeal(48,7,3,9);
        g.remove(2);
        assertEquals(0,g.cols.get(2).cards.size());
        g.move(0,2);
        assertEquals(1,g.cols.get(2).cards.size());
        assertEquals(0,g.cols.get(0).cards.size());
    }

    @Test
    public void testSpanishGetSuit(){
        Card c = new Card(5,Suit.Bastos);
        assertEquals(Suit.Bastos,c.getSuit());
    }

    @Test
    public void testSpanishToString(){
        Card c = new Card(5,Suit.Bastos);
        assertEquals("5Bastos",c.toString());
    }

    @Test
    public void testSpanishMoveCard(){
        Game g = new Game();
        g.customSpanishDeal(0,7,3,9);
        g.remove(2);
        assertEquals(0,g.cols.get(2).cards.size());
        g.move(0,2);
        assertEquals(1,g.cols.get(2).cards.size());
        assertEquals(0,g.cols.get(0).cards.size());
    }
}