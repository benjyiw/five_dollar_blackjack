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
		int winningsLosses = 0;
		char playerChoice;
		char continueGame = 'Y';

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
		do {
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
			playerLost(playerBet, playerMoney, winningsLosses);
			System.out.println("Do you want to play again? (Y or N)");
			continueGame = input.next(".").charAt(0);
		//PLAYER GETS BLACKJACK	
		} else if(dealer.getTotal() != 21 && player.getTotal() == 21) {
			System.out.println();
			System.out.println("Dealer only has ");
			dealer.printAllCards();
			System.out.println();
			System.out.println("You got blackjack!");
			playerWon(playerBet, playerMoney, winningsLosses);
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
		
		//HIT OR STAY PHASE
		System.out.print("Would you like to Hit (H) or Stay (S)?: ");
		playerChoice = input.next(".").charAt(0);
		do {
			switch(playerChoice) {
			case 'h':
			case 'H': System.out.println("Drawing...");
					sleep(2000);
					player.addCard(myDeck.drawOneCard());
					player.printAllCards();
					if(player.getTotal() > 21) {
						System.out.println("You bust! You lose...");
						playerLost(playerBet, playerMoney, winningsLosses);
						System.out.println("Do you want to play again? (Y or N)");
						continueGame = input.next(".").charAt(0);
						playerChoice = 'D';
					}
					else {
						
					}
				  break;
			case 's':
			case 'S': System.out.println("You have " + player.getTotal());
					  System.out.println("Dealer has "); dealer.printAllCards();
					  do {
						  System.out.println("Dealer is drawing again");
						  dealer.addCard(myDeck.drawOneCard());
					  }while(dealer.getTotal() < 17);
					  if(dealer.getTotal() > 21) {
						  System.out.println("Dealer has" + dealer.getTotal());
						  sleep(2000);
						  System.out.println("Dealer busts... you win!");
						  playerWon(playerBet, playerMoney, winningsLosses);
						  System.out.println("Do you want to play again? (Y or N)");
						  continueGame = input.next(".").charAt(0);
						  playerChoice = 'D';
					  }
					  else {
						  System.out.println("Dealer has" + dealer.getTotal());
						  sleep(2000);
						  System.out.println("You have: " + player.getTotal());
						  if(dealer.getTotal() > player.getTotal()) {
							  System.out.println("Dealer has higher hand... you lose.");
							  playerLost(playerBet, playerMoney, winningsLosses);
							  System.out.println("Do you want to play again? (Y or N)");
							  continueGame = input.next(".").charAt(0);
							  playerChoice = 'D';
						  }
						  else {
							  System.out.println("Your hand is higher than dealer's, you win!");
							  playerWon(playerBet, playerMoney, winningsLosses);
							  System.out.println("Do you want to play again? (Y or N)");
							  continueGame = input.next(".").charAt(0);
							  playerChoice = 'D';
						  }
					  }
				  break;
			default: do {
						 System.out.print("Please Hit (H) or Stay (S): ");
						 playerChoice = input.next(".").charAt(0);
						}while(playerChoice != 'H' || playerChoice != 'h'
							|| playerChoice != 's' || playerChoice != 's');
				 break;
			}
		}while(playerChoice == 'H' || playerChoice == 'h'
				|| playerChoice == 'S' || playerChoice == 's');
		}
		myDeck.shuffle();
		player.clearHand();
		dealer.clearHand();
		}while(continueGame == 'Y' || continueGame == 'y');
		System.out.println("That's too bad-- but let's look at how you did!");
		sleep(3000);
		System.out.println("Total winnings/losses: " + winningsLosses);
		sleep(2000);
		System.out.println("Current money: " + (playerMoney + winningsLosses));
		sleep(2000);
		if(playerMoney < 0) {
			System.out.println("Looks like you owe us money... better speak to our cashier.");
		}
		else if(winningsLosses < 0) {
			System.out.println("Ouch, lost a little bit... better luck next time.");
		}
		else {
			System.out.println("Nice, well done! See you next time!");
		}
		input.close();
		
	}

	private static void playerWon(int playerBet, int playerMoney, int winningsLosses) {
		System.out.println("You won $"
				+ playerBet + "!");
		playerMoney += playerBet;
		winningsLosses += playerBet;
	}

	private static void playerLost(int playerBet, int playerMoney, int winningsLosses) {
		System.out.println("You lost $"
				+ playerBet + "...");
		playerMoney -= playerBet;
		winningsLosses += playerBet;
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
