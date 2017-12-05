/*****************************************
* Project: $5 Blackjack
* Group Members: Trent Greguhn, Benjamin Wesemann, Ben Trueman
* Class Author : Trent Greguhn
* Date : 11/29/2017
* Assignment: Group Project
******************************************/

package fiveDollarBlackJack;

import java.util.Scanner;

public class FiveDollarBlackJackApp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int playerBet = 0;
		int playerMoney = 0;
		int winLose = 0;
		char playerChoice;
		char continueGame = 'Y';

		Deck myDeck = new Deck();
		Hand dealer = new Hand();
		Hand player = new Hand();
		
		// PLAYER ESTABLISHES STARTING MONEY
		System.out.println("Welcome to $5 Blackjack!");
		System.out.println();
		System.out.print("How much money do you have?: $");
		while (!input.hasNextInt()) {
			System.out.print("I asked for money, not alphabet soup... how much ya got?: $");
			input.next();
		}
		playerMoney = input.nextInt();
		playerMoney = playerMoney(playerMoney);
		
		//PLAYER STARTS BET
		do {
		System.out.print("Enter a bet ($5 minimum): $");
		while (!input.hasNextInt()) {
			System.out.print("I asked for money, not alphabet soup... how much ya bettin'?: $");
			input.next();
		}
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
		player.getTotal();
		dealer.getTotal();

		//DEALER GETS BLACKJACK
		if (dealer.getTotal() == 21 && player.getTotal() != 21) {
			System.out.print("Dealer has: ");
			dealer.printAllCards();
			System.out.println();
			System.out.println();
			System.out.println("Dealer has blackjack..."); 
			sleep(2000);
			playerMoney = playerLost(playerBet, playerMoney, winLose);
			winLose -= playerBet;
			System.out.println("Current Money: $" + playerMoney);
			System.out.print("Do you want to play again? (Y or N): ");
			continueGame = input.next().charAt(0);
			continueGame = contGameCheck(input, continueGame);
		//PLAYER GETS BLACKJACK	
		} else if(dealer.getTotal() != 21 && player.getTotal() == 21) {
			System.out.print("Dealer only has: ");
			dealer.printAllCards();
			System.out.println();
			System.out.println("You got blackjack!");
			sleep(2000);
			playerMoney = playerWon(playerBet, playerMoney, winLose);
			winLose += playerBet;
			System.out.println("Current Money: $" + playerMoney);
			System.out.print("Do you want to play again? (Y or N): ");
			continueGame = input.next().charAt(0);
			continueGame = contGameCheck(input, continueGame);
		//BOTH PLAYERS HAVE BLACKJACK
		} else if(dealer.getTotal() == 21 && player.getTotal() == 21){
			System.out.print("You have: ");
			player.printAllCards();
			System.out.println();
			System.out.print("Dealer has: ");
			dealer.printAllCards();
			System.out.println();
			sleep(2000);
			System.out.println("Current Money: $" + playerMoney);
			System.out.println("You both have blackjack. It's a push! You get your bet back.");
			System.out.print("Do you want to play again? (Y or N): ");
			continueGame = input.next().charAt(0);
			continueGame = contGameCheck(input, continueGame);
		//NEITHER PLAYER HAS BLACKJACK
		} else {
		
		//HIT OR STAY PHASE
		System.out.print("Would you like to Hit (H) or Stay (S) or Double (D)?: ");
		playerChoice = input.next().charAt(0);
		do {
			switch(playerChoice) {
			case 'h':
			case 'H': System.out.println("Drawing...");
					sleep(2000);
					player.addCard(myDeck.drawOneCard());
					player.printAllCards();
					System.out.println();
					if(player.getTotal() > 21) {
						System.out.println("You have: " + player.getTotal());
						sleep(2000);
						System.out.println("You bust! You lose...");
						sleep(2000);
						playerMoney = playerLost(playerBet, playerMoney, winLose);
						winLose -= playerBet;
						System.out.println("Current Money: $" + playerMoney);
						System.out.print("Do you want to play again? (Y or N): ");
						continueGame = input.next().charAt(0);
						continueGame = contGameCheck(input, continueGame);
						playerChoice = 'A';
					}
					else {
						System.out.println("You have: " + player.getTotal());
						do {
						 	System.out.print("Hit (H) or Stay (S)?: ");
						 	playerChoice = input.next().charAt(0);
							}while(playerChoice != 'H' && playerChoice != 'h' &&
								   playerChoice != 'S' && playerChoice != 's');
					}
				  break;
			case 'd':
			case 'D': if((playerBet * 2) > playerMoney) {
						System.out.println("You can't double your bet, you don't have the money...");
						do {
						 	System.out.print("Hit (H) or Stay (S)?: ");
						 	playerChoice = input.next().charAt(0);
							}while(playerChoice != 'H' && playerChoice != 'h' &&
								   playerChoice != 'S' && playerChoice != 's');
					}
				else {
					System.out.println("Doubling bet and drawing one card...");
					System.out.println("Drawing...");
					sleep(2000);
					player.addCard(myDeck.drawOneCard());
					player.printAllCards();
					System.out.println();
					if(player.getTotal() > 21) {
						System.out.println("You have: " + player.getTotal());
						sleep(2000);
						System.out.println("You bust! You lose...");
						sleep(2000);
						playerMoney = playerLost((playerBet * 2), playerMoney, winLose);
						winLose -= (playerBet * 2);
						System.out.println("Current Money: $" + playerMoney);
						System.out.print("Do you want to play again? (Y or N): ");
						continueGame = input.next().charAt(0);
						continueGame = contGameCheck(input, continueGame);
						playerChoice = 'A';
					}
					else {
					  System.out.println("You have: " + player.getTotal());
					  System.out.print("Dealer has: "); 
					  dealer.printAllCards();
					  System.out.println();
					  if(dealer.getTotal() < 17) {
						  do {
						  System.out.println("Dealer is drawing again...");
						  dealer.addCard(myDeck.drawOneCard());
						  dealer.printAllCards();
						  System.out.println();
					  }while(dealer.getTotal() < 17);
					  }
					  if(dealer.getTotal() > 21) {
						  System.out.println("Dealer has: " + dealer.getTotal());
						  sleep(2000);
						  System.out.println("Dealer busts... you win!");
						  sleep(2000);
						  playerMoney = playerWon((playerBet * 2), playerMoney, winLose);
						  winLose += (playerBet * 2);
						  sleep(2000);
						  System.out.println("Current Money: $" + playerMoney);
						  System.out.print("Do you want to play again? (Y or N): ");
						  continueGame = input.next().charAt(0);
						  continueGame = contGameCheck(input, continueGame);
						  playerChoice = 'A';
					  }
					  else if(dealer.getTotal() == player.getTotal()) {
						  System.out.println("You both have: " + player.getTotal());
						  sleep(2000);
						  System.out.println("It's a push-- you get your bet back.");
						  System.out.println("Current Money: $" + playerMoney);
						  System.out.print("Do you want to play again? (Y or N): ");
						  continueGame = input.next().charAt(0);
						  continueGame = contGameCheck(input, continueGame);
						  playerChoice = 'A';
					  }
					  else {
						  System.out.println("Dealer has: " + dealer.getTotal());
						  sleep(2000);
						  System.out.println("You have: " + player.getTotal());
						  if(dealer.getTotal() > player.getTotal()) {
							  sleep(2000);
							  System.out.println("Dealer has higher hand... you lose.");
							  sleep(2000);
							  playerMoney = playerLost((playerBet * 2), playerMoney, winLose);
							  winLose -= (playerBet * 2);
							  sleep(2000);
							  System.out.println("Current Money: $" + playerMoney);
							  System.out.print("Do you want to play again? (Y or N): ");
							  continueGame = input.next().charAt(0);
							  continueGame = contGameCheck(input, continueGame);
							  playerChoice = 'A';
						  }
						  else {
							  sleep(2000);
							  System.out.println("Your hand is higher than the dealer's hand, you win!");
							  sleep(2000);
							  playerMoney = playerWon((playerBet * 2), playerMoney, winLose);
							  winLose += (playerBet * 2);
							  sleep(2000);
							  System.out.println("Current Money: $" + playerMoney);
							  System.out.print("Do you want to play again? (Y or N): ");
							  continueGame = input.next().charAt(0);
							  continueGame = contGameCheck(input, continueGame);
							  playerChoice = 'A';
						  }
					  }
					}
					}
					break;
			case 's':
			case 'S': System.out.print("Dealer has: "); 
					  dealer.printAllCards();
					  System.out.println();
					  if(dealer.getTotal() < 17) {
						  do {
						  System.out.println("Dealer is drawing again...");
						  dealer.addCard(myDeck.drawOneCard());
						  dealer.printAllCards();
						  System.out.println();
					  }while(dealer.getTotal() < 17);
					  }
					  if(dealer.getTotal() > 21) {
						  System.out.println("Dealer has: " + dealer.getTotal());
						  sleep(2000);
						  System.out.println("Dealer busts... you win!");
						  sleep(2000);
						  playerMoney = playerWon(playerBet, playerMoney, winLose);
						  winLose += playerBet;
						  sleep(2000);
						  System.out.println("Current Money: $" + playerMoney);
						  System.out.print("Do you want to play again? (Y or N): ");
						  continueGame = input.next().charAt(0);
						  continueGame = contGameCheck(input, continueGame);
						  playerChoice = 'A';
					  }
					  else if(dealer.getTotal() == player.getTotal()) {
						  System.out.println("You both have: " + player.getTotal());
						  sleep(2000);
						  System.out.println("It's a push-- you get your bet back.");
						  System.out.println("Current Money: $" + playerMoney);
						  System.out.print("Do you want to play again? (Y or N): ");
						  continueGame = input.next().charAt(0);
						  continueGame = contGameCheck(input, continueGame);
						  playerChoice = 'A';
					  }
					  else {
						  System.out.println("Dealer has: " + dealer.getTotal());
						  sleep(2000);
						  System.out.println("You have: " + player.getTotal());
						  if(dealer.getTotal() > player.getTotal()) {
							  sleep(2000);
							  System.out.println("Dealer has higher hand... you lose.");
							  sleep(2000);
							  playerMoney = playerLost(playerBet, playerMoney, winLose);
							  winLose -= playerBet;
							  sleep(2000);
							  System.out.println("Current Money: $" + playerMoney);
							  System.out.print("Do you want to play again? (Y or N): ");
							  continueGame = input.next().charAt(0);
							  continueGame = contGameCheck(input, continueGame);
							  playerChoice = 'A';
						  }
						  else {
							  sleep(2000);
							  System.out.println("Your hand is higher than the dealer's hand, you win!");
							  sleep(2000);
							  playerMoney = playerWon(playerBet, playerMoney, winLose);
							  winLose += playerBet;
							  sleep(2000);
							  System.out.println("Current Money: $" + playerMoney);
							  System.out.print("Do you want to play again? (Y or N): ");
							  continueGame = input.next().charAt(0);
							  continueGame = contGameCheck(input, continueGame);
							  playerChoice = 'A';
						  }
					  }
				  break;
			default: do {
					 	System.out.print("Please Hit (H) or Stay (S): ");
					 	playerChoice = input.next().charAt(0);
						}while(playerChoice != 'H' && playerChoice != 'h' &&
							   playerChoice != 'S' && playerChoice != 's');
				 break;
			}
		}while(playerChoice == 'H' || playerChoice == 'h'
				|| playerChoice == 'S' || playerChoice == 's'
				|| playerChoice == 'D' || playerChoice == 'd');
		}
		player.clearHand();
		dealer.clearHand();
		}while(continueGame == 'Y' || continueGame == 'y' && playerMoney >= 5);
		
		//WRAPPING UP GAME AND TOTALS
		
		endOfGames(playerMoney, winLose);
		
	}

	private static char contGameCheck(Scanner input, char continueGame) {
			do {
			if (continueGame != 'Y' && continueGame != 'y' &&
				continueGame != 'N' && continueGame != 'n') {
				 	System.out.print("I'm sorry-- did you want to keep playing? Yes (Y) or No (N): ");
				 	continueGame = input.next().charAt(0);
			}
			else { 
				return continueGame; 
			}
			}while (continueGame != 'Y' && continueGame != 'y' &&
				continueGame != 'N' && continueGame != 'n');
		return continueGame;
	}

	private static void endOfGames(int playerMoney, int winLose) {
		if(playerMoney < 5) {
			System.out.println("You don't have enough money to play again...");
		}
		System.out.println("That's too bad-- but let's look at how you did!");
		sleep(3000);
		System.out.println("Total winnings/losses: " + winLose);
		sleep(2000);
		System.out.println("Final Money: $" + (playerMoney));
		sleep(2000);
		if(playerMoney < 0) {
			System.out.println("Looks like you owe us money... better speak to our cashier.");
		}
		else if(winLose < 0) {
			System.out.println("Ouch, lost a little bit... better luck next time.");
		}
		else {
			System.out.println("Nice, well done! See you next time!");
		}
	}

	private static int playerWon(int playerBet, int playerMoney, int winLose) {
		System.out.println("You won $"
				+ playerBet + "!");
		playerMoney += playerBet;
		
		return playerMoney;
	}

	private static int playerLost(int playerBet, int playerMoney, int winLose) {
		System.out.println("You lost $"
				+ playerBet + "...");
		playerMoney -= playerBet;
		
		return playerMoney;
	}
	
	private static int playerMoney(int playerMoney) {
		do {
			if(playerMoney < 5) {
				System.out.print("You have $" + playerMoney + 
						"? You need at least $5 to play. Get outta here!");
				System.exit(0);
			}
			else if (playerMoney > 2500) {
				System.out.println("Woah big spender, $500 limit on the table. Let's start there.");
				playerMoney = 500;
			}
			else {}
		}while(playerMoney < 5 || playerMoney > 2500);
		
		return playerMoney;
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

	
	public static void sleep(int milliseconds) {
		try {
		    Thread.sleep(milliseconds);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
	
}
