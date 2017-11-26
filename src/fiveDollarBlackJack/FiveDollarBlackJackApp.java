package fiveDollarBlackJack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class FiveDollarBlackJackApp {
	
	public static void main(String[] args) {
		
		Deck myDeck = new Deck();
		myDeck.getDeck();
		System.out.println(myDeck.getCard(0));
		myDeck.Shuffle();
		myDeck.getDeck();
		System.out.println(myDeck.getCard(0));
		System.out.println(myDeck.drawOneCard());
		System.out.println(myDeck.drawOneCard());
	}
}
