package sk.uniba.fmph.dcs;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private ArrayList<CardInterface> cards = new ArrayList<>();
    private final DiscardPile discard; //reference to discard pile

    public Deck(DiscardPile discard){
        this.discard = discard;
    }

    List<CardInterface> draw(int count){
        ArrayList<CardInterface> retrn = new ArrayList<>();
        for(int i = 0;i<count;i++){
            if(cards.size()==0){
                cards = new ArrayList<>(discard.shuffle());
            }
            retrn.add(cards.remove(cards.size()-1));
        }
        return retrn;
    }
}
