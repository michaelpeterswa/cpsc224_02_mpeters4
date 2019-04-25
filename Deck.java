import java.util.Random;

public class Deck 
{
  
	private final int DECK_SIZE = 3;
	private final int SHUFFLE_EXCHANGES = 20;
	private final int HAND_SIZE = 1;
	public int restOfDeck = 1;
	
	Card[] deck = new Card[DECK_SIZE];
    Random r = new Random();
    
    // fill deck with cards
	public void fillDeck()
	{
		int place = 0;
		for (int face = 1; face <= 3; face++)
		{
	
			deck[place] = new Card();
			deck[place].face = face;
			place++;
		}
	}
	
	// shuffle deck
	public void shuffle()
	{
		for (int x = 0; x <= SHUFFLE_EXCHANGES; x++)
		{
			int number1 = r.nextInt(DECK_SIZE);
			int number2 = r.nextInt(DECK_SIZE);
			Card temp = deck[number1];
			deck[number1] = deck[number2];
			deck[number2] = temp;
		}
	}
	
	// deal a card
	public Card deal()
	{
        Card hand = deck[0];
		return hand;
    }
    
    public Card cp_deal()
    {
		return deck[1];
    }

    public Card empty_deal()
    {
        return deck[2];
    }
	
}