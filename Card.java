public class Card {
    //Stores the rank and suit of a card.
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    //Custom toString method that returns the rank and suit of a card.
    public String toString() {
        return rank + " of " + suit;
    }

    //Returns the value of a card.
    public int getValue() {
        switch (rank) {
            case "2": return 2;
            case "3": return 3;
            case "4": return 4;
            case "5": return 5;
            case "6": return 6;
            case "7": return 7;
            case "8": return 8;
            case "9": return 9;
            case "10":
            case "J":
            case "Q":
            case "K": return 10;
            case "A": return 11;
            default: throw new IllegalArgumentException("Invalid card rank: " + rank);
        }
    }
}

