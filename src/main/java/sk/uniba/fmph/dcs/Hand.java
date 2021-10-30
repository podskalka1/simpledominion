package sk.uniba.fmph.dcs;

import java.util.ArrayList;

public class Hand {
    public ArrayList<CardInterface> cards;

    Deck deck;

    public Hand(Deck deck){
        this.deck = deck;
        cards = new ArrayList<>(deck.draw(5));
    }

    public Boolean isActionCard(int idx){
        if(idx>0 && idx< cards.size()) return cards.get(idx).cardType().isAction();
        else return null;
    }

    public CardInterface play(int idx){
        if(idx>0 && idx< cards.size()) return cards.remove(idx);
        else return null;
    }

    public void draw(int count){
        cards.addAll(deck.draw(count));
    }
}
