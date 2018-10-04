import java.util.ArrayList;
import java.util.List;

public class Player {

    private final static int MAX_CARD = 5;
    private String name;
    private int handRank;
    private List<Card> hand;


    public Player(String name){
        this.name = name;
        this.handRank = 0 ;
        this.hand = new ArrayList<Card>();
    }

    public void createHand(List<Card>cardsFromInput){
        this.hand = cardsFromInput;
    }

    public List<Card> getHand(){
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

    public void setHandRank(int value){
        this.handRank = value;
    }

    public int getHandRank(){
        return handRank;
    }
    public void printHand(){
        for(int i = 0 ; i < handSize(); i ++){
            System.out.print(hand.get(i).toString() + " ");
        }
    }
}
