/*****************************************
* Project: $5 Blackjack
* Group Members: Trent Greguhn, Benjamin Wesemann, Benjamin Trueman
* Class Author : Trent Greguhn
* Date : 11/26/2017
* Assignment: A08 – Patterns
******************************************/

package fiveDollarBlackJack;

import java.util.Scanner;


public class FiveDollarBlackJackApp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int playerBet = 0;
		int playerMoney = 0;
		char playerChoice;
		char continueGame;

		Deck myDeck = new Deck();
		Hand dealer = new Hand();
		Hand player = new Hand();
		
		//I asked for money, not alphabet soup. How much money ya got?
		
		// PLAYER ESTABLISHES STARTING MONEY
		System.out.println("Welcome to $5 Blackjack!");
		System.out.println();
		System.out.print("How much money do you have?: $");
			playerMoney = input.nextInt();
			playerMoney(playerMoney);
		
		//FIXME START DO/WHILE LOOP HERE
		//PLAYER STARTS BET
		System.out.print("Enter a bet ($5 minimum): $");
			playerBet = input.nextInt();
			playerBet = betLogic(input, playerBet, playerMoney);

		
		//BET CONFIRMED AND DEALER HANDS OUT CARDS
		System.out.println();
		System.out.println("$" + playerBet + " player bet. Let's start!");
		System.out.println("Dealer is shuffling...");
		myDeck.shuffle();
		sleep(2000);
		System.out.println("Dealer is drawing...");
		sleep(2000);
		dealer.addCard(myDeck.drawOneCard());
		System.out.print("Dealer has "); 
		dealer.printAllCards();
		System.out.println("[*]");
		dealer.addCard(myDeck.drawOneCard());
		System.out.println("Dealer is dealing your hand...");
		sleep(3000);
		System.out.print("You have "); 
		player.addCard(myDeck.drawOneCard());
		player.addCard(myDeck.drawOneCard());
		player.printAllCards();
		System.out.println();

		//DEALER GETS BLACKJACK
		if (dealer.getTotal() == 21 && player.getTotal() != 21) {
			dealer.printLastCard();
			System.out.println();
			System.out.println("Dealer has blackjack!"); 
			playerLost(playerBet, playerMoney);
			System.out.println("Do you want to play again? (Y or N)");
			continueGame = input.next(".").charAt(0);
		//PLAYER GETS BLACKJACK	
		} else if(dealer.getTotal() != 21 && player.getTotal() == 21) {
			System.out.println();
			System.out.println("Dealer only has ");
			dealer.printAllCards();
			System.out.println();
			System.out.println("You got blackjack!");
			playerWon(playerBet, playerMoney);
			System.out.println("Do you want to play again? (Y or N)");
			continueGame = input.next(".").charAt(0);
		//BOTH PLAYERS HAVE BLACKJACK
		} else if(dealer.getTotal() == 21 && player.getTotal() == 21){
			player.printAllCards();
			System.out.println();
			dealer.printAllCards();
			System.out.println();
			System.out.println("You both have blackjack. It's a push! You get your moneys back.");
			System.out.println("Do you want to play again? (Y or N)");
			continueGame = input.next(".").charAt(0);
		//NEITHER PLAYER HAS BLACKJACK
		} else {
			
		//TEST PLAYER TOTALS
		System.out.println(player.getTotal());
		System.out.println(dealer.getTotal());
		
		//HIT OR STAY PHASE
		System.out.print("Would you like to Hit (H) or Stay (S)?: ");
		playerChoice = input.next(".").charAt(0);
		do {
			switch(playerChoice) {
			case 'h':
			case 'H': System.out.println("Drawing...");
					sleep(2000);
					// String userCardThree = myDeck.drawOneCard();
					// playerCards.add(userCardThree);
					// System.out.printf("You have: %s %s %s%n",
					//		  playerCardOne, playerCardTwo, userCardThree);
					/*if (Hand.getTotal(playerCards) > 21) {
					  
				  	}*/
					//FIXFME MAKE SURE TO FIX DO/WHILE
				  break;
			case 's':
			case 'S':
				  break;
			default: System.out.print("Please Hit (H) or Stay (S): ");
				 playerChoice = input.next(".").charAt(0);
			}
		}while(playerChoice == 'H' || player.getTotal() > 21);
		
		
		
		input.close();
		}
	}

	private static void playerWon(int playerBet, int playerMoney) {
		System.out.println("You won $"
				+ playerBet + "!");
		playerMoney += playerBet;
	}

	private static void playerLost(int playerBet, int playerMoney) {
		System.out.println("You lost $"
				+ playerBet + "...");
		playerMoney -= playerBet;
	}

	private static void playerMoney(int playerMoney) {
		do {
			if(playerMoney < 5) {
				System.out.print("You have $" + playerMoney + 
						"? You need at least $5 to play. Get outta here!");
				System.exit(0);
			}
			else {}
		}while(playerMoney < 5);
	}

		private static int betLogic(Scanner input, int playerBet, int playerMoney) {
			do {
				if (playerBet < 5) {
					System.out.print("This table has a $5 minimum. Please enter a valid bet!: $");
					playerBet = input.nextInt();
				}
				else if(playerMoney < playerBet){
					System.out.print("You don't have enough money for that bet! Try again...: $");
					playerBet = input.nextInt();
				}
			}while(playerBet < 5 || playerMoney < playerBet);
			
			return playerBet;
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
