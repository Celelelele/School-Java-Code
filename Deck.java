import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    //Stores an array list called 'deck' whuch contains cards of each suit.
    private List<Card> deck;

    public Deck() {
        deck = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        //Cards of every suit are created as Card class objects and added to the deck.
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(rank, suit));
            }
        }
    }

    //Method to mix up the order of the cards in the deck.
    public void shuffle() {
        Collections.shuffle(deck);
    }

    //
    public Card drawCard() {
        return deck.remove(deck.size() - 1);
    }
}

