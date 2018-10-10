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

//    private List<Card> createHandsFromStringArray(String[] cardStrings) {
//        List<Card> cardsInput = new ArrayList<Card>();
//        for (String cardString : cardStrings) {
//            cardsInput.add(new Card(cardString));
//        }
//        return cardsInput;
//    }

    private List<Card> createExpectedHand(Card[] cards) {
        List<Card> hand = new ArrayList<Card>();
        for (Card card : cards) {
            hand.add(card);
        }
        h.sortHand(hand);
        return hand;
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

    @org.junit.Test
    public void runStraightFlushAndHoldTest() {
        String gameLine = "H9 H10 HJ HQ HK SA SJ SQ SK S10";
        List<Card>beginningAIPHand = storeAIPInitialHand(gameLine);

        g.playRound(gameLine);

        assertEquals(beginningAIPHand,g.getAip().getHand());
    }

    @org.junit.Test
    public void runFourOfAKindAndHoldTest() {
        String gameLine = "C9 H9 S9 D9 H8 H3 H5 H7 H9 H2";
        List<Card>beginningAIPHand = storeAIPInitialHand(gameLine);

        g.playRound(gameLine);

        assertEquals(beginningAIPHand,g.getAip().getHand());
    }

    @org.junit.Test
    public void runFullHouseAndHoldTest() {
        String gameLine = "H8 H9 D8 C8 D9 SK H7 DK D7 C7";
        List<Card>beginningAIPHand = storeAIPInitialHand(gameLine);

        g.playRound(gameLine);

        assertEquals(beginningAIPHand,g.getAip().getHand());
    }

    @org.junit.Test
    public void runFlushAndHoldTest() {
        String gameLine = "H7 H4 H10 H3 HJ H8 D7 S9 CJ S10";
        List<Card>beginningAIPHand = storeAIPInitialHand(gameLine);

        g.playRound(gameLine);

        assertEquals(beginningAIPHand,g.getAip().getHand());
    }

    @org.junit.Test
    public void runStraightAndHoldTest() {
        String gameLine = "S5 S6 D7 C8 D9 H4 D5 C4 S4 H2";
        List<Card>beginningAIPHand = storeAIPInitialHand(gameLine);

        g.playRound(gameLine);

        assertEquals(beginningAIPHand,g.getAip().getHand());
    }

    @org.junit.Test
    public void runOneCardAwayFromRoyalFlushTest() {
        String gameLine = "C9 DQ DJ DK DA S5 S6 D7 C8 D9 D10";
        storeAIPInitialHand(gameLine);

        List<Card> expectedOutput = createExpectedHand(new Card[]{
                g.getAip().getHand().get(1),
                g.getAip().getHand().get(2),
                g.getAip().getHand().get(3),
                g.getAip().getHand().get(4),
                g.getCardsToExchange().get(0)
        });
        h.sortHand(expectedOutput);

        g.playRound(gameLine);

        assertEquals(expectedOutput,g.getAip().getHand());
    }

    @org.junit.Test
    public void runOneCardAwayFromRoyalFlush_OnePairTest() {
        String gameLine = "CJ CK C10 H10 CA H7 H4 H10 H3 HJ HK";
        storeAIPInitialHand(gameLine);

        List<Card> expectedOutput = createExpectedHand(new Card[]{
                g.getAip().getHand().get(1),
                g.getAip().getHand().get(2),
                g.getAip().getHand().get(0),
                g.getAip().getHand().get(4),
                g.getCardsToExchange().get(0)
        });

        g.playRound(gameLine);
        h.sortHand(expectedOutput);
        assertEquals(expectedOutput,g.getAip().getHand());
    }

    @org.junit.Test
    public void runOneCardAwayFromStraightFlush_AceTest() {
        String gameLine = "SA H3 H2 H4 HA H8 H9 D8 C8 D9 H5";
        storeAIPInitialHand(gameLine);

        List<Card> expectedOutput = createExpectedHand(new Card[]{
                g.getAip().getHand().get(1),
                g.getAip().getHand().get(2),
                g.getAip().getHand().get(3),
                g.getAip().getHand().get(4),
                g.getCardsToExchange().get(0)
        });

        g.playRound(gameLine);
        h.sortHand(expectedOutput);
        assertEquals(expectedOutput,g.getAip().getHand());
    }

    @org.junit.Test
    public void runOneCardAwayFromStraightFlush_OnePairWithRangeTest() {
        String gameLine = "S7 S3 S4 S6 H7 H8 H9 D8 C8 D9 S5";
        storeAIPInitialHand(gameLine);

        List<Card> expectedOutput = createExpectedHand(new Card[]{
                g.getAip().getHand().get(1),
                g.getAip().getHand().get(2),
                g.getAip().getHand().get(3),
                g.getAip().getHand().get(0),
                g.getCardsToExchange().get(0)
        });

        g.playRound(gameLine);
        h.sortHand(expectedOutput);
        assertEquals(expectedOutput,g.getAip().getHand());
    }

    @org.junit.Test
    public void runOneCardAwayFromFlushTest() {
        String gameLine = "H3 H5 C9 HJ HQ SK H7 DK D7 C7 CJ";
        storeAIPInitialHand(gameLine);

        List<Card> expectedOutput = createExpectedHand(new Card[]{
                g.getAip().getHand().get(1),
                g.getAip().getHand().get(4),
                g.getAip().getHand().get(3),
                g.getAip().getHand().get(0),
                g.getCardsToExchange().get(0)
        });

        g.playRound(gameLine);
        h.sortHand(expectedOutput);
        assertEquals(expectedOutput,g.getAip().getHand());
    }

    @org.junit.Test
    public void runOneCardAwayFromStraight_OnePairRangeOfFourTest() {
        String gameLine = "C6 C3 C5 H5 S7 H8 H9 D8 C8 D9 H4";
        storeAIPInitialHand(gameLine);

        List<Card> expectedOutput = createExpectedHand(new Card[]{
                g.getAip().getHand().get(1),
                g.getAip().getHand().get(4),
                g.getAip().getHand().get(3),
                g.getAip().getHand().get(0),
                g.getCardsToExchange().get(0)
        });

        g.playRound(gameLine);
        h.sortHand(expectedOutput);
        assertEquals(expectedOutput,g.getAip().getHand());
    }

    @org.junit.Test
    public void runOneCardAwayFromStraight_OnePairRangeOfThreeTest() {
        String gameLine = "C2 C3 C4 H2 S5 H8 H9 D8 C8 D9 H5";
        storeAIPInitialHand(gameLine);

        List<Card> expectedOutput = createExpectedHand(new Card[]{
                g.getAip().getHand().get(1),
                g.getAip().getHand().get(4),
                g.getAip().getHand().get(2),
                g.getAip().getHand().get(3),
                g.getCardsToExchange().get(0)
        });

        g.playRound(gameLine);
        h.sortHand(expectedOutput);
        assertEquals(expectedOutput,g.getAip().getHand());
    }

    @org.junit.Test
    public void runThreeCardsSameSuit_exchangeTwoCardsTest() {
        String gameLine = "C4 C7 C9 H3 DJ C6 C3 C5 H5 S7 H9 H4";
        storeAIPInitialHand(gameLine);

        List<Card> expectedOutput = createExpectedHand(new Card[]{
                g.getAip().getHand().get(1),
                g.getAip().getHand().get(0),
                g.getAip().getHand().get(2),
                g.getCardsToExchange().get(1),
                g.getCardsToExchange().get(0)
        });

        g.playRound(gameLine);
        h.sortHand(expectedOutput);
        assertEquals(expectedOutput,g.getAip().getHand());
    }

    @org.junit.Test
    public void runThreeCardsSameRank_exchangeTwoCardsTest() {
        String gameLine = "D7 C7 C9 H7 DK C6 C3 C5 H5 S7 H9 SK";
        storeAIPInitialHand(gameLine);

        List<Card> expectedOutput = createExpectedHand(new Card[]{
                g.getAip().getHand().get(1),
                g.getAip().getHand().get(0),
                g.getAip().getHand().get(3),
                g.getCardsToExchange().get(1),
                g.getCardsToExchange().get(0)
        });

        g.playRound(gameLine);
        h.sortHand(expectedOutput);
        assertEquals(expectedOutput,g.getAip().getHand());
    }

    @org.junit.Test
    public void runThreeCardsInSequence_exchangeTwoCardsTest() {
        String gameLine = "D5 C6 C7 HQ DK C6 C3 C5 H5 S7 H9 SK";
        storeAIPInitialHand(gameLine);

        List<Card> expectedOutput = createExpectedHand(new Card[]{
                g.getAip().getHand().get(1),
                g.getAip().getHand().get(0),
                g.getAip().getHand().get(2),
                g.getCardsToExchange().get(1),
                g.getCardsToExchange().get(0)
        });

        g.playRound(gameLine);
        h.sortHand(expectedOutput);
        assertEquals(expectedOutput,g.getAip().getHand());
    }

    @org.junit.Test
    public void runTwoDistinctPair_changeOneCardTest() {
        String gameLine = "H7 D3 C7 HK DK C6 C3 C5 H5 S7 SK";
        storeAIPInitialHand(gameLine);

        List<Card> expectedOutput = createExpectedHand(new Card[]{
                g.getAip().getHand().get(3),
                g.getAip().getHand().get(0),
                g.getAip().getHand().get(2),
                g.getAip().getHand().get(4),
                g.getCardsToExchange().get(0)
        });

        g.playRound(gameLine);
        h.sortHand(expectedOutput);
        assertEquals(expectedOutput,g.getAip().getHand());
    }

    @org.junit.Test
    public void runASinglePair_changeThreeCardTest() {
        String gameLine = "H7 D2 C7 H5 DK S7 S3 S4 S6 C8 H2 H4 HK";
        storeAIPInitialHand(gameLine);

        List<Card> expectedOutput = createExpectedHand(new Card[]{
                g.getAip().getHand().get(0),
                g.getAip().getHand().get(2),
                g.getCardsToExchange().get(1),
                g.getCardsToExchange().get(2),
                g.getCardsToExchange().get(0)
        });

        g.playRound(gameLine);
        h.sortHand(expectedOutput);
        assertEquals(expectedOutput,g.getAip().getHand());
    }

    @org.junit.Test
    public void runTwoHighestCard_changeThreeCardTest() {
        String gameLine = "H3 H8 C10 D4 SQ S7 S3 S4 S6 C8 S8 CK D2";
        storeAIPInitialHand(gameLine);

        List<Card> expectedOutput = createExpectedHand(new Card[]{
                g.getAip().getHand().get(4),
                g.getAip().getHand().get(2),
                g.getCardsToExchange().get(1),
                g.getCardsToExchange().get(2),
                g.getCardsToExchange().get(0)
        });

        g.playRound(gameLine);
        h.sortHand(expectedOutput);
        assertEquals(expectedOutput,g.getAip().getHand());
    }

    @org.junit.Test
    public void royalFlushWinsTest() {
        String gameLine = "S10 SK SQ SJ SA H9 HJ HQ HK H10";
        storeAIPInitialHand(gameLine);
        Player expectedWinner = g.getAip();

        Player actualWinner = g.playRound(gameLine);

        assertEquals(expectedWinner,actualWinner);
    }

    @org.junit.Test
    public void straightFlushLoseRoyalFlushTest() {
        String gameLine = "S9 S10 SK SQ SJ HK HJ HQ H10 HA";
        storeAIPInitialHand(gameLine);
        Player expectedWinner = g.getOpponent();

        Player actualWinner = g.playRound(gameLine);

        assertEquals(expectedWinner,actualWinner);
    }

    @org.junit.Test
    public void straightFlushWinsFourOfAKindTest() {
        String gameLine = "S9 S10 SK SQ SJ HK H4 C4 D4 S4";
        storeAIPInitialHand(gameLine);
        Player expectedWinner = g.getAip();

        Player actualWinner = g.playRound(gameLine);

        assertEquals(expectedWinner,actualWinner);
    }

    @org.junit.Test
    public void FourOfAKindWinsFlushTest() {
        String gameLine = "HK H4 C4 D4 S4 D8 D3 D9 D10 D5";
        storeAIPInitialHand(gameLine);
        Player expectedWinner = g.getAip();

        Player actualWinner = g.playRound(gameLine);

        assertEquals(expectedWinner,actualWinner);
    }

    @org.junit.Test
    public void FourOfAKindLoseRoyalFlushTest() {
        String gameLine = "HK H4 C4 D4 S4 S10 SK SQ SJ SA";
        storeAIPInitialHand(gameLine);
        Player expectedWinner = g.getOpponent();

        Player actualWinner = g.playRound(gameLine);

        assertEquals(expectedWinner,actualWinner);
    }

    @org.junit.Test
    public void FourOfAKindLoseStraightFlushTest() {
        String gameLine = "H10 C10 D10 D3 C7 H9 C9 D9 S2 S5 D2 C6";
        storeAIPInitialHand(gameLine);
        Player expectedWinner = g.getOpponent();

        Player actualWinner = g.playRound(gameLine);

        assertEquals(expectedWinner,actualWinner);
    }


    //@org.junit.Rule
    //public final SystemErrRule systemErrRule = new SystemErrRule().enableLog();
}