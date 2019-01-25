package Main_Class_Na_Ja;

import List_Na_Ja.Card;
import List_Na_Ja.Deck;
import java.util.List;

public class BigO1AndBigOn {

    public static void main(String[] args) {
        // Test Enum
        Card x = new Card(Card.Suit.HEART, Card.Rank.THREE);
        // 
        Deck d = new Deck();
        d.randomOrder();
        int pokCount = 0;
        for (int i = 0; i < 10; i++) {
            List<Card> cardOnhands = d.getCardsOnHand(2);
            int value = cardOnhands.get(0).getValue() + cardOnhands.get(1).getValue();
            
            String pok = "";
            if (value % 10 == 8 || value % 10 == 9){
                pok = " -> POK";
                pokCount++;
            }
            
            System.out.println("[" + i + "] " + cardOnhands + pok);
        }
        System.out.println("--------------------");
        System.out.println(d.getCards());
        System.out.println("Pok count: " + pokCount);
    }

}
