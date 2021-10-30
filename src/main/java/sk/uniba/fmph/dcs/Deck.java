package sk.uniba.fmph.dcs;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    ArrayList<CardInterface> cards = new ArrayList<>();
    DiscardPile discard; //reference to discard pile

    public Deck(DiscardPile discard){
        for(int i = 0;i<3;i++){
            cards.add(new GameCard(GameCardType.GAME_CARD_TYPE_ESTATE));
        }
        for(int i = 0;i<7;i++){
            cards.add(new GameCard(GameCardType.GAME_CARD_TYPE_COPPER));
        }
        this.discard = discard;
    }

    List<CardInterface> draw(int count){
        ArrayList<CardInterface> retrn = new ArrayList<>();
        for(int i = 0;i<count;i++){
            retrn.add(cards.remove(cards.size()-1));
            if(cards.size()==0){
                cards = new ArrayList<>(discard.shuffle());
            }
        }
        return retrn;
    }
}
