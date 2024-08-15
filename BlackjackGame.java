import java.util.Scanner;

public class BlackjackGame {
    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;
    Scanner scanner = new Scanner(System.in);

    public BlackjackGame() {
        deck = new Deck();
        deck.shuffle();
        playerHand = new Hand();
        dealerHand = new Hand();
    }

    //Selects two random cards for the player and the dealer.
    public void initialDeal() {
        playerHand.addCard(deck.drawCard());
        playerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());
        dealerHand.addCard(deck.drawCard());
    }

    //Initiates the game.
    public void play() {
        initialDeal();

        System.out.println("Player's hand:");
        playerHand.displayHand();
        System.out.println("Points: " + playerHand.calculatePoints());

        System.out.println("\nDealer's hand:");
        System.out.println(dealerHand.getCard(0));
        System.out.println("[hidden card]");
        
        /*Loops the 'hit or stand' question until the player's points exceed 21 and
        they lose or they choose to stand.
        */
        while (true) {
            System.out.println("\nDo you want to hit or stand? (hit/stand)");
            String action = scanner.nextLine();//Reads player's repsonse and allocates it to a string.

            if (action.equals("hit")) {
                playerHand.addCard(deck.drawCard());
                System.out.println("Player's hand:");
                playerHand.displayHand();
                System.out.println("Points: " + playerHand.calculatePoints());

                if (playerHand.calculatePoints() > 21) {
                    System.out.println("\nYou busted! Dealer wins.");
                    return;
                }
            } else if (action.equals("stand")) {
                break;
            } else {
                System.out.println("\nInvalid action. Please choose 'hit' or 'stand'.");
            }
        }
        System.out.println("\nDealer's turn.");
        System.out.println("Dealer's hand:");
        dealerHand.displayHand();
        System.out.println("Points: " + dealerHand.calculatePoints());

        //The program automatically deals a card to the dealer's hand if the points are below 17.
        while (dealerHand.calculatePoints() < 17) {
            dealerHand.addCard(deck.drawCard());
            System.out.println("\nDealer hits.");
            System.out.println("\nDealer's hand:");
            dealerHand.displayHand();
            System.out.println("Points: " + dealerHand.calculatePoints());
        }

        //Conditional statements to cover a tie or awin from either the player or the dealer
        if (dealerHand.calculatePoints() > 21) {
            System.out.println("\nDealer busted! You win.");
        } else {
            int playerPoints = playerHand.calculatePoints();
            int dealerPoints = dealerHand.calculatePoints();

            if (playerPoints > dealerPoints) {
                System.out.println("\nYou win!");
            } else if (playerPoints < dealerPoints) {
                System.out.println("\nDealer wins.");
            } else {
                System.out.println("\nIt's a tie.");
            }
        }
    }

    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame();
        game.play();
    }

}
