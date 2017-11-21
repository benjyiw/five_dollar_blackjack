package fiveDollarBlackJack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {
	private Character[] deck = 
		{'A', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 
		 'A', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 
		 'A', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 
		 'A', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'}; 
	private int index;
	
	public char drawOneCard() {
		return deck[index++];
	}
	
	public void Shuffle() {
		index = 1;
		List<Character> list = Arrays.asList(deck);
		Collections.shuffle(list);
		list.toArray(deck);
//		System.out.println(Arrays.toString(deck));
	}
}