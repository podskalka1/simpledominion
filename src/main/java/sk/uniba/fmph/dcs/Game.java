package sk.uniba.fmph.dcs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

public class Game {
    TurnStatus turnStatus;
    boolean playCardPhase = true;
    Turn turn;
    EndGameStrategy endGameStrategy;

    public Game(){
        turnStatus = new TurnStatus();
        turn = new Turn(turnStatus);
        endGameStrategy = new AtLeastNEmptyDecks(turn.getBuyDecks());
    }

    public boolean playCard(int handIdx){
        if(endGameStrategy.isGameOver()) return false;
        if(turn.getHand().isActionCard(handIdx)&& !(turnStatus.actions >0))return false;
        Optional<CardInterface> playedCard = turn.getHand().play(handIdx);
        if(playedCard.isPresent()){
            turn.getHand().draw(playedCard.get().evaluate(turnStatus));
            turn.getPlay().putTo(playedCard.get());
            return true;
        }
        return false;
    }

    public boolean endPlayCardPhase(){
        if(endGameStrategy.isGameOver())return false;
        if(playCardPhase){
            playCardPhase=false;
            return true;
        }
        return false;
    }

    public boolean buyCard(int buyCardIdx){
        if(endGameStrategy.isGameOver())return false;
        if(turn.getBuyDecks().size()-1<buyCardIdx) return false;
        if(turn.getBuyDeck(buyCardIdx).getCost()>turnStatus.coins) return false;
        if(turn.getBuyDeck(buyCardIdx).isEmpty()) return false;
        Optional<CardInterface> newCard = turn.getBuyDeck(buyCardIdx).buy();
        if(newCard.isPresent()){
            turnStatus.coins=-turn.getBuyDeck(buyCardIdx).getCost();
            turnStatus.buys--;
            turn.getDiscardPile().addCards(Collections.singletonList(newCard.get()));
            return true;
        }else return false;
    }

    public boolean endTurn(){
        if(endGameStrategy.isGameOver()) return false;
        if(!playCardPhase){
            playCardPhase=true;
                turn.getDiscardPile().addCards(turn.getHand().throwAll());
                turn.getDiscardPile().addCards(turn.getPlay().throwAll());
                turn.getHand().draw(5);
                turnStatus = new TurnStatus();
                turn.setTurnStatus(turnStatus);
            return true;
        }
        return false;
    }


}
