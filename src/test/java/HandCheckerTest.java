import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class HandCheckerTest {

    HandChecker handChecker;

    @org.junit.Before
    public void setUp() throws Exception {
        handChecker = new HandChecker();
    }

    private List<Card> createHand(int[][] cards) {
        List<Card> hand = new ArrayList<Card>();
        for (int[] card : cards) {
            hand.add(new Card(card[0], card[1]));
        }
        return hand;
    }

    @org.junit.Test
    public void validSize() {
        List<Card> c = createHand(new int[][]{
                {1, 6},
                {1, 2},
                {1, 3},
                {1, 4},
                {1, 5}
        });
        assertEquals(5, c.size());
    }

    @org.junit.Test
    public void sortHand() {
        List<Card> c = createHand(new int[][]{
                {1, 10},
                {1, 2},
                {2, 12},
                {1, 12},
                {3, 3}
        });

        ArrayList<Card> expectedOutput = new ArrayList<Card>();
        expectedOutput.add(c.get(1));
        expectedOutput.add(c.get(4));
        expectedOutput.add(c.get(0));
        expectedOutput.add(c.get(3));
        expectedOutput.add(c.get(2));

        handChecker.sortHand(c);
        assertEquals(expectedOutput, c);
    }

    @org.junit.Test
    public void sortSuit() {
        List<Card> c = createHand(new int[][]{
                {4, 10},
                {3, 2},
                {2, 12},
                {1, 12}
        });

        ArrayList<Card> expectedOutput = new ArrayList<Card>();
        expectedOutput.add(c.get(3));
        expectedOutput.add(c.get(2));
        expectedOutput.add(c.get(1));
        expectedOutput.add(c.get(0));

        handChecker.sortSuit(c);
        assertEquals(expectedOutput, c);

    }

    @org.junit.Test
    public void isFullHouseAABBB() {
        List<Card> c = createHand(new int[][]{
                {4, 10},
                {1, 10},
                {2, 12},
                {1, 12},
                {3, 12}
        });
        assertEquals(true, handChecker.isFullHouse(c));
    }

    @org.junit.Test
    public void isFullHouseAAABB() {
        List<Card> c = createHand(new int[][]{
                {4, 10},
                {1, 10},
                {2, 10},
                {1, 12},
                {3, 12}
        });
        assertEquals(true, handChecker.isFullHouse(c));
    }

    @org.junit.Test
    public void isFlush() {
        List<Card> c = createHand(new int[][]{
                {4, 10},
                {4, 7},
                {4, 8},
                {4, 12},
                {4, 11}
        });
        assertEquals(true, handChecker.isFlush(c));
    }

    @org.junit.Test
    public void isStraightFlushDifferentSuits() {
        List<Card> c = createHand(new int[][]{
                {4, 10},
                {4, 14},
                {3, 13},
                {4, 12},
                {2, 11}
        });
        assertEquals(false, handChecker.isStraightFlush(c));
    }

    @org.junit.Test
    public void isStraightFlush() {
        List<Card> c = createHand(new int[][]{
                {2, 7},
                {2, 4},
                {2, 5},
                {2, 6},
                {2, 3}
        });
        assertEquals(true, handChecker.isStraightFlush(c));
    }

    @org.junit.Test
    public void isStraightFlushAceToFiveWithFlush() {
        List<Card> c = createHand(new int[][]{
                {2, 14},
                {2, 3},
                {2, 5},
                {2, 4},
                {2, 2}
        });
        assertEquals(true, handChecker.isStraightFlush(c));
    }

    @org.junit.Test
    public void isStraightFlush_RoyalFlush() {
        List<Card> c = createHand(new int[][]{
                {2, 14},
                {2, 11},
                {2, 10},
                {2, 13},
                {2, 12}
        });
        assertEquals(false, handChecker.isStraightFlush(c));
    }

    @org.junit.Test
    public void isFourOfAKind_37777() {
        List<Card> c = createHand(new int[][]{
                {2, 14},
                {1, 14},
                {3, 14},
                {4, 14},
                {2, 2}
        });
        assertEquals(true, handChecker.isFourOfAKind(c));
    }

    @org.junit.Test
    public void isFourOfAKind_77773() {
        List<Card> c = createHand(new int[][]{
                {2, 11},
                {1, 11},
                {3, 11},
                {4, 11},
                {2, 1}
        });
        assertEquals(true, handChecker.isFourOfAKind(c));
    }

    @org.junit.Test
    public void isStraightKingAce234() {
        List<Card> c = createHand(new int[][]{
                {2, 14},
                {1, 13},
                {3, 2},
                {4, 3},
                {2, 4}
        });
        assertEquals(false, handChecker.isStraight(c));
    }

    @org.junit.Test
    public void isStraightTenToAce() {
        List<Card> c = createHand(new int[][]{
                {2, 14},
                {1, 13},
                {3, 10},
                {4, 11},
                {2, 12}
        });
        assertEquals(true, handChecker.isStraight(c));
    }

    @org.junit.Test
    public void isStraightAceWithTwoButNotStraight() {
        List<Card> c = createHand(new int[][]{
                {2, 14},
                {1, 13},
                {3, 3},
                {4, 11},
                {2, 22}
        });
        assertEquals(false, handChecker.isStraight(c));
    }

    @org.junit.Test
    public void isThreeOfAKind_XYAAA() {
        List<Card> c = createHand(new int[][]{
                {2, 14},
                {1, 14},
                {3, 3},
                {4, 2},
                {4, 14}
        });
        assertEquals(true, handChecker.isThreeOfAKind(c));
    }

    @org.junit.Test
    public void isThreeOfAKind_AAA78() {
        List<Card> c = createHand(new int[][]{
                {2, 7},
                {1, 8},
                {3, 3},
                {4, 3},
                {2, 3}
        });
        assertEquals(true, handChecker.isThreeOfAKind(c));
    }

    @org.junit.Test
    public void isThreeOfAKind_XAAAY() {
        List<Card> c = createHand(new int[][]{
                {2, 14},
                {1, 7},
                {3, 7},
                {4, 7},
                {2, 3}
        });
        assertEquals(true, handChecker.isThreeOfAKind(c));
    }

    @org.junit.Test
    public void isThreeOfAKind_NotFourOfAKind() {
        List<Card> c = createHand(new int[][]{
                {2, 14},
                {1, 7},
                {3, 7},
                {4, 7},
                {2, 7}
        });
        assertEquals(false, handChecker.isThreeOfAKind(c));
    }

    @org.junit.Test
    public void isThreeOfAKind_NotFullHouse() {
        List<Card> c = createHand(new int[][]{
                {2, 14},
                {1, 14},
                {3, 7},
                {4, 7},
                {2, 7}
        });
        assertEquals(false, handChecker.isThreeOfAKind(c));
    }

    @org.junit.Test
    public void isTwoPair_NotFullHouse() {
        List<Card> c = createHand(new int[][]{
                {2, 3},
                {1, 4},
                {3, 3},
                {4, 4},
                {2, 4}
        });
        assertEquals(false, handChecker.isTwoPair(c));
    }

    @org.junit.Test
    public void isTwoPair_NotFourOfAKind() {
        List<Card> c = createHand(new int[][]{
                {2, 3},
                {1, 4},
                {3, 4},
                {4, 4},
                {2, 4}
        });
        assertEquals(false, handChecker.isTwoPair(c));
    }

    @org.junit.Test
    public void isTwoPair_NotThreeOfAKind() {
        List<Card> c = createHand(new int[][]{
                {2, 14},
                {1, 7},
                {3, 1},
                {4, 7},
                {2, 7}
        });
        assertEquals(false, handChecker.isTwoPair(c));
    }

    @org.junit.Test
    public void isTwoPair_44799() {
        List<Card> c = createHand(new int[][]{
                {2, 7},
                {1, 9},
                {3, 4},
                {4, 9},
                {2, 4}
        });
        assertEquals(true, handChecker.isTwoPair(c));
    }

    @org.junit.Test
    public void isTwoPair_22JJA() {
        List<Card> c = createHand(new int[][]{
                {2, 11},
                {1, 2},
                {3, 2},
                {4, 14},
                {2, 11}
        });
        assertEquals(true, handChecker.isTwoPair(c));
    }

    @org.junit.Test
    public void isTwoPair_46699() {
        List<Card> c = createHand(new int[][]{
                {2, 9},
                {1, 9},
                {3, 6},
                {4, 4},
                {2, 6}
        });
        assertEquals(true, handChecker.isTwoPair(c));
    }

    @org.junit.Test
    public void isOnePair_NotTwoPair() {
        List<Card> c = createHand(new int[][]{
                {2, 9},
                {1, 9},
                {3, 6},
                {4, 4},
                {2, 6}
        });
        assertEquals(false, handChecker.isOnePair(c));
    }

    @org.junit.Test
    public void isOnePair_NotThreeOfAKind() {
        List<Card> c = createHand(new int[][]{
                {2, 9},
                {1, 9},
                {3, 9},
                {4, 4},
                {2, 6}
        });
        assertEquals(false, handChecker.isOnePair(c));
    }

    @org.junit.Test
    public void isOnePair_NotFourOfAKind() {
        List<Card> c = createHand(new int[][]{
                {2, 9},
                {1, 9},
                {3, 9},
                {4, 9},
                {2, 6}
        });
        assertEquals(false, handChecker.isOnePair(c));
    }

    @org.junit.Test
    public void isOnePair() {
        List<Card> c = createHand(new int[][]{
                {2, 9},
                {1, 9},
                {3, 14},
                {4, 5},
                {2, 6}
        });
        assertEquals(true, handChecker.isOnePair(c));
    }

    @org.junit.Test
    public void isHighCard_notOnePairs() {
        List<Card> c = createHand(new int[][]{
                {2, 9},
                {1, 9},
                {3, 14},
                {4, 5},
                {2, 6}
        });
        assertEquals(false, handChecker.isHighCard(c));
    }

    @org.junit.Test
    public void isHighCard_notThreeOfAKind() {
        List<Card> c = createHand(new int[][]{
                {2, 9},
                {1, 9},
                {3, 9},
                {4, 5},
                {2, 6}
        });
        assertEquals(false, handChecker.isHighCard(c));
    }

    @org.junit.Test
    public void isHighCard_notFourOfAKind() {
        List<Card> c = createHand(new int[][]{
                {2, 9},
                {1, 9},
                {3, 9},
                {4, 9},
                {2, 6}
        });
        assertEquals(false, handChecker.isHighCard(c));
    }

    @org.junit.Test
    public void isHighCard_notFullHouse() {
        List<Card> c = createHand(new int[][]{
                {2, 9},
                {1, 9},
                {3, 9},
                {4, 6},
                {2, 6}
        });
        assertEquals(false, handChecker.isHighCard(c));
    }

    @org.junit.Test
    public void isHighCard_notStraight() {
        List<Card> c = createHand(new int[][]{
                {2, 10},
                {1, 14},
                {3, 11},
                {4, 13},
                {2, 12}
        });
        assertEquals(false, handChecker.isHighCard(c));
    }

    @org.junit.Test
    public void isHighCard_notStraightFlush() {
        List<Card> c = createHand(new int[][]{
                {2, 14},
                {2, 2},
                {2, 5},
                {2, 4},
                {2, 3}
        });
        assertEquals(false, handChecker.isHighCard(c));
    }

    @org.junit.Test
    public void isHighCard_notFlush() {
        List<Card> c = createHand(new int[][]{
                {2, 14},
                {2, 5},
                {2, 8},
                {2, 3},
                {2, 9}
        });
        assertEquals(false, handChecker.isHighCard(c));
    }

    @org.junit.Test
    public void isHighCard() {
        List<Card> c = createHand(new int[][]{
                {2, 14},
                {2, 5},
                {3, 7},
                {2, 3},
                {2, 9}
        });
        assertEquals(true, handChecker.isHighCard(c));
    }

    @org.junit.Test
    public void isRoyalFlush_noFlush() {
        List<Card> c = createHand(new int[][]{
                {2, 14},
                {2, 11},
                {3, 10},
                {2, 12},
                {2, 13}
        });
        assertEquals(false, handChecker.isRoyalFlush(c));
    }

    @org.junit.Test
    public void isRoyalFlush_notTenToAce_notStraight() {
        List<Card> c = createHand(new int[][]{
                {2, 14},
                {2, 7},
                {2, 10},
                {2, 12},
                {2, 13}
        });
        assertEquals(false, handChecker.isRoyalFlush(c));
    }


    @org.junit.Test
    public void isRoyalFlush_notTenToAce_Straight() {
        List<Card> c = createHand(new int[][]{
                {2, 8},
                {2, 5},
                {2, 6},
                {2, 7},
                {2, 4}
        });
        assertEquals(false, handChecker.isRoyalFlush(c));
    }

    @org.junit.Test
    public void isRoyalFlush() {
        List<Card> c = createHand(new int[][]{
                {2, 14},
                {2, 11},
                {2, 10},
                {2, 12},
                {2, 13}
        });
        assertEquals(true, handChecker.isRoyalFlush(c));
    }

    @org.junit.Test
    public void getPokerRank_RoyalFlush() {
        List<Card> c = createHand(new int[][]{
                {2, 14},
                {2, 11},
                {2, 10},
                {2, 12},
                {2, 13}
        });
        assertEquals(10, handChecker.getPokerRank(c));
    }

    @org.junit.Test
    public void getPokerRank_StraightFlush() {
        List<Card> c = createHand(new int[][]{
                {2, 9},
                {2, 11},
                {2, 10},
                {2, 12},
                {2, 13}
        });
        assertEquals(9, handChecker.getPokerRank(c));
    }

    @org.junit.Test
    public void getPokerRank_FourOfAKind() {
        List<Card> c = createHand(new int[][]{
                {2, 9},
                {3, 11},
                {4, 11},
                {1, 11},
                {2, 11}
        });
        assertEquals(8, handChecker.getPokerRank(c));
    }

    @org.junit.Test
    public void getPokerRank_FullHouse() {
        List<Card> c = createHand(new int[][]{
                {2, 9},
                {3, 9},
                {4, 11},
                {1, 11},
                {2, 11}
        });
        assertEquals(7, handChecker.getPokerRank(c));
    }

    @org.junit.Test
    public void getPokerRank_Flush() {
        List<Card> c = createHand(new int[][]{
                {2, 9},
                {2, 10},
                {2, 12},
                {2, 1},
                {2, 11}
        });
        assertEquals(6, handChecker.getPokerRank(c));
    }

    @org.junit.Test
    public void getPokerRank_Straight() {
        List<Card> c = createHand(new int[][]{
                {2, 9},
                {2, 10},
                {1, 12},
                {4, 13},
                {2, 11}
        });
        assertEquals(5, handChecker.getPokerRank(c));
    }

    @org.junit.Test
    public void getPokerRank_ThreeOfAKind() {
        List<Card> c = createHand(new int[][]{
                {2, 14},
                {2, 10},
                {1, 10},
                {4, 10},
                {2, 11}
        });
        assertEquals(4, handChecker.getPokerRank(c));
    }

    @org.junit.Test
    public void getPokerRank_TwoPairs() {
        List<Card> c = createHand(new int[][]{
                {2, 14},
                {2, 10},
                {1, 10},
                {4, 14},
                {2, 11}
        });
        assertEquals(3, handChecker.getPokerRank(c));
    }

    @org.junit.Test
    public void getPokerRank_OnePairs() {
        List<Card> c = createHand(new int[][]{
                {2, 14},
                {2, 10},
                {1, 10},
                {4, 9},
                {2, 11}
        });
        assertEquals(2, handChecker.getPokerRank(c));
    }

    @org.junit.Test
    public void getPokerRank_HighCard() {
        List<Card> c = createHand(new int[][]{
                {2, 14},
                {2, 7},
                {1, 10},
                {4, 9},
                {2, 11}
        });
        assertEquals(1, handChecker.getPokerRank(c));
    }

    @org.junit.Test
    public void oneCardFromRoyalFlush_onePair() {
        List<Card> c = createHand(new int[][]{
                {2, 10},
                {1, 11},
                {1, 10},
                {1, 12},
                {1, 14}
        });
        assertEquals(true, handChecker.oneCardFromRoyalFlush(c));

    }

    @org.junit.Test
    public void oneCardFromRoyalFlush_onePairbutNotFlush() {
        List<Card> c = createHand(new int[][]{
                {1, 9},
                {1, 11},
                {2, 11},
                {1, 12},
                {1, 14}
        });
        assertEquals(false, handChecker.oneCardFromRoyalFlush(c));
    }

    @org.junit.Test
    public void oneCardFromRoyalFlush_onePairbutNotFlush_9To14() {
        List<Card> c = createHand(new int[][]{
                {1, 9},
                {1, 11},
                {2, 11},
                {1, 12},
                {1, 14}
        });
        assertEquals(false, handChecker.oneCardFromRoyalFlush(c));
    }

    @org.junit.Test
    public void oneCardFromRoyalFlush_onePair2OddSuits_10To14() {
        List<Card> c = createHand(new int[][]{
                {1, 10},
                {1, 11},
                {2, 12},
                {1, 12},
                {2, 14}
        });
        assertEquals(false, handChecker.oneCardFromRoyalFlush(c));
    }

    @org.junit.Test
    public void oneCardFromRoyalFlush_firstIndexIsNotRangeOf11to14() {
        List<Card> c = createHand(new int[][]{
                {2, 9},
                {1, 11},
                {1, 12},
                {1, 13},
                {1, 14}
        });
        assertEquals(true, handChecker.oneCardFromRoyalFlush(c));
    }

    @org.junit.Test
    public void oneCardFromRoyalFlush_firstIndexWrongRank_FourthWrongSuit() {
        List<Card> c = createHand(new int[][]{
                {1, 7},
                {1, 10},
                {1, 11},
                {2, 12},
                {1, 14}
        });
        assertEquals(false, handChecker.oneCardFromRoyalFlush(c));
    }

    @org.junit.Test
    public void oneCardFromRoyalFlush_TwoWrongRankOneWrongSuit() {
        List<Card> c = createHand(new int[][]{
                {2, 7},
                {1, 9},
                {1, 11},
                {2, 12},
                {1, 14}
        });
        assertEquals(false, handChecker.oneCardFromRoyalFlush(c));
    }

    @org.junit.Test
    public void oneCardFromFlush_CHHHH() {
        List<Card> c = createHand(new int[][]{
                {2, 10},
                {1, 11},
                {1, 9},
                {1, 12},
                {1, 14}
        });
        assertEquals(true, handChecker.oneCardFromFlush(c));
    }

    @org.junit.Test
    public void oneCardFromFlush_HHHHS() {
        List<Card> c = createHand(new int[][]{
                {3, 10},
                {3, 11},
                {3, 9},
                {3, 12},
                {4, 14}
        });
        assertEquals(true, handChecker.oneCardFromFlush(c));
    }

    @org.junit.Test
    public void oneCardFromFullHouse_TwoPairs() {
        List<Card> c = createHand(new int[][]{
                {3, 10},
                {3, 11},
                {3, 2},
                {2, 10},
                {4, 11}
        });
        assertEquals(true, handChecker.oneCardFromFullHouse(c));

    }

    @org.junit.Test
    public void oneCardFromFullHouse_ThreeOfAKind() {
        List<Card> c = createHand(new int[][]{
                {3, 10},
                {3, 11},
                {3, 2},
                {2, 10},
                {4, 10}
        });
        assertEquals(true, handChecker.oneCardFromFullHouse(c));

    }

    @org.junit.Test
    public void oneCardFromStraight_OnePairWithAce() {
        List<Card> c = createHand(new int[][]{
                {3, 2},
                {3, 3},
                {3, 14},
                {2, 4},
                {4, 4}
        });
        assertEquals(true, handChecker.oneCardFromStraight(c));
    }

    @org.junit.Test
    public void oneCardFromStraight_withAce() {
        List<Card> c = createHand(new int[][]{
                {3, 2},
                {3, 3},
                {3, 14},
                {2, 6},
                {4, 5}
        });
        assertEquals(true, handChecker.oneCardFromStraight(c));
    }

    @org.junit.Test
    public void oneCardFromStraight_OnePair_RangeOfFour() {
        List<Card> c = createHand(new int[][]{
                {3, 6},
                {3, 3},
                {3, 5},
                {2, 5},
                {4, 7}
        });
        assertEquals(true, handChecker.oneCardFromStraight(c));
    }

    @org.junit.Test
    public void oneCardFromStraight_OnePair_RangeOfThree() {
        List<Card> c = createHand(new int[][]{
                {3, 2},
                {3, 3},
                {3, 4},
                {2, 2},
                {4, 5}
        });
        assertEquals(true, handChecker.oneCardFromStraight(c));
    }

    @org.junit.Test
    public void oneCardFromStraight_TwoPairs() {
        List<Card> c = createHand(new int[][]{
                {3, 2},
                {3, 3},
                {3, 10},
                {2, 3},
                {4, 2}
        });
        assertEquals(false, handChecker.oneCardFromStraight(c));
    }

    @org.junit.Test
    public void oneCardFromStraightFlush_OneFromStraightAndOneFromFlush() {
        List<Card> c = createHand(new int[][]{
                {4, 5},
                {3, 7},
                {4, 8},
                {4, 9},
                {4, 11}
        });
        assertEquals(false, handChecker.oneCardFromStraightFlush(c));
    }

    @org.junit.Test
    public void oneCardFromStraightFlush_OneFromStraightAndAceWithDiffSuit() {
        List<Card> c = createHand(new int[][]{
                {4, 14},
                {3, 3},
                {3, 2},
                {3, 4},
                {3, 6}
        });
        assertEquals(true, handChecker.oneCardFromStraightFlush(c));
    }

    @org.junit.Test
    public void oneCardFromStraightFlush() {
        List<Card> c = createHand(new int[][]{
                {4, 11},
                {3, 3},
                {3, 2},
                {3, 4},
                {3, 6}
        });
        assertEquals(true, handChecker.oneCardFromStraightFlush(c));
    }

    @org.junit.Test
    public void oneCardFromStraightFlush_AcePair_SuitWithDDDDH() {
        List<Card> c = createHand(new int[][]{
                {4, 14},
                {3, 3},
                {3, 2},
                {3, 4},
                {3, 14}
        });
        assertEquals(true, handChecker.oneCardFromStraightFlush(c));
    }

    @org.junit.Test
    public void oneCardFromStraightFlush_AcePair_SuitWithSSSHS() {
        List<Card> c = createHand(new int[][]{
                {4, 14},
                {4, 3},
                {4, 2},
                {4, 4},
                {3, 14}
        });
        assertEquals(true, handChecker.oneCardFromStraightFlush(c));
    }

    @org.junit.Test
    public void oneCardFromStraightFlush_OnePairs_RangeOfFour() {
        List<Card> c = createHand(new int[][]{
                {4, 7},
                {4, 3},
                {4, 4},
                {4, 6},
                {3, 7}
        });
        assertEquals(true, handChecker.oneCardFromStraightFlush(c));
    }

    @org.junit.Test
    public void oneCardFromStraightFlush_OneFlushAndOneRankWrong() {
        List<Card> c = createHand(new int[][]{
                {4, 2},
                {4, 3},
                {4, 4},
                {3, 5},
                {2, 7}
        });
        assertEquals(false, handChecker.oneCardFromStraightFlush(c));
    }
}