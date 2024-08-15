import java.util.ArrayList;
import java.util.List;

public class Hand {
    //Stores the cards dealt to a player in an array list called 'hand' and calculates the total value of the hand.
    private List<Card> hand;

    public Hand() {
        hand = new ArrayList<>();
    }

    //Adds card objects to the hand
    public void addCard(Card card) {
        hand.add(card);
    }

    //Calculates the points value of a hand and counts the number of aces in the hand
    public int calculatePoints() {
        int points = 0;
        int aces = 0;

        for (Card card : hand) {
            points += card.getValue();
            if (card.getRank().equals("A")) {
                aces++;
            }
        }

        /*If the points exceed 21 and the hand has one ace or more, the points decrease
        by 10 so that the ace adds 1 point instead of 11. The ac counter decreases by 1.
        */
        while (points > 21 && aces > 0) {
            points -= 10;
            aces--;
        }

        return points;
    }

    //Prints each card in the hand
    public void displayHand() {
        for (Card card : hand) {
            System.out.println(card);
        }
    }

    public int size() {
        return hand.size();
    }

    public Card getCard(int index) {
        return hand.get(index);
    }
}

