package fiveDollarBlackJack;

import java.util.Arrays;

public class FiveDollarBlackJackApp {
	
	public static void main(String[] args) {
		
		Deck myDeck = new Deck();
		myDeck.Shuffle();
		System.out.println(myDeck.drawOneCard());
	}
}
