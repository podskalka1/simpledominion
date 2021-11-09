package sk.uniba.fmph.dcs;

import java.util.ArrayList;
import java.util.Arrays;

public class Turn {
    TurnStatus turnStatus;
    DiscardPile discardPile;
    Deck deck;
    Hand hand;
    Play play;
    ArrayList<BuyDeck> buyDecks;


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
        play = new Play();
        buyDecks = new ArrayList<>(Arrays.asList(
            new BuyDeck(10,GameCardType.GAME_CARD_TYPE_MARKET),
            new BuyDeck(12,GameCardType.GAME_CARD_TYPE_ESTATE),
            new BuyDeck(16,GameCardType.GAME_CARD_TYPE_COPPER),
            new BuyDeck(10,GameCardType.GAME_CARD_TYPE_SMITHY),
            new BuyDeck(10,GameCardType.GAME_CARD_TYPE_VILLAGE),
            new BuyDeck(10,GameCardType.GAME_CARD_TYPE_FESTIVAL),
            new BuyDeck(10,GameCardType.GAME_CARD_TYPE_LABORATORY)
        ));



    }

    public void setTurnStatus(TurnStatus turnStatus) {
        this.turnStatus = turnStatus;
    }
}
