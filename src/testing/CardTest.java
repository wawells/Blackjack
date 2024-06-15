package testing;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

import Deck.Card;
import Deck.Rank;
import Deck.Suit;

class CardTest {

	private Card card;
	
	@Test
	void testConstructor()
	{
		card = new Card(Rank.ACE, Suit.HEARTS);
		
		assertNotNull(card);
	}
	
	@Test
	void testGetRank()
	{
		card = new Card(Rank.ACE, Suit.HEARTS);
		
		assertEquals(card.getRank(), "ACE");
	}
	
	@Test
	void testGetSuit()
	{
		card = new Card(Rank.ACE, Suit.HEARTS);
		
		assertEquals(card.getSuit(), "HEARTS");
	}
	
	
	
	@Test
	void toStringTest() {
		
		card = new Card(Rank.ACE, Suit.HEARTS);
		
		assertEquals(card.toString(), "ACE of HEARTS");
	}

}
