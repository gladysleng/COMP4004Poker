import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Strategy {

    private HandChecker handChecker = new HandChecker();

    public void changeOneCardForRoyalFlush(List<Card> c, List<Card> cardToExchange) {
        handChecker.sortSuit(c);

        // pairs lower suit
        if (c.get(0).getSuit() != c.get(2).getSuit()) {
            c.remove(0);
        }
        //pairs higher suit
        else if (c.get(c.size() - 1).getSuit() != c.get(2).getSuit()) {
            c.remove(c.size() - 1);
        } else {
            //flush but lesser than 10
            handChecker.sortHand(c);
            for (int i = 0; i < c.size(); i++) {
                if (!(c.get(i).getRank() >= 10 && c.get(i).getRank() <= 14)) {
                    c.remove(i);
                }
            }
        }
        if (c.size() != 5) {
            c.addAll(cardToExchange);
        }
        handChecker.sortHand(c);
    }

    public void changeOneCardForStraightFlush(List<Card> c, List<Card> cardToExchange) {
        handChecker.sortSuit(c);
        if (c.get(0).getSuit() != c.get(2).getSuit()) {
            c.remove(0);
        } else {
            c.remove(c.size() - 1);
        }
        if (c.size() != 5) {
            c.addAll(cardToExchange);
        }
        handChecker.sortHand(c);

    }

    //test for this is covered for change one card for fullHouse in the twoPairs if statement
    public void changeOneCardForTwoPairs(List<Card> c, List<Card> cardsToChange) {
        handChecker.sortHand(c);

        int rankWithoutPairs = 0;
        HashMap<Integer, Integer> rankBucket = new HashMap<Integer, Integer>();
        Integer count;

        for (Card currentCard : c) {
            count = rankBucket.get(currentCard.getRank());
            if (count == null) {
                count = 0;
            }
            rankBucket.put(currentCard.getRank(), ++count);
        }

        for (Map.Entry<Integer, Integer> entry : rankBucket.entrySet()) {
            if (entry.getValue() == 1) {
                rankWithoutPairs = entry.getKey();
            }
        }

        for (int i = 0; i < c.size(); i++) {
            if (c.get(i).getRank() == rankWithoutPairs) {
                c.remove(i);
            }
        }
        c.addAll(cardsToChange);
        handChecker.sortHand(c);
    }

    public void changeOneCardForFullHouse(List<Card> c, List<Card> cardsToChange) {
        if (handChecker.isTwoPair(c)) {
            changeOneCardForTwoPairs(c, cardsToChange);

        } else {
            //44456
            if ((c.get(0).getRank() == c.get(2).getRank())) {
                c.remove(3);
            }
            //34445
            else if ((c.get(1).getRank() == c.get(3).getRank())) {
                c.remove(0);

            }
            //56444
            else if ((c.get(2).getRank() == c.get(4).getRank())) {
                c.remove(0);
            }
            c.addAll(cardsToChange);
        }
        handChecker.sortHand(c);

    }

    //never gonna run because of the strategy from the requirement
    //cards with three same rank will enter fullhouse and change one card instead of this function
    public void changeTwoCardsForThreeOfAKind(List<Card> c, List<Card> cardsToChange) {

        handChecker.sortHand(c);

        //22234
        if ((c.get(0).getRank() == c.get(2).getRank())) {
            c.remove(3);
            c.remove(4);
        }
        //34445
        else if ((c.get(1).getRank() == c.get(3).getRank())) {
            c.remove(0);
            c.remove(3);
        }
        //56444
        else if ((c.get(2).getRank() == c.get(4).getRank())) {
            c.remove(0);
            c.remove(0);
        }
        c.addAll(cardsToChange);
        handChecker.sortHand(c);
    }

    public void changeOneCardForFlush(List<Card> c, List<Card> cardsToChange) {
        handChecker.sortSuit(c);

        if (c.get(0).getSuit() != c.get(2).getSuit()) {
            c.remove(0);
        } else {
            c.remove(c.size() - 1);
        }
        c.addAll(cardsToChange);
        handChecker.sortHand(c);
    }

    public void changeOneCardForStraight(List<Card> c, List<Card> cardsToChange) {
        handChecker.sortHand(c);

        if (c.get(c.size() - 1).getRank() == 14) {
            handChecker.changeRankChangeForAce(c);
        }

        if (handChecker.isOnePair(c)) {
            for (int i = 0; i < c.size() - 1; i++) {
                if (c.get(i).getRank() == c.get(i + 1).getRank()) {
                    c.remove(i);
                    break;
                }
            }
        } else {

            if (handChecker.rangeOfFourOrThree((c.get(c.size() - 1).getRank()), (c.get(1).getRank()))) {
                c.remove(0);

            } else {
                c.remove(c.size() - 1);
            }
        }
        c.addAll(cardsToChange);
        handChecker.sortHand(c);
    }

    public void changeTwoCardsForThreeSameSuit(List<Card> c, List<Card> cardsToChange) {
        handChecker.sortSuit(c);

        //DDDHH
        if ((c.get(0).getSuit() == c.get(2).getSuit())) {
            c.remove(3);
            c.remove(4);
        }
        //DCCCS
        else if ((c.get(1).getSuit() == c.get(3).getSuit())) {
            c.remove(0);
            c.remove(3);
        }
        //DCSSS
        else if ((c.get(2).getSuit() == c.get(4).getSuit())) {
            c.remove(0);
            c.remove(0);
        }
        c.addAll(cardsToChange);

        handChecker.sortHand(c);
    }

    public void changeThreeCardsForOnePair(List<Card> c, List<Card> cardsToChange) {
        int rankOfPairs = 0;
        HashMap<Integer, Integer> rankBucket = new HashMap<Integer, Integer>();
        Integer count;

        for (Card currentCard : c) {
            count = rankBucket.get(currentCard.getRank());
            if (count == null) {
                count = 0;
            }
            rankBucket.put(currentCard.getRank(), ++count);
        }

        for (Map.Entry<Integer, Integer> entry : rankBucket.entrySet()) {
            if (entry.getValue() == 2) {
                rankOfPairs = entry.getKey();
            }
        }
        int index = -1;

        handChecker.sortHand(c);
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i).getRank() == rankOfPairs) {
                index = i;
            }
        }
        c.remove(index);
        c.remove(index);
        c.addAll(cardsToChange);
        handChecker.sortHand(c);

    }

    public void changeThreeCardsForHighCards(List<Card> c, List<Card> cardsToChange) {
        handChecker.sortHand(c);
        c.set(0, cardsToChange.get(0));
        c.set(1, cardsToChange.get(1));
        c.set(2, cardsToChange.get(2));

        handChecker.sortHand(c);

    }
}
