package sk.uniba.fmph.dcs;

import java.util.ArrayList;

public class Hand {
    public ArrayList<CardInterface> cards;

    public Boolean isActionCard(int idx){
        if(idx>0 && idx< cards.size()) return cards.get(idx).cardType().isAction();
        else return null; 
    }

    public CardInterface play(int idx){
        if(idx>0 && idx< cards.size()) return cards.get(idx);
        else return null;
    }
}
