package study.basics;

public class DeckOfCardsTest
{

	public static void main(String[] args)
	{
		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle(); // place Cards in random order
		
		// print all 52 cards in the order in which they are dealt
		for (int i = 1; i <= DeckOfCards.NUMBER_OF_CARDS; i++)
		{
			System.out.printf("%-19s", myDeckOfCards.dealCard());
			
			if (i%4 == 0)
				System.out.println();
		}		
	} // end of main
}
