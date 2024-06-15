package Deck;

public class Card {

	
	private Rank rank;
	private Suit suit;
	private boolean visible;

	
	public Card(Rank rank, Suit suit)
	{
		
		this(rank, suit, true);
		
	}
	
	
	public Card(Rank rank, Suit suit, boolean visible)
	{
		this.rank = rank;
		this.suit = suit;
		this.visible = visible;
	}
	
	
	
	
	
	public Rank getRank()
	{
		return this.rank;
	}
	
	public Suit getSuit()
	{
		return this.suit;
	}
	
	
	/**
	 * Getter for card visibility.
	 * @return true if the card is visible to the player.
	 */
	public boolean isVisible()
	{
		return this.visible;
	}
	
	
	public void setVisible()
	{
		this.visible = true;
	}
	
	public void setInvisible()
	{
		this.visible = false;
	}
	
	
	public String toString()
	{
		String info = "Unknown card";
		if (visible) info = rank.name() + " of " + suit.name();
	
		return info;
	}
	
	
	public boolean equals(Card toCompare)
	{
		return this.getRank().getValue() == toCompare.getRank().getValue() && this.getSuit().name().equals(toCompare.getSuit().name());
	}
	
	
	
}
