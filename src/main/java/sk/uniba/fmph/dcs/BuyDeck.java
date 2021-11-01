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
        cardCount--;
        return new GameCard(type);
    }

    public boolean isEmpty(){
        return cardCount==0;
    }

    public int getCost(){
        return type.getCost();
    }
}
