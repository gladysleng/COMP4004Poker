import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.Comparator;
// just a class to sort rank and sort hand

public class HandChecker {
//    private ArrayList<Card> hand;
    private int rank;
    private Map<String, Integer> handRanking = new HashMap<String, Integer>();

    public HandChecker() {
//        hand = c;
        rank = 0;
    }

    public boolean validSize(ArrayList<Card> c){

        return c.size() == 5;
    }

    // sort the hand in ascending order according to rank
    public void sortHand(ArrayList<Card> c) {
        Collections.sort(c, new Comparator<Card>() {
            public int compare(Card c1, Card c2) {

                int result = c1.getRank() - c2.getRank();

                if (result != 0) {
                    return result;

                } else { // if their rank are equal, compare the suit
                    int result2 = c1.getSuit() - c2.getSuit();
                    return result2;
                }

            }
        });
    }

    //straight flush


   public boolean isStraightFlush(ArrayList<Card> c){
        if(validSize(c)){
            sortHand(c);

            //check if the rank are +1 of the previous one
            for(int i = 0; i < c.size() -1 ; i ++){
                if((c.get(i+1).getRank()) != (((c.get(i)).getRank())+ 1)){
                    return false;
                }
            }

            //check if they have the same suit
            for(int i = 0; i < c.size() -1 ; i++){
                if((c.get(i+1).getSuit()) != ((c.get(i).getSuit()))){
                    return false;
                }
            }
            return true;
        }
        return false;
   }
}
