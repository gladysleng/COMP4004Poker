public class Card {

    private int suit;
    private int rank;

    public Card(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int r){  // for straight flush or flush, ace became the lowest rank
        this.rank = r;
    }
    @Override
    public String toString() {

        String cardString;

        switch (this.suit) {
            case 1:
                cardString = "D";
                break;

            case 2:
                cardString = "C";
                break;

            case 3:
                cardString = "H";
                break;

            case 4:
                cardString = "S";
                break;

            default:
                cardString = "Invalid suit";
                break;
        }

        switch (this.rank) {
            case 1:  // in case for straight flush/flush
                cardString += "A";
                break;

            case 2:
                cardString += "2";
                break;

            case 3:
                cardString += "3";
                break;

            case 4:
                cardString += "4";
                break;

            case 5:
                cardString += "5";
                break;

            case 6:
                cardString += "6";
                break;

            case 7:
                cardString += "7";
                break;

            case 8:
                cardString += "8";
                break;

            case 9:
                cardString += "9";
                break;

            case 10:
                cardString += "10";
                break;

            case 11:
                cardString += "J";
                break;

            case 12:
                cardString += "Q";
                break;

            case 13:
                cardString += "K";
                break;

            case 14:
                cardString += "A";
                break;
            default:
                cardString = "Invalid suit";
                break;
        }

        return cardString;
    }
}
