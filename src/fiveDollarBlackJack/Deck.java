package fiveDollarBlackJack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Deck {
//	private Character[] deck = 
//		{'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 
//		 'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 
//		 'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 
//		 'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'}; 
	private Character[][] deck = {
		{'A', '♠'},{'2', '♠'},{'3', '♠'},{'4', '♠'},{'5', '♠'},{'6', '♠'},{'7', '♠'},{'8', '♠'},{'9', '♠'},{'T', '♠'},
		{'J', '♠'},{'Q', '♠'},{'K', '♠'},{'A', '♥'},{'2', '♥'},{'3', '♥'},{'4', '♥'},{'5', '♥'},{'6', '♥'},{'7', '♥'},
		{'8', '♥'},{'9', '♥'},{'T', '♥'},{'J', '♥'},{'Q', '♥'},{'K', '♥'},{'A', '♦'},{'2', '♦'},{'3', '♦'},{'4', '♦'},
		{'5', '♦'},{'6', '♦'},{'7', '♦'},{'8', '♦'},{'9', '♦'},{'T', '♦'},{'J', '♦'},{'Q', '♦'},{'K', '♦'},{'A', '♣'},
		{'2', '♣'},{'3', '♣'},{'4', '♣'},{'5', '♣'},{'6', '♣'},{'7', '♣'},{'8', '♣'},{'9', '♣'},{'T', '♣'},{'J', '♣'},
		{'Q', '♣'},{'K', '♣'}};

	private int index;
	
	public String drawOneCard() {
		return Arrays.toString(deck[index++]);
	}	

	//	public Character[] drawOneCard() {
//		return deck[index++];
//	}
	
	public void Shuffle() {
		index = 1;
		List<Character[]> list = new ArrayList<Character[]>();		
	    list.addAll(Arrays.asList(deck));
	    Collections.shuffle(list);
	    list.toArray(deck);
	    System.out.println(Arrays.deepToString(deck));
//		List<Character> list = Arrays.asList(deck); // convert array to list
//		Collections.shuffle(list); // shuffle list
//		list.toArray(deck); // convert list back to array
//		System.out.println(Arrays.toString(deck));
	}
}