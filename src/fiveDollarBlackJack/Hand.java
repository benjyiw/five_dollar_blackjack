package fiveDollarBlackJack;

import java.util.ArrayList;

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
	
	public int[] getTotal() {
        return total;
	}

	public boolean checkHasAce() {
	    return hasAce;
    }

}
