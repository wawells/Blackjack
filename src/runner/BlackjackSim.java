package runner;

import Deck.Card;
import Deck.Deck;
import game.Hand;

public class BlackjackSim {

	public static final int START_CARDS = 2;
	private int numDecks;
	private int numPlayers;
	private int cardLimit;
	
	private Hand[] playerHands;
	private Deck deck;
	
	public BlackjackSim(int numPlayers, int numDecks)
	{
		this.numPlayers = numPlayers;
		this.numDecks = numDecks;
		this.cardLimit = 11 * numDecks; //11 is the maximum number of cards possible from one deck.
		
		
		playerHands = new Hand[getNumPlayers()];
		deck = new Deck(getNumDecks());
	}
	
	
	
	public boolean play()
	{
		boolean success = false;
		
		
		
		
		return success;
		
	}
	
	
	
	private void fillHands()
	{
		
		if (getDeck().canDraw(playerHands.length * START_CARDS))
		{
			for (int i = 0; i < playerHands.length; i++)
			{
				for (int j = 0; j < START_CARDS; j++)
				{
					Card tempCard = getDeck().drawCard();
					playerHands[i].addCard(tempCard);
				}
			}
		}
	}
	
	
	private void getPlay()
	{
		for (int i = 0; i < playerHands.length; i++)
		{
			
			
		}
		
	}
	
	
	private Deck getDeck()
	{
		return this.deck;
	}
	
	
	private int getNumPlayers()
	{
		return this.numPlayers;
	}
	
	private int getCardLimit()
	{
		return this.cardLimit;
	}
	
	private int getNumDecks()
	{
		return this.numDecks;
	}
}
