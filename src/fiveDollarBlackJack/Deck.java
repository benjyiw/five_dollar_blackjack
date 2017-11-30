/*****************************************
* Project: $5 Blackjack
* Group Members: Trent Greguhn, Benjamin Wesemann, Ben Trueman
* Class Author : Ben Trueman
* Date : 11/29/2017
* Assignment: Group Project
******************************************/

package fiveDollarBlackJack;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {

	private Character[][] deck = {
		{'A', '♠'},{'2', '♠'},{'3', '♠'},{'4', '♠'},{'5', '♠'},{'6', '♠'},{'7', '♠'},{'8', '♠'},{'9', '♠'},{'T', '♠'},
		{'J', '♠'},{'Q', '♠'},{'K', '♠'},{'A', '♥'},{'2', '♥'},{'3', '♥'},{'4', '♥'},{'5', '♥'},{'6', '♥'},{'7', '♥'},
		{'8', '♥'},{'9', '♥'},{'T', '♥'},{'J', '♥'},{'Q', '♥'},{'K', '♥'},{'A', '♦'},{'2', '♦'},{'3', '♦'},{'4', '♦'},
		{'5', '♦'},{'6', '♦'},{'7', '♦'},{'8', '♦'},{'9', '♦'},{'T', '♦'},{'J', '♦'},{'Q', '♦'},{'K', '♦'},{'A', '♣'},
		{'2', '♣'},{'3', '♣'},{'4', '♣'},{'5', '♣'},{'6', '♣'},{'7', '♣'},{'8', '♣'},{'9', '♣'},{'T', '♣'},{'J', '♣'},
		{'Q', '♣'},{'K', '♣'}};
	
	private int index;
	
	public Character[] drawOneCard() {  
		return deck[index++]; // return next card as Character array
	}
	
	public void shuffle() {
		index = 1;
		List<Character[]> list = Arrays.asList(deck); // convert deck array to list
	    Collections.shuffle(list); // shuffle that list
	    list.toArray(deck); // convert list back to an array
	}    
}
