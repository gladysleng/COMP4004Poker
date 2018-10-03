import java.util.ArrayList;

public class Strategy {

    private HandChecker handChecker = new HandChecker();

    public void changeOneCardForRoyalFlush(ArrayList<Card>c,Card drawnCard){
        handChecker.sortSuit(c);

        // pairs lower suit
        if(c.get(0).getSuit() != c.get(2).getSuit()){
            c.remove(0);
            c.add(drawnCard);
        }
        //pairs higher suit
        else if(c.get(c.size()-1).getSuit() != c.get(2).getSuit()){
            c.remove(c.size()-1);
            c.add(drawnCard);
        }
        else{
            //flush but lesser than 10
            handChecker.sortHand(c);
            for(int i = 0 ; i < c.size() ; i++){
                if(!(c.get(i).getRank() >= 10 && c.get(i).getRank() <= 14)){
                    c.remove(i);
                }
            }
            if(c.size() != 5){
                c.add(drawnCard);
            }
        }
    }


}
