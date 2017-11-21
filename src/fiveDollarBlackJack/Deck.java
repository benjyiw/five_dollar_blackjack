package fiveDollarBlackJack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {
//	private Character[] deck = 
//		{'A', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 
//		 'A', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 
//		 'A', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 
//		 'A', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'}; 
	private Character[][] deck = {{'A', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'}, {'♠', '♥', '♦', '♣'}};
	
	private int index = 1;
	
	public char drawOneCard() {
		return deck[index++];
	}
	
	public void Shuffle() {
		
//		List<Character> list = Arrays.asList(deck);
//		Collections.shuffle(list);
//		list.toArray(deck);
//		System.out.println(Arrays.toString(deck));
	}
}