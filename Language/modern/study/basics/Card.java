package study.basics;

public class Card
{
	private final String suite; // suite of card ("Hearts", "Diamonds", ...)
	private final String face;  // face of card ("Deuce", "Ace", ...)
	
	public Card(String face, String suite)
	{
		this.face = face;
		this.suite = suite;
	}
	
	@Override
	public String toString()
	{
		return face + " of " + suite;
	}
} // end of class Card
