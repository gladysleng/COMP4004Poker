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
        Card c1 = new Card(1,1);
        Card c2 = new Card(1,2);
        Card c3 = new Card(1,3);
        Card c4 = new Card(1,4);
        Card c5 = new Card(1,5);
        c.add(c1);
        c.add(c2);
        c.add(c3);
        c.add(c4);
        c.add(c5);

        System.out.println(h1.validSize(c));
        System.out.println(h1.isStraightFlush(c));

        ArrayList<Card> cd = new ArrayList<Card>();
        Card cd1 = new Card(2,1);
        Card cd2 = new Card(1,2);
        Card cd3 = new Card(1,3);
        Card cd4 = new Card(1,4);
        Card cd5 = new Card(1,5);
        cd.add(cd1);
        cd.add(cd2);
        cd.add(cd3);
        cd.add(cd4);
        cd.add(cd5);

        System.out.println(h1.isStraightFlush(cd));

    }

}
