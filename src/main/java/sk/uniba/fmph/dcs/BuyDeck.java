package sk.uniba.fmph.dcs;

import java.util.List;

public class BuyDeck {
    private int cardCount;
    private GameCardType type;

    public BuyDeck(int cardCount, GameCardType type){
        this.cardCount = cardCount;
        this.type = type;
    }

    public CardInterface buy(){
        if (cardCount>0){
            cardCount--;
            return new GameCard(type);
        }
        else return null;
    }
}
