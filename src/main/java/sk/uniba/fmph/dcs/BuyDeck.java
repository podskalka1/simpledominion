package sk.uniba.fmph.dcs;

import java.util.List;
import java.util.Optional;

public class BuyDeck {
    private int cardCount;
    private GameCardType type;

    public BuyDeck(int cardCount, GameCardType type){
        this.cardCount = cardCount;
        this.type = type;
    }

    public Optional<CardInterface> buy(){
        cardCount--;
        return Optional.of(new GameCard(type));
    }

    public boolean isEmpty(){
        return cardCount<1;
    }

    public int getCost(){
        return type.getCost();
    }
}
