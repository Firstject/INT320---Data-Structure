package List_Na_Ja;

public class Card implements Comparable<Card> {

    public static enum Rank {
        ACE(1), DEUCE(2), THREE(3), FOUR(4),
        FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9),
        TEN(10), JACK(11), QUEEN(12), KING(13);
        private int value;

        Rank(int value) {
            this.value = value;
        }
    }

    public static enum Suit {
        HEART(1), SPADE(2), DIAMOND(3), CLUB(4);
        private int value;

        Suit(int value) {
            this.value = value;
        }
    }

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        String returnValue;
        if (rank.value == 1 || rank.value == 11 || rank.value == 12 || rank.value == 13) {
            returnValue = rank.name() + ":" + suit;
        } else {
            returnValue = rank.value + ":" + suit;
        }
        return returnValue;
    }

    public int getValue() {
        return rank.value;
    }

    @Override
    public int compareTo(Card card) {
        int dif = this.suit.value
                - card.suit.value;
        if (dif == 0) {
            dif = this.rank.value
                    - card.rank.value;
        }
        return dif;
    }
}
