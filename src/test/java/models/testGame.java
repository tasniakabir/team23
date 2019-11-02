package models;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class testGame {

    @Test
    public void testGameCreation(){
        Game g = new Game();
        assertNotNull(g);
    }

    @Test
    public void testGameBuildDeck(){
        Game g = new Game();
        assertEquals(52,g.gameDeck.deck.size());
    }

    @Test
    public void testGameBuildSpanishDeck(){

        Game g = new Game();
        assertEquals(50, g.gameSpanishDeck.deck.size());
    }

    @Test
    public void testGameShuffle(){
        Game g1 = new Game();
        Game g2 = new Game();
        // g1 and g2 could shuffle to the same order, but that chance is approximately 1 in 8*10^67 shuffles
        assertFalse(Arrays.equals(g1.gameDeck.deck.toArray(),g2.gameDeck.deck.toArray()));
    }

    @Test
    public void testGameSpanishShuffle(){
        Game g1 = new Game();
        Game g2 = new Game();
        // g1 and g2 could shuffle to the same order, but that chance is approximately 1 in 8*10^67 shuffles
        assertFalse(Arrays.equals(g1.gameSpanishDeck.deck.toArray(),g2.gameSpanishDeck.deck.toArray()));
    }

    @Test
    public void testGameStart(){
        Game g = new Game();
        g.dealFour(0);
        assertEquals(1,g.cols.get(0).cards.size());
        assertEquals(1,g.cols.get(1).cards.size());
        assertEquals(1,g.cols.get(2).cards.size());
        assertEquals(1,g.cols.get(3).cards.size());
    }

    @Test
    public void testSpanishGameStart(){
        Game g = new Game();
        g.dealFour(1);
        assertEquals(1,g.cols.get(0).cards.size());
        assertEquals(1,g.cols.get(1).cards.size());
        assertEquals(1,g.cols.get(2).cards.size());
        assertEquals(1,g.cols.get(3).cards.size());
    }

    @Test
    public void testCustomDeal(){
        Game g = new Game();
        g.customDeal(0,0,0,0);
        assertEquals("2&clubs",g.cols.get(0).cards.get(0).toString());
        assertEquals("2&hearts",g.cols.get(1).cards.get(0).toString());
        assertEquals("2&diams",g.cols.get(2).cards.get(0).toString());
        assertEquals("2&spades",g.cols.get(3).cards.get(0).toString());
    }

    @Test
    public void testSpanishCustomDeal(){
        Game g = new Game();
        g.customSpanishDeal(0,0,0,0);
        assertEquals("14Bastos",g.cols.get(0).cards.get(0).toString());
        assertEquals("14Oros",g.cols.get(1).cards.get(0).toString());
        assertEquals("14Copas",g.cols.get(2).cards.get(0).toString());
        assertEquals("14Espadas",g.cols.get(3).cards.get(0).toString());
    }

    @Test
    public void testRemoveFunction(){
        Game g = new Game();
        g.customDeal(0,3,6,9);
        g.remove(2);
        assertEquals(0,g.cols.get(2).cards.size());
    }

}
