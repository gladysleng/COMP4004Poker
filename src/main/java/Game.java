import java.util.ArrayList;
import java.util.List;


///// REMEMBER  AFTER READING THE CARD TO EXCHANGE OR AFTER EXCHANGING
//// REMOVE IT FROM THE DECK


public class Game {
    private Deck deck;
    private Player p1, p2;
    //Temporarily for input files
    String handString = "DA C3 C5 C2 C6";
    String handString2 = "DK C10 H5 DJ H3";

    public Game() {
        deck = new Deck();
        p1 = new Player("P1");
        p2 = new Player("P2");
    }

    private List<Card> createPlayerHand(String handString) {
        List<Card> cardsInput = new ArrayList<Card>();
        String[] cardStrings = handString.split(" ");

        for (String cardString : cardStrings) {
            cardsInput.add(new Card(cardString));
        }

        deck.removeCardsFromDeck(cardsInput);
        return cardsInput;
    }

    public void startGame(){
        p1.createHand(createPlayerHand(handString));
        p1.createHand(createPlayerHand(handString2));
    }

    public void printDiscardedCard(List<Card>c){
        //
    }
}
