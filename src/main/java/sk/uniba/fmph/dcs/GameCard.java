package sk.uniba.fmph.dcs;


public class GameCard implements CardInterface{

    private final GameCardType type;

    public GameCard(GameCardType type){
        this.type=type;
    }

    @Override
    public int evaluate(TurnStatus ts) {
        if(type.isAction()){ //usage of non-action cards (treasures, victory cards aren't played) should not cost actions
            ts.actions--;
        }
        ts.actions += type.getPlusActions();
        ts.buys += type.getPlusBuys();
        ts.coins += type.getPlusCoins();
        return type.getPlusCards();
    }

    @Override
    public GameCardType cardType() {
        return type;
    }
}
