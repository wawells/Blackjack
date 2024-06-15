package game;

import java.util.ArrayList;
import java.util.Iterator;

import Deck.Card;

/**
 * A class to represent a hand of cards.
 * Might want to change this to a stack or something later. also don't think hand should extend player tbh, but I don't think an interface would be good either. 
 * @author willi
 *
 */
public class Hand extends Named {

	private int cardLimit;
	private int startCount;
	private boolean[] visibility;
	private ArrayList<Card> hand;
	
	
	public Hand(String name, int cardLimit, int startCount)
	{
		
		this(name, cardLimit, startCount, null);
	}
	
	/**
	 * Creates a hand with a max size of cardLimit and visible to player based on visible[].
	 * @param cardLimit The maximum number of cards in the hand.
	 * @param visible determines the visibility of each card.
	 */
	public Hand(String name, int cardLimit, int startCount, boolean[] visible)
	{
		super(name);
		hand = new ArrayList<Card>();
		this.visibility = visible;
		this.cardLimit = cardLimit;
		this.startCount = startCount;
		
		if (visible == null || visible.length < 1) 
		{
			boolean[] tempVis = new boolean[cardLimit];
			for (int i = 0; i < cardLimit; i++)
			{
				visibility[i] = true;
				this.visibility = tempVis;
			}
		}
		
	}
	
	
	/**
	 * Gives the player's hand of cards.
	 * @return arraylist of cards of current hand.
	 */
	public ArrayList<Card> getHand()
	{
		return hand;
	}

	
	/**
	 * Adds a card to the players hand.
	 * @param toAdd the card to add to the players hand.
	 * @return int the number of cards currently in the player's hand.
	 */
	public int addCard(Card toAdd)
	{
		if (getSize() < cardLimit) hand.add(toAdd);
	
		return hand.size();
	}
	
	/**
	 * Removes the top card from the players hand and returns it.
	 * @return The Card that is removed from the player's hand.
	 */
	public Card discard()
	{
		int toRemove = getSize() - 1; //top/last card in the hand
		Card tempCard = hand.get(toRemove);
		hand.remove(toRemove);
		
		return tempCard;
	}
	
	/**
	 * Removes the particular card from the player's hand.
	 * @param card The card to remove from the player's hand.
	 * @return The card removed from the player's hand.
	 */
	public Card discard(Card card)
	{
		int removeIndex = -1;
		boolean found = false;
		Card toRemove = null;
		Iterator<Card> handIt = hand.iterator();
		
		while (handIt.hasNext() && !found)
		{
			removeIndex++;
			toRemove = handIt.next();
			if (toRemove.equals(card)) found = true; //early termination
		}
		
		hand.remove(removeIndex);
		
		return toRemove;
	}
	
	/**
	 * The current size of the player's hand.
	 * @return
	 */
	public int getSize()
	{
		return hand.size();
	}
	
	private int getStartCount()
	{
		return this.startCount;
	}
	

	/**
	 * Clears the player's hand and returns the list of cards.
	 * @return Arraylist of players cards.
	 */
	public ArrayList<Card> fold()
	{
		ArrayList<Card> tempList = hand;
		
		hand.clear();
		
		return tempList;
	}
	
	
}
