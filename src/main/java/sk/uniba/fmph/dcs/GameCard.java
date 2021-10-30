package sk.uniba.fmph.dcs;

public class GameCard implements CardInterface{

    private final GameCardType type;

    public GameCard(GameCardType type){
        this.type=type;
    }

    @Override
    public void evaluate(TurnStatus ts) {
        if(type.isAction){ //usage of non-action cards (treasures, victory cards aren't played) should not cost actions
            ts.actions--;
        }
        ts.actions += type.plusActions;
        ts.buys += type.plusBuys;
        ts.coins += type.plusCoins;
        // plus cards will be drawn just after evaluation at place where it is evaluated
        // cost will be taken into consideration while buy phase, points will be counted somewhere else too
    }

    @Override
    public GameCardType cardType() {
        return type;
    }
}
