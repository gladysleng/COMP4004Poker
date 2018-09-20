import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
        createDeck();
        shuffle();
    }

    public int getSize() {
        return cards.size();
    }

    private void createDeck() {
        for (int i = 1; i < 5; i++) {
            for (int j = 2; j < 15; j++) {
                Card card = new Card(i, j);
                cards.add(card);
            }
        }
    }

    private void shuffle() {
        if(cards.size() > 1) {
            Collections.shuffle(cards);
        }
    }

    public Card pop(){
        return cards.remove(0);
    }

    public void printDeck(){
        for(int i = 0; i < cards.size(); i++){
            System.out.print(cards.get(i).toString() + " ");
        }
    }

}
