import static org.junit.Assert.*;
import java.util.ArrayList;

public class PlayerTest {

    Player player;
    Deck deck;
    ArrayList<Card> inputCards;
    Card c1 = new Card (4,6);
    Card c2 = new Card (4,3);
    Card c3 = new Card (1,12);
    Card c4 = new Card (2,13);
    Card c5 = new Card (3,8);

    @org.junit.Before
    public void setUp() throws Exception {

        player = new Player("p1");
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
    public void createHandTest() {
        player.createHand(inputCards);
        assertEquals(inputCards,player.getHand());
    }

    @org.junit.Test
    public void drawCardTest() {
        Card drawnCard = deck.getDeck().get(0);
        player.drawCard(deck);
        assertEquals(true,player.getHand().contains(drawnCard));
    }

    @org.junit.Test
    public void sizeOfDeckAfterDrawCardTest() {
        Deck d = new Deck();
        Player p1 = new Player("p1");
        p1.drawCard(d);
        int size = d.getSize();
        assertEquals(51,size);
    }

    @org.junit.Test
    public void discardCardTest() {
        player.createHand(inputCards);
        player.discardCard(c1);
        assertEquals(false,player.getHand().contains(c1));

    }

}