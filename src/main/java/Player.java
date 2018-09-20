import java.util.ArrayList;

public class Player {

    public final static int MAX_CARD = 5;
    private String name;
    private ArrayList<Card> hand;


    public Player(String name){
        this.name = name;
        this.hand = new ArrayList<Card>();
    }

    public ArrayList<Card> getHand(){
        return hand;
    }

    public int handSize(){
        return hand.size();
    }
    //hand can only held 5 cards
    //have to make sure unwanted cards
    //is discarded before drawing a card
    public Card drawCard(Deck cardDeck){
        if(hand.size() < 5) {
            Card drawnCard = cardDeck.pop();
            hand.add(drawnCard);

            return drawnCard;
        }
        else{
            System.out.println("You need to discard card first,max number of cards is 5");
        }
        return null;
    }

    public void discardCard(Card c){
        hand.remove(c);
    }

    public void printHand(){
        for(int i = 0 ; i < handSize(); i ++){
            System.out.print(hand.get(i).toString() + " ");
        }
    }
}
