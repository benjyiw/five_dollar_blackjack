package fiveDollarBlackJack;

import java.util.Scanner;

public class FiveDollarBlackJackApp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int playerBet = 0;
		
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
//		Deck.shuffle();
		sleep();
		System.out.println("Dealer has");
		
	}
	
/*	public static void userBet(int playerBet) {
		Scanner input = new Scanner(System.in);
		do {
		System.out.println("Enter a bet ($5 minimum): $");
		playerBet = input.nextInt();
		}while(playerBet < 5);
		input.close();
	}*/
	
	public static void sleep() {
		try {
		    Thread.sleep(3000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
}
