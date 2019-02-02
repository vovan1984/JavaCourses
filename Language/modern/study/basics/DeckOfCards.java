package study.basics;

import java.security.SecureRandom;

// Car shuffling and dealing simulation
public class DeckOfCards
{
	private Card[] deck;
	private int currentCard; // index of next card to be dealt (0-51)
	protected final static int NUMBER_OF_CARDS = 52; // constant # of cards
	// random number generate
	private final static SecureRandom randomNumber = new SecureRandom();
	
	public DeckOfCards()
	{
		String faces[] = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
				          "Jack", "Queen", "King"};
		String suites[] = {"Hearts", "Diamonds", "Clubs", "Spades"};
		deck = new Card[NUMBER_OF_CARDS];
		
		currentCard = 0; // first Card dealt will be deck[0];
		
		for (int count=0; count < deck.length; count++)
			deck[count] = new Card(faces[count%13], suites[count/13]);
	}
	
	public void shuffle()
	{
		// next call to dealCard should start with deck[0] again
		currentCard = 0;
		
		for (int first = 0; first < deck.length; first++)
		{
			// select a random number between 0 and 51
			int second = randomNumber.nextInt(NUMBER_OF_CARDS);
			
			Card temp = deck[first];
			deck[first] = deck[second];
			deck[second] = temp;
		}
	} // end of shuffle
	
	public Card dealCard()
	{
		// determine if any card is left to be dealt
		if (currentCard < deck.length)
			return deck[currentCard++];
		else 
			return null;
	}
} // end of DeckOfCards class
