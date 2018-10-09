import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

public class GameTest {
    Game g;
    HandChecker h = new HandChecker();

    @org.junit.Before
    public void setUp() throws Exception {
        g = new Game();
    }

    private List<Card> createHandsFromStringArray(String[] cardStrings) {
        List<Card> cardsInput = new ArrayList<Card>();
        for (String cardString : cardStrings) {
            cardsInput.add(new Card(cardString));
        }
        return cardsInput;
    }

    private List storeAIPInitialHand(String gameLine){
        g.setUpForInitialHands(gameLine);
        List<Card>beginningAIPHand = new ArrayList<Card>(g.getAip().getHand());
        h.sortHand(beginningAIPHand);
        return beginningAIPHand;
    }

    @org.junit.Test
    public void runRoyalFlushAndHoldTest() {
        String gameLine = "SA SJ SQ SK S10 H9 H10 HJ HQ HK";
        List<Card>beginningAIPHand = storeAIPInitialHand(gameLine);

        g.playRound(gameLine);

        assertEquals(beginningAIPHand,g.getAip().getHand());
    }

}