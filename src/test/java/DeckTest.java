import static org.junit.Assert.*;
import java.util.ArrayList;

public class DeckTest {

    Deck deck;
    ArrayList<Card> inputCards;
    Card c1 = new Card (2,4);
    Card c2 = new Card (2,3);
    Card c3 = new Card (1,4);
    Card c4 = new Card (4,3);
    Card c5 = new Card (3,6);

    @org.junit.Before
    public void setUp() throws Exception {
        deck = new Deck();
        inputCards = new ArrayList<Card>();
        inputCards.add(c1);
        inputCards.add(c2);
        inputCards.add(c3);
        inputCards.add(c4);
        inputCards.add(c5);

    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void poppedCardRemoveFromDeck() {
        Card c = deck.pop();
        assertEquals(false,deck.getDeck().contains(c));

    }

    @org.junit.Test
    public void pop() {
        Card c = deck.getDeck().get(0);
        assertEquals(c,deck.pop());

    }

    @org.junit.Test
    public void removeCardsFromDeck() {

        deck.removeCardsFromDeck(inputCards);
        assertEquals(false,deck.getDeck().contains(inputCards.get(2)));
    }
}