/*****************************************
* Project: $5 Blackjack
* Group Members: Trent Greguhn, Benjamin Wesemann, Benjamin Trueman
* Class Author : Trent Greguhn
* Date : 11/19/2017
* Assignment: A08 – Patterns
******************************************/

package fiveDollarBlackJack;

import java.util.Scanner;
import java.util.ArrayList;

public class FiveDollarBlackJackApp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int playerBet = 0;
		char playerChoice;
		ArrayList<String> playerCards = new ArrayList<String>();
		ArrayList<String> dealerCards = new ArrayList<String>();
		Deck myDeck = new Deck();
		
		System.out.println("Welcome to $5 Blackjack!");
		System.out.print("How much money do you have?: $");
		int playerMoney = input.nextInt();
		
		System.out.print("Enter a bet ($5 minimum): $");
		playerBet = input.nextInt();
		
		do {
		if (playerBet < 5) {
			System.out.print("Please enter a valid bet!: $");
			playerBet = input.nextInt();
		}
		else if(playerMoney < playerBet){
			System.out.print("You don't have enough money! Try again...: $");
			playerBet = input.nextInt();
		}
		}while(playerBet < 5 || playerMoney < playerBet);
		
		System.out.println("Let's start!");
		System.out.println("Dealer is shuffling...");
		myDeck.Shuffle();
		sleep(2000);
		System.out.println("Dealer is drawing...");
		sleep(2000);
		String dealerCardOne = myDeck.drawOneCard();
		String dealerCardTwo = myDeck.drawOneCard();
		dealerCards.add(dealerCardOne);
		dealerCards.add(dealerCardTwo);
		System.out.printf("Dealer has %s [*]%n", dealerCardOne);
		System.out.println("Dealer is dealing your hand...");
		sleep(3000);
		String playerCardOne = myDeck.drawOneCard();
		String playerCardTwo = myDeck.drawOneCard();
		playerCards.add(playerCardOne);
		playerCards.add(playerCardTwo);
		System.out.printf("You have: %s %s%n", playerCardOne, playerCardTwo);
		System.out.print("Would you like to Hit (H) or Stay (S)?: ");
		playerChoice = input.next(".").charAt(0);
		do {
		switch(playerChoice) {
		case 'h':
		case 'H': System.out.println("Drawing...");
				  sleep(2000);
				  String userCardThree = myDeck.drawOneCard();
				  playerCards.add(userCardThree);
				  System.out.printf("You have: %s %s %s%n",
						  playerCardOne, playerCardTwo, userCardThree);
				  /*if (Hand.getTotal(playerCards) > 21) {
					  
				  }*/
				  break;
		case 's':
		case 'S':
		default: System.out.print("Please Hit (H) or Stay (S): ");
				 playerChoice = input.next(".").charAt(0);
		}
		}while(playerChoice == 'H' || playerChoice == 'S');
		
		
		
		input.close();
	}
	
/*	public static void userBet(int playerBet) {
		Scanner input = new Scanner(System.in);
		do {
		System.out.println("Enter a bet ($5 minimum): $");
		playerBet = input.nextInt();
		}while(playerBet < 5);
		input.close();
	}*/
	
	public static void sleep(int milliseconds) {
		try {
		    Thread.sleep(milliseconds);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
	
}
