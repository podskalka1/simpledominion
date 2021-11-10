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
        endGameStrategy = new AtLeastNEmptyDecks(turn.buyDecks);
    }

    public boolean playCard(int handIdx){
        if(endGameStrategy.isGameOver()) return false;
        if(turn.hand.isActionCard(handIdx)&& !(turnStatus.actions >0))return false;
        Optional<CardInterface> playedCard = turn.hand.play(handIdx);
        if(playedCard.isPresent()){
            turn.hand.draw(playedCard.get().evaluate(turnStatus));
            turn.play.putTo(playedCard.get());
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
        if(turn.buyDecks.size()-1<buyCardIdx) return false;
        if(turn.buyDecks.get(buyCardIdx).getCost()>turnStatus.coins) return false;
        if(turn.buyDecks.get(buyCardIdx).isEmpty()) return false;
        Optional<CardInterface> newCard = turn.buyDecks.get(buyCardIdx).buy();
        if(newCard.isPresent()){
            turnStatus.coins=-turn.buyDecks.get(buyCardIdx).getCost();
            turnStatus.buys--;
            turn.discardPile.addCards(Collections.singletonList(newCard.get()));
            return true;
        }else return false;
    }

    public boolean endTurn(){
        if(endGameStrategy.isGameOver()) return false;
        if(!playCardPhase){
            playCardPhase=true;
                turn.discardPile.addCards(turn.hand.throwAll());
                turn.discardPile.addCards(turn.play.throwAll());
                turn.hand.draw(5);
                turnStatus = new TurnStatus();
                turn.setTurnStatus(turnStatus);
            return true;
        }
        return false;
    }


}
