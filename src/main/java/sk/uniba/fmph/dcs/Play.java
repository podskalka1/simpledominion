package sk.uniba.fmph.dcs;

import java.util.ArrayList;
import java.util.List;

public class Play {
    private ArrayList<CardInterface> cards = new ArrayList<>();

    public void putTo(CardInterface card){
        cards.add(card);
    }

    public List<CardInterface> throwAll(){
        List<CardInterface> cardsToSend = cards;
        cards = new ArrayList<>();
        return cardsToSend;
    }

}
