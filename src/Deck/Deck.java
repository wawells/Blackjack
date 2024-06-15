package Deck;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * A class to represent a deck of cards.
 * @author willi
 *
 */
public class Deck {
	
	private int numDecks;
	private ArrayList<Card> deck;
	private ArrayList<Card> usedCards;
	private Random random;
	
	
	public Deck()
	{
		this(1);
	}
	
	/**
	 * Constructor to create a whole deck * numDecks.
	 * @param numDecks the number of decks of cards.
	 */
	public Deck(int numDecks)
	{
		deck = new ArrayList<Card>();
		usedCards = new ArrayList<Card>();
		this.numDecks = numDecks;
		
		createDeck(this.numDecks);
		
		
	}
	
	
	/**
	 * The size of the deck.
	 * @return The number of cards in the deck currently.
	 */
	public int getSize()
	{
		int count = 0;
		
		if (deck != null) count = deck.size();
			
		return count;
	}
	
	
	/**
	 * Draws a card from the deck and removes it. Places the card into the used pile. 
	 * @return the card randomly drawn from the deck.
	 */
	public Card drawCard()
	{
		random = new Random();
		Card toDraw = null;
		
		if(canDraw())
		{
			
			int selectedCard = random.nextInt(getSize());
			
			
			toDraw = deck.get(selectedCard);
			
			deck.remove(selectedCard);
			usedCards.add(toDraw);
		
		}
		
		return toDraw;
	}
	
	/**
	 * Puts the used cards back into the deck and clears the list of used cards.
	 * @return true if there are cards to put back into the deck.
	 */
	public boolean shuffle()
	{
		boolean success = false;
		
		if (usedCards != null && usedCards.size() > 0)
		{
			Iterator<Card> discIt = usedCards.iterator();
			
			while (discIt.hasNext())
			{
				Card tempCard = discIt.next();
				deck.add(tempCard);
			}
			
			usedCards.clear();
			
			success = true;
		}
		
		
		return success;
	}
	
	
	public boolean canDraw()
	{
		return (getSize() > 0 && usedCards.size() < numDecks * 52);
	}
	
	public boolean canDraw(int needed)
	{
		return canDraw() && getSize() >= needed;
	}
	
	
	/**
	 * Creates a deck of cards * numDecks.
	 * @param numDecks the number of decks of cards to be created.
	 * @return true if at least one deck was created and the decks are complete.
	 */
	private boolean createDeck(int numDecks)
	{
		boolean success = false;
		
		Card tempCard = null;
		
		for (int j = 0; j < numDecks; j++)
		{
			for (Rank tempRank: Rank.values())
			{
				for (Suit tempSuit: Suit.values()) 
				{
					tempCard = new Card(tempRank, tempSuit);
					deck.add(tempCard);
				}
			}
		}
		
		if (deck.size() % 52 == 0) success = true;
		
		
		return success;
	}

	
	

}
