import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Strategy {

    private HandChecker handChecker = new HandChecker();

    public void changeOneCardForRoyalFlush(List<Card> c, Card drawnCard) {
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
            c.add(drawnCard);

        }
        handChecker.sortHand(c);
    }

    public void changeOneCardForStraightFlush(List<Card> c, Card drawnCard) {
        handChecker.sortSuit(c);
        if (c.get(0).getSuit() != c.get(2).getSuit()) {
            c.remove(0);
        } else {
            c.remove(c.size() - 1);
        }
        if (c.size() != 5) {
            c.add(drawnCard);
        }
        handChecker.sortHand(c);

    }

    public void changeOneCardForFullHouse(List<Card> c, List<Card> cardsToChange) {
        if (handChecker.isTwoPair(c)) {

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
        } else {
            changeTwoCardsForThreeOfAKind(c, cardsToChange);
        }
        handChecker.sortHand(c);

    }

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
            c.remove(4);
        }
        //44456
        else if ((c.get(2).getRank() == c.get(4).getRank())) {
            c.remove(0);
            c.remove(1);
        }
        c.addAll(cardsToChange);
        handChecker.sortHand(c);
    }
}
