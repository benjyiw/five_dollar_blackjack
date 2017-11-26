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
	
//	public String drawOneCard() {
//		return Arrays.toString(deck[index++]);
//	}	

public String drawOneCard() {
	return deck[index][0] + "" + deck[index++][1]; // return card as String of number + suit
}

public void Shuffle() {
	index = 1;
	List<Character[]> list = new ArrayList<Character[]>();
    list.addAll(Arrays.asList(deck));
    Collections.shuffle(list);
    list.toArray(deck);
    //System.out.println(Arrays.deepToString(deck)); // print out shuffled deck of cards
}

public String getCard(int i) {
		return deck[i][0] + "" + deck[i][1]; // return chosen card as String of number + suit
}

public void getDeck() {
		System.out.println(Arrays.deepToString(deck)); // print out current deck of cards
}
    
//		List<Character> list = Arrays.asList(deck); // convert array to list
//		Collections.shuffle(list); // shuffle list
//		list.toArray(deck); // convert list back to array
//		System.out.println(Arrays.toString(deck));
}