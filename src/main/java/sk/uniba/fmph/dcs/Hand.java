package sk.uniba.fmph.dcs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Hand {
    private ArrayList<CardInterface> cards;

    private final Deck deck;

    public Hand(Deck deck){
        this.deck = deck;
        cards = new ArrayList<>(deck.draw(5));
    }

    public Boolean isActionCard(int idx){
        if(idx>0 && idx< cards.size()) return cards.get(idx).cardType().isAction();
        else return false;
    }

    public Optional<CardInterface> play(int idx){
        if(idx>=0 && idx< cards.size()) return Optional.of(cards.remove(idx));
        return Optional.empty();
    }

    public List<CardInterface> throwAll(){
        List<CardInterface> cardsToSend = cards;
        cards = new ArrayList<>();
        return cardsToSend;
    }

    public void draw(int count){
        cards.addAll(deck.draw(count));
    }
}
