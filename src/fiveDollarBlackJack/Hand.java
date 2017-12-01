package fiveDollarBlackJack;

import java.util.ArrayList;
import java.util.Objects;

public class Hand {
	private ArrayList<Character[]> hand = new ArrayList<>();
	private int[] total = {0, 0};
	private boolean hasAce = false;

	public void addCard(Character[] card) {
        hand.add(card);

        switch (card[0]) {
            case 'A':
                if (hasAce) {
                    total[0] += 1;
                    total[1] += 1;
                } else {
                    hasAce = true;
                    total[0] += 11;
                    total[1] += 1;
                }
                break;
            case 'T': case 'J': case 'Q': case 'K':
                total[0] += 10;
                total[1] += 10;
                break;
            default:
                total[0] += card[0] - '0';
                total[1] += card[0] - '0';
                break;
        }
    }

	public Character[][] getHand() {
		return hand.toArray(new Character[][]{new Character[hand.size()]});
	}

	public void printLastCard() {
        sleep(2000);

        String firstCard = hand.get(hand.size() - 1)[0].toString();
        String secondCard = hand.get(hand.size() - 1)[1].toString();

        if (Objects.equals(firstCard, "T")) {
            firstCard = "10";
        }
        if (Objects.equals(secondCard, "T")) {
            secondCard = "10";
        }

        System.out.printf("%s%s ", firstCard, secondCard);
    }

    public void printAllCards() {
        for (Character[] aHand : hand) {
            String firstCard = aHand[0].toString();
            String secondCard = aHand[1].toString();

            if (Objects.equals(firstCard, "T")) {
                firstCard = "10";
            }
            if (Objects.equals(secondCard, "T")) {
                secondCard = "10";
            }

            System.out.printf("%s%s ", firstCard, secondCard);
            sleep(2000);
        }
    }

	public int getTotal() {
	    if (hasAce) {
	        if (total[0] > total[1] && total[0] < 22 ) {
	            return total[0];
            } else {
	            return total[1];
            }
        } else {
	        return total[0];
        }
    }

    public void clearHand() {
	    total[0] = 0;
	    total[1] = 0;
	    hand.removeAll(hand);
    }

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}