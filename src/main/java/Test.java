import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Player p1 = new Player("Gladys");
        Player p2 = new Player("Champ");
        HandChecker h1 = new HandChecker();

        Deck d = new Deck();
        System.out.println("Deck created: ");
        d.printDeck();
        System.out.println();
        System.out.println("=============================");
        System.out.println("Size of deck before dealing to p1 : " + d.getSize());
        for(int i = 0 ; i < 5; i ++){
            p1.drawCard(d);
        }
        System.out.println("=============================");
        p1.printHand();
        System.out.println();
        System.out.println("Size of deck after dealing to p1 : " + d.getSize());

        System.out.println("=============================");
        h1.sortHand(p1.getHand());
        p1.printHand();
        System.out.println();


        ArrayList<Card> c = new ArrayList<Card>();
        Card c1 = new Card(1,6);
        Card c2 = new Card(1,2);
        Card c3 = new Card(1,3);
        Card c4 = new Card(1,4);
        Card c5 = new Card(1,5);
        c.add(c1);
        c.add(c2);
        c.add(c3);
        c.add(c4);
        c.add(c5);

        System.out.println("is size valid : " + h1.validSize(c));
        System.out.println("is it straight flush(true): " + h1.isStraightFlush(c));

        ArrayList<Card> cd = new ArrayList<Card>();
        Card cd1 = new Card(1,2);
        Card cd2 = new Card(1,14);
        Card cd3 = new Card(1,4);
        Card cd4 = new Card(1,3);
        Card cd5 = new Card(1,5);
        cd.add(cd1);
        cd.add(cd2);
        cd.add(cd3);
        cd.add(cd4);
        cd.add(cd5);

        System.out.println("is it straight flush(True): "+ h1.isStraightFlush(cd));
        System.out.println("testing ace in straight flush: " +cd.toString());
        ArrayList<Card> card = new ArrayList<Card>();
        Card c41 = new Card(1,14);
        Card c42 = new Card(2,14);
        Card c43 = new Card(2,5);
        Card c44 = new Card(4,14);
        Card c45 = new Card(3,14);
        card.add(c41);
        card.add(c42);
        card.add(c43);
        card.add(c44);
        card.add(c45);

        System.out.println();
        System.out.println("testing 4 of a kind: "+ card.toString());
        System.out.println("is it four-of-a-kind(true) : " + h1.isFourOfAKind(card));

        ArrayList<Card> card2 = new ArrayList<Card>();
        Card c46 = new Card(1,14);
        Card c47 = new Card(2,14);
        Card c48 = new Card(2,14);
        Card c49 = new Card(4,12);
        Card c50 = new Card(3,12);
        card2.add(c46);
        card2.add(c47);
        card2.add(c48);
        card2.add(c49);
        card2.add(c50);

        System.out.println();
        System.out.println("testing Full house: "+ card2.toString());
        System.out.println("is it full house(true) : " + h1.isFullHouse(card2));
        h1.sortSuit(card2);
        System.out.println("Test sorting suit: " +  card2.toString());


        ArrayList<Card> d1 = new ArrayList<Card>();
        Card w1 = new Card(1,14);
        Card w2 = new Card(1,8);
        Card w3 = new Card(1,7);
        Card w4 = new Card(1,3);
        Card w5 = new Card(2,12);
        d1.add(w1);
        d1.add(w2);
        d1.add(w3);
        d1.add(w4);
        d1.add(w5);

        System.out.println();
        System.out.println("testing Flush: "+ d1.toString());
        System.out.println("is it flush(false) : " + h1.isFlush(d1));

        ArrayList<Card> d2 = new ArrayList<Card>();
        Card wy1 = new Card(1,4);
        Card wy2 = new Card(2,11);
        Card wy3 = new Card(3,4);
        Card wy4 = new Card(4,12);
        Card wy5 = new Card(2,4);
        d2.add(wy1);
        d2.add(wy2);
        d2.add(wy3);
        d2.add(wy4);
        d2.add(wy5);

        System.out.println();
        System.out.println("testing threeOfAKind: "+ d2.toString());
        System.out.println("is it threeOfAKind(true) : " + h1.isThreeOfAKind(d2));
        System.out.println("testing threeOfAKind: "+ d2.toString());

        ArrayList<Card> da = new ArrayList<Card>();
        Card q1 = new Card(1,4);
        Card q2 = new Card(2,4);
        Card q3 = new Card(3,7);
        Card q4 = new Card(4,3);
        Card q5 = new Card(2,5);
        da.add(q1);
        da.add(q2);
        da.add(q3);
        da.add(q4);
        da.add(q5);

        System.out.println();
        System.out.println("testing isTwoPair: "+ da.toString());
        System.out.println("is it isTwoPair(true) : " + h1.isTwoPair(da));
        System.out.println("testing isTwoPair: "+ da.toString());

        ArrayList<Card> s = new ArrayList<Card>();
        Card z = new Card(1,4);
        Card x = new Card(4,14);
        Card f = new Card(3,7);
        Card g = new Card(3,4);
        Card b = new Card(2,5);
        s.add(z);
        s.add(x);
        s.add(f);
        s.add(g);
        s.add(b);

        System.out.println();
        System.out.println("testing isOnePair: "+ s.toString());
        System.out.println("is it isOnePair(true) : " + h1.isOnePair(s));
        System.out.println("testing isOnePair: "+ s.toString());

        ArrayList<Card> p = new ArrayList<Card>();
        Card z1 = new Card(1,4);
        Card x1 = new Card(4,14);
        Card f1 = new Card(3,7);
        Card g1 = new Card(3,4);
        Card b1 = new Card(2,5);
        p.add(z1);
        p.add(x1);
        p.add(f1);
        p.add(g1);
        p.add(b1);

        System.out.println();
        System.out.println("testing isHighCard: "+ p.toString());
        System.out.println("is it isHighCard(false) : " + h1.isHighCard(p));
        System.out.println("testing isHighCard: "+ p.toString());

        ArrayList<Card> ry = new ArrayList<Card>();
        HandChecker r1 = new HandChecker();
        Card ry1 = new Card(3,14);
        Card ry2 = new Card(3,12);
        Card ry3 = new Card(3,10);
        Card ry4 = new Card(3,13);
        Card ry5 = new Card(3,11);
        ry.add(ry1);
        ry.add(ry2);
        ry.add(ry3);
        ry.add(ry4);
        ry.add(ry5);

        System.out.println();
        System.out.println("testing isRoyalFlush: "+ ry.toString());
        System.out.println("is it isRoyalFlush(true) : " + r1.isRoyalFlush(ry));
        System.out.println("testing isRoyalFlush: "+ ry.toString());


        if(r1.getPokerRank(ry) > h1.getPokerRank(c)){
            System.out.println("ry : " + r1.getPokerRank(ry));
            System.out.println("c : " + r1.getPokerRank(c));
        }

        ArrayList<Card> card1Ry = new ArrayList<Card>();
        Card cl1 = new Card(4,6);
        Card cl2 = new Card(4,14);
        Card cl3 = new Card(4,10);
        Card cl4 = new Card(4,13);
        Card cl5 = new Card(4,11);
        card1Ry.add(cl1);
        card1Ry.add(cl2);
        card1Ry.add(cl3);
        card1Ry.add(cl4);
        card1Ry.add(cl5);

        System.out.println();
        System.out.println("testing oneCardAway: "+ card1Ry.toString());
        System.out.println("is it oneCardAwayFromRoyalFlush(true) : " + r1.oneCardFromRoyalFlush(card1Ry));
        System.out.println("testing oneCardAway: "+ card1Ry.toString());

        ArrayList<Card> card2Ry = new ArrayList<Card>();
        Card ch1 = new Card(4,14);
        Card ch2 = new Card(4,12);
        Card ch3 = new Card(4,10);
        Card ch4 = new Card(4,13);
        Card ch5 = new Card(4,11);
        card2Ry.add(ch1);
        card2Ry.add(ch2);
        card2Ry.add(ch3);
        card2Ry.add(ch4);
        card2Ry.add(ch5);

        System.out.println();
        System.out.println("testing oneCardAway: "+ card2Ry.toString());
        System.out.println("is it oneCardAwayFromFlush(true) : " + r1.oneCardFromFlush(card2Ry));
        System.out.println("testing oneCardAway: "+ card2Ry.toString());

        ArrayList<Card> card3Ry = new ArrayList<Card>();
        Card ch10 = new Card(2,14);
        Card ch20 = new Card(3,14);
        Card ch30 = new Card(1,10);
        Card ch40 = new Card(2,9);
        Card ch50 = new Card(3,10);
        card3Ry.add(ch10);
        card3Ry.add(ch20);
        card3Ry.add(ch30);
        card3Ry.add(ch40);
        card3Ry.add(ch50);

        System.out.println();
        System.out.println("testing oneCardAway: "+ card3Ry.toString());
        System.out.println("is it oneCardAwayFromFullHouse(true) : " + r1.oneCardFromFullHouse(card3Ry));
        System.out.println("testing oneCardAway: "+ card3Ry.toString());

        ArrayList<Card> card4Ry = new ArrayList<Card>();
        Card ch101 = new Card(2,8);
        Card ch202 = new Card(3,13);
        Card ch303 = new Card(1,9);
        Card ch404 = new Card(2,10);
        Card ch505 = new Card(3,11);
        card4Ry.add(ch101);
        card4Ry.add(ch202);
        card4Ry.add(ch303);
        card4Ry.add(ch404);
        card4Ry.add(ch505);

        System.out.println();
        System.out.println("testing oneCardAway: "+ card4Ry.toString());
        System.out.println("is it oneCardAwayFromStraight(true) : " + r1.oneCardFromStraight(card4Ry));
        System.out.println("testing oneCardAway: "+ card4Ry.toString());

        ArrayList<Card> card5Ry = new ArrayList<Card>();
        Card ch1011 = new Card(4,3);
        Card ch2022 = new Card(4,2);
        Card ch3033 = new Card(4,4);
        Card ch4044 = new Card(4,6);
        Card ch5055 = new Card(1,11);
        card5Ry.add(ch1011);
        card5Ry.add(ch2022);
        card5Ry.add(ch3033);
        card5Ry.add(ch4044);
        card5Ry.add(ch5055);

        System.out.println();
        System.out.println("testing oneCardAway: "+ card5Ry.toString());
        System.out.println("is it oneCardAwayFromStraightFlush(true) : " + r1.oneCardFromStraightFlush(card5Ry));
        System.out.println("testing oneCardAway: "+ card5Ry.toString());

        Card c31 = new Card("S10");
        System.out.println(c31.getRank());
        System.out.println(c31.getSuit());


    }

}
