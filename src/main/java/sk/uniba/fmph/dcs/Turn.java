package sk.uniba.fmph.dcs;

import java.util.ArrayList;

public class Turn {
    TurnStatus turnStatus;
    DiscardPile discardPile;
    Deck deck;
    Hand hand;
    BuyDeck market;
    BuyDeck estate;
    BuyDeck copper;
    BuyDeck smithy;
    BuyDeck village;
    BuyDeck festival;
    BuyDeck laboratory;

    public Turn(TurnStatus turnStatus){
        this.turnStatus = turnStatus;
        ArrayList<CardInterface> initialDeck = new ArrayList<>();
        for(int i = 0;i<3;i++){
            initialDeck.add(new GameCard(GameCardType.GAME_CARD_TYPE_ESTATE));
        }
        for(int i = 0;i<7;i++){
            initialDeck.add(new GameCard(GameCardType.GAME_CARD_TYPE_COPPER));
        }
        discardPile = new DiscardPile(initialDeck);

        deck = new Deck(discardPile);
        hand = new Hand(deck);

        market = new BuyDeck(10,GameCardType.GAME_CARD_TYPE_MARKET);
        estate = new BuyDeck(12,GameCardType.GAME_CARD_TYPE_ESTATE);
        copper = new BuyDeck(16,GameCardType.GAME_CARD_TYPE_COPPER);
        smithy = new BuyDeck(10,GameCardType.GAME_CARD_TYPE_SMITHY);
        village = new BuyDeck(10,GameCardType.GAME_CARD_TYPE_VILLAGE);
        festival = new BuyDeck(10,GameCardType.GAME_CARD_TYPE_FESTIVAL);
        laboratory = new BuyDeck(10,GameCardType.GAME_CARD_TYPE_LABORATORY);


    }

    public void setTurnStatus(TurnStatus turnStatus) {
        this.turnStatus = turnStatus;
    }
}
