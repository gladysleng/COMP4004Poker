import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

public class StrategyTest {

    Strategy strategy;

    @org.junit.Before
    public void setUp() throws Exception {
        strategy = new Strategy();
    }

    private List<Card> createHand(int[][] cards) {
        List<Card> hand = new ArrayList<Card>();
        for (int[] card : cards) {
            hand.add(new Card(card[0], card[1]));
        }
        return hand;
    }

    @org.junit.Test
    public void changeOneCardForRoyalFlush_OnePair() {
        Card drawnCard = new Card(4,5);
        List<Card> c = createHand(new int[][]{
                {2, 10},
                {1, 11},
                {1, 10},
                {1, 12},
                {1, 14}
        });

        ArrayList<Card> expectedOutput = new ArrayList<Card>();
        expectedOutput.add(drawnCard);
        expectedOutput.add(c.get(2));
        expectedOutput.add(c.get(1));
        expectedOutput.add(c.get(3));
        expectedOutput.add(c.get(4));

        strategy.changeOneCardForRoyalFlush(c,drawnCard);

        assertEquals(expectedOutput, c);
    }

    @org.junit.Test
    public void changeOneCardForRoyalFlush_firstIndexIsNotRangeOf11to14() {
        Card drawnCard = new Card(4,13);
        List<Card> c = createHand(new int[][]{
                {2, 9},
                {1, 11},
                {1, 12},
                {1, 13},
                {1, 14}
        });


        ArrayList<Card> expectedOutput = new ArrayList<Card>();
        expectedOutput.add(c.get(1));
        expectedOutput.add(c.get(2));
        expectedOutput.add(c.get(3));
        expectedOutput.add(drawnCard);
        expectedOutput.add(c.get(4));

        strategy.changeOneCardForRoyalFlush(c,drawnCard);

        assertEquals(expectedOutput, c);
    }

    @org.junit.Test
    public void changeOneCardForStraightFlush_HHHHS() {
        Card drawnCard = new Card(4,7);
        List<Card> c = createHand(new int[][]{
                {4, 14},
                {3, 3},
                {3, 2},
                {3, 4},
                {3, 6}
        });

        ArrayList<Card> expectedOutput = new ArrayList<Card>();
        expectedOutput.add(c.get(2));
        expectedOutput.add(c.get(1));
        expectedOutput.add(c.get(3));
        expectedOutput.add(c.get(4));
        expectedOutput.add(drawnCard);

        strategy.changeOneCardForRoyalFlush(c,drawnCard);

        assertEquals(expectedOutput, c);
    }

    @org.junit.Test
    public void changeOneCardForStraightFlush_CHHHH() {
        Card drawnCard = new Card(4,7);
        List<Card> c = createHand(new int[][]{
                {2, 14},
                {3, 3},
                {3, 2},
                {3, 4},
                {3, 6}
        });

        ArrayList<Card> expectedOutput = new ArrayList<Card>();
        expectedOutput.add(c.get(2));
        expectedOutput.add(c.get(1));
        expectedOutput.add(c.get(3));
        expectedOutput.add(c.get(4));
        expectedOutput.add(drawnCard);

        strategy.changeOneCardForRoyalFlush(c,drawnCard);

        assertEquals(expectedOutput, c);
    }

}