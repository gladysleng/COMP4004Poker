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
    private List<Card>cardsToExchange;

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


    private List<Card> createHandsFromStringArray(String [] cardStrings) {
        List<Card> cardsInput = new ArrayList<Card>();
        for (String cardString : cardStrings) {
            cardsInput.add(new Card(cardString));
        }
        return cardsInput;
    }

    public void setUpForInitialHands(String gameLine){
        String [] lineCardStrings = gameLine.split(" ");
        String [] aipCardsStrings = Arrays.copyOfRange(lineCardStrings, 0, 5);
        String [] opponentCardsStrings = Arrays.copyOfRange(lineCardStrings, 5, 10);
        String [] cardToExchangeStrings = Arrays.copyOfRange(lineCardStrings, 10,lineCardStrings.length);

        System.out.println("INITIAL HANDS: ");
        opponent.setHand(createHandsFromStringArray(opponentCardsStrings));
        opponent.printHand();
        aip.setHand(createHandsFromStringArray(aipCardsStrings));
        aip.printHand();
        cardsToExchange = createHandsFromStringArray(cardToExchangeStrings);
    }


    public void detectRankOfHand(Player p){
        p.setHandRank(handChecker.getPokerRank(p.getHand()));
    }
    public void run(){
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


        }
    }

    public void printDiscardedCard(List<Card>c){
        for(int i = 0 ; i < c.size() ; i++){
            c.get(i).toString();
        }
    }

    public static void main(String[] args) {
        Game poker = new Game();
        poker.run();
    }
}
