package sk.uniba.fmph.dcs;

import java.util.ArrayList;

public class AtLeastNEmptyDecks implements EndGameStrategy{

    ArrayList<BuyDeck> buyDecks;

    public AtLeastNEmptyDecks(ArrayList<BuyDeck> buyDecks){
        this.buyDecks=buyDecks;
    }
    @Override
    public boolean isGameOver() {
        int count = 0;
        for (BuyDeck x: buyDecks) {
            if(x.isEmpty()) count++;
        }
        return count>2 || buyDecks.get(1).isEmpty(); //index 1 is Estate, which I used as replacement for Province, as we lack that one
    }
}
