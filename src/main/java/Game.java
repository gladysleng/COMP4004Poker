import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


///// REMEMBER  AFTER READING THE CARD TO EXCHANGE OR AFTER EXCHANGING
//// REMOVE IT FROM THE DECK


public class Game {

    private Player aip, opponent;
    private Strategy strategy;
    private HandChecker handChecker;
    private EqualRankComparator equalRankcomparator;
    private ReadFile reader;
    private List<Card> cardsToExchange;

    //Temporarily for input files
    String handString = "DA C3 C5 C2 C6";
    String handString2 = "DK C10 H5 DJ H3";

    public Game() {

        aip = new Player("AIP");
        opponent = new Player("Opponent");
        strategy = new Strategy();
        handChecker = new HandChecker();
        equalRankcomparator = new EqualRankComparator();
        reader = new ReadFile();
    }


    private List<Card> createHandsFromStringArray(String[] cardStrings) {
        List<Card> cardsInput = new ArrayList<Card>();
        for (String cardString : cardStrings) {
            cardsInput.add(new Card(cardString));
        }
        return cardsInput;
    }

    public void setUpForInitialHands(String gameLine) {
        String[] lineCardStrings = gameLine.split(" ");
        String[] aipCardsStrings = Arrays.copyOfRange(lineCardStrings, 0, 5);
        String[] opponentCardsStrings = Arrays.copyOfRange(lineCardStrings, 5, 10);
        String[] cardToExchangeStrings = Arrays.copyOfRange(lineCardStrings, 10, lineCardStrings.length);

        System.out.println("INITIAL HANDS:  ");

        opponent.setHand(createHandsFromStringArray(opponentCardsStrings));
        opponent.printHand();
        aip.setHand(createHandsFromStringArray(aipCardsStrings));
        aip.printHand();
        cardsToExchange = createHandsFromStringArray(cardToExchangeStrings);
    }


    public void detectRankOfHand(Player p) {
        p.setHandRank(handChecker.getPokerRank(p.getHand()));
    }

    public void run() {
        int gameCounter = 0;
        while (true) {

            String gameLine = reader.readNext();
            if (gameLine == null) {
                break;
            }
            System.out.println();
            System.out.println("---------------------------------");
            System.out.println("Game " + ++gameCounter + "!!");
            System.out.println("---------------------------------");

            setUpForInitialHands(gameLine);

            System.out.print("Rank of AIP : ");
            detectRankOfHand(aip);
            System.out.println();
            if (aip.getHandRank() < 5) {
                System.out.println("AIP will exchange card to improve its rank! ");
                strategy.applyStrategy(aip.getHand(), cardsToExchange);
                System.out.println();
                System.out.println("AFTER CARD EXCHANGE : ");

                aip.printHand();
            }
            else{
                System.out.println("AIP did not exchange any of its card");
                aip.getHandRank();
                aip.printHand();
            }
            determineWinner();

        }
    }

    public void determineWinner() {
        System.out.println();
        System.out.print("AIP's Rank : ");
        detectRankOfHand(aip);
        System.out.print("Opponent's Rank : ");
        detectRankOfHand(opponent);
        System.out.println();

        if (aip.getHandRank() == opponent.getHandRank()) {
            int winner = compareTwoEqualRank(aip.getHand(),opponent.getHand());
            if(winner == 1){
                System.out.println("AIP Wins!");
            }
            else{
                System.out.println("Opponent Wins!");
            }
        } else if (aip.getHandRank() > opponent.getHandRank()) {
            System.out.println("AIP Wins!");
        } else {
            System.out.println("Opponent Wins!");
        }
    }

    public int compareTwoEqualRank(List<Card> c1, List<Card> c2) {
        if (aip.getHandRank() == 10) {
            if (c1.equals(equalRankcomparator.compareRoyalFlush(c1, c2))) {
                return 1;
            }
        } else if (aip.getHandRank() == 9) {
            if (c1.equals(equalRankcomparator.compareStraightFlush(c1, c2))) {
                return 1;
            }
        } else if (aip.getHandRank() == 8) {
            if (c1.equals(equalRankcomparator.compareFourOfAKind(c1, c2))) {
                return 1;
            }
        } else if (aip.getHandRank() == 7) {
            if (c1.equals(equalRankcomparator.compareFullHouse(c1, c2))) {
                return 1;
            }
        } else if (aip.getHandRank() == 6) {
            if (c1.equals(equalRankcomparator.compareFlush(c1, c2))) {
                return 1;
            }
        } else if (aip.getHandRank() == 5) {
            if (c1.equals(equalRankcomparator.compareStraight(c1, c2))) {
                return 1;
            }
        } else if (aip.getHandRank() == 4) {
            if (c1.equals(equalRankcomparator.compareThreeOfAKind(c1, c2))) {
                return 1;
            }
        } else if (aip.getHandRank() == 3) {
            if (c1.equals(equalRankcomparator.compareTwoPairs(c1, c2))) {
                return 1;
            }
        } else if (aip.getHandRank() == 2) {
            if (c1.equals(equalRankcomparator.compareOnePair(c1, c2))) {
                return 1;
            }
        } else if (aip.getHandRank() == 1) {
            if (c1.equals(equalRankcomparator.compareHighCard(c1, c2))) {
                return 1;
            }
        }

        return 0;

    }

    public void printDiscardedCard(List<Card> c) {
        for (int i = 0; i < c.size(); i++) {
            c.get(i).toString();
        }
    }

    public static void main(String[] args) {
        Game poker = new Game();
        poker.run();
    }
}
