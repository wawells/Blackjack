package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Deck.Deck;

class DeckTest {

	private Deck deck;
	
	
	@Test
	void testOneDeck() {
		
		deck = new Deck();
		
		assertNotNull(deck);
		
		assertEquals(52, deck.getSize());
		
	}
	
	
	@Test
	void testTwoDeck()
	{
		deck = new Deck(2);
		
		
		assertEquals(104, deck.getSize());
	}
	
	
	@Test
	void testDrawCard()
	{
		deck = new Deck();
		
		assertEquals(52, deck.getSize());
		
		deck.drawCard();
				
		assertEquals(51, deck.getSize());
		
	}
	
	@Test
	void testDiscard()
	{
		deck = new Deck();
		
		
		deck.drawCard();
		deck.drawCard();
		deck.drawCard();
		deck.drawCard();
		
		
		assertEquals(48, deck.getSize());
		
		deck.shuffle();
		
		assertEquals(52, deck.getSize());
		
		
	}

}
